package pool

import org.junit.Test

import java.util.concurrent.*

class ConnectionSomePoolFactoryTest extends GroovyTestCase {
    ConnectionPoolFactory connectionPoolFactory = new ConnectionPoolFactory(5, 10, new MyDefaultConnection())

    @Test
    void testAddToPool() {
        ThreadPoolExecutor cachedThreadPoolExecutor = Executors.newCachedThreadPool()
        ExecutorCompletionService completionService = new ExecutorCompletionService(cachedThreadPoolExecutor)
        List<Future<String>> futures = new ArrayList<>();
        futures.add(completionService.submit(
                new Consumer()

        ))
        println "The size of futures is " + futures.size()
        futures.size().times {
            String ouput = completionService.take().get()
            println ouput
        }

        /* PooledConnectionProxy pooledConnection = new PooledConnectionProxy()
         try {
             3.times {
                 connectionPoolFactory.addToPool(pooledConnection)
             }
             println connectionPoolFactory.connectionPool.size()
         } catch (QueueFullException exception) {
             println "Excepted Exception occured"
         }*/
    }

    class Consumer implements Callable<String> {
        @Override
        String call() throws Exception {
            println "Calling Callable Call method"
            PooledConnectionProxy pooledConnection = connectionPoolFactory.getConnection();
            //  pooledConnection.sleep(1000)
            return pooledConnection.toString()
        }
    }


}
