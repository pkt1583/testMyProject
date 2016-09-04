package pool;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by pankaj on 4/9/16.
 */
public class ConnectionPoolFactory {

    private BlockingQueue<PooledConnection> connectionPool=new ArrayBlockingQueue<PooledConnection>(10);

    private volatile int maxNumberOfConnections=0;
    private volatile int activeBorrowedConnection=0;
    public ConnectionPoolFactory(int min,int max,Connection wrapperConnection){
        maxNumberOfConnections=max;
        for(int i=0;i<min;i++){
            connectionPool.offer(new PooledConnection<MyDummyConnection>(connectionPool));
        }
    }

    public PooledConnection getConnection() throws InterruptedException {
      if(!connectionPool.isEmpty()){
          activeBorrowedConnection++;
          return connectionPool.take();
      }else if(connectionPool.size()<=activeBorrowedConnection) {
            connectionPool.offer(new PooledConnection(connectionPool));
            return connectionPool.take();
      }
      throw new RuntimeException("Cannot get connection");
    }

    public boolean addToPool(PooledConnection pooledConnection){
        return this.connectionPool.add(pooledConnection);
    }
}
