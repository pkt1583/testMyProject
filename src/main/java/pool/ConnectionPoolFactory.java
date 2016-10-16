package pool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPoolFactory<U extends Connection> {

    protected Logger logger = Logger.getLogger(getClass());
    ArrayBlockingQueue<PooledConnectionDelegate<U>> connectionPool;
    private U connectionType;
    private volatile int maxNumberOfConnections = 0;
    private volatile int activeBorrowedConnection = 0;

    public ConnectionPoolFactory(int min, int max, U wrapperConnection) throws InterruptedException {
        logger.info("Initializing Connection pool");
        maxNumberOfConnections = max;
        this.connectionType = wrapperConnection;
        connectionPool = new ArrayBlockingQueue<PooledConnectionDelegate<U>>(10);
        for (int i = 0; i < min; i++) {
            PooledConnectionDelegate<U> pooledConnectionDelegate=new PooledConnectionDelegate(new MyDefaultConnection(),i);
            logger.debug("Initialized connection with id "+pooledConnectionDelegate.getId());
            connectionPool.put(pooledConnectionDelegate);
        }
    }

    public PooledConnectionDelegate<U> getConnection() throws InterruptedException {
        /*logger.info("Returing Connection to Client ");
        if (!connectionPool.isEmpty()) {
            activeBorrowedConnection++;
            PooledConnectionDelegate<U> pooledConnectionDelegate=connectionPool.take();  //This also should be wrapped
            return connectionPool.take().getConnection();
        } else if (connectionPool.size() <= activeBorrowedConnection) {
            connectionPool.put(new PooledConnectionProxy(connectionPool, connectionType));
            return connectionPool.take().getConnection();
        }
        throw new RuntimeException("Cannot get connection");*/
        return null;
    }

    public void addToPool(PooledConnectionDelegate<U> pooledConnectionProxy) throws InterruptedException {
        this.connectionPool.put(pooledConnectionProxy);
    }
}
