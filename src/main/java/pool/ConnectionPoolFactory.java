package pool;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPoolFactory<T extends Connection> {

    BlockingQueue<PooledConnectionProxy<T>> connectionPool= new ArrayBlockingQueue<>(10);

    private T connectionType;
    private volatile int maxNumberOfConnections=0;
    private volatile int activeBorrowedConnection=0;
    public ConnectionPoolFactory(int min, int max, T wrapperConnection) throws InterruptedException {
        maxNumberOfConnections=max;
        this.connectionType=wrapperConnection;
        for(int i=0;i<min;i++){
            connectionPool.put(new PooledConnectionProxy<T>(connectionPool,wrapperConnection));
        }
    }

    public T getConnection() throws InterruptedException {
      if(!connectionPool.isEmpty()){
          activeBorrowedConnection++;
          return connectionPool.take().getConnection();
      }else if(connectionPool.size()<=activeBorrowedConnection) {
            connectionPool.put(new PooledConnectionProxy(connectionPool,connectionType));
            return connectionPool.take().getConnection();
      }
      throw new RuntimeException("Cannot get connection");
    }

    public void addToPool(PooledConnectionProxy pooledConnectionProxy) throws InterruptedException {
             this.connectionPool.put(pooledConnectionProxy);
    }
}
