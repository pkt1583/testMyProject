package practise;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {
    private BlockingQueue<WrappedConnection> connections = new LinkedBlockingDeque<>();
    private int maxSize = 10;

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.initialize(6);
    }

    private void initialize(int initialConnection) {
        for (int i = 0; i < initialConnection; i++) {
            WrappedConnection wrappedConnection = new WrappedConnection(this);
            connections.add(wrappedConnection);
        }
    }

    private void retrunToPool(WrappedConnection connection) {
        if (connections.size() < maxSize) {
            try {
                connections.put(connection);
            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }
        }
    }

    public WrappedConnection getConnection() {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private class WrappedConnection {

        private ConnectionPool connectionPool;

        private Object realConnection;
        private boolean isOpen;

        public WrappedConnection(ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
        }

        public boolean close() {
            if (isOpen) {
                connectionPool.retrunToPool(this);
                return true;
            } else {
                return false;
            }
        }

        public boolean open(){
            if(isConnected(realConnection)){
                return true;
            }else {
                return false;
            }
        }

        private boolean isConnected(Object realConnection) {
            return true;
        }
    }
}
