package myPool

import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorCompletionService
import java.util.concurrent.Executors
import java.util.concurrent.Future


/**
 * Created by pankaj on 17/9/16.
 */
class SomePoolTest extends GroovyTestCase {

    @Test
    void testInitialization() {
        log.info("Testing Initialization")
        def pool = new Pool(4, 10, PoolableObjectFactory.instance)
        assertEquals(4, pool.getCurrentQueueSize())
    }

    @Test
    void testGetConnection() {
        log.info("Checking get connection")
        def pool = new Pool(2, 5, PoolableObjectFactory.instance)
        2.times {
            pool.getObject()
        }
        assertEquals(0,  pool.currentQueueSize)
        3.times {
            assertNotNull(pool.getObject())
        }
    }

    @Test
    void testMultiThreadGetConnection(){
        log.info("Testing multithread get Connection")
        def pool=new Pool(10,500,PoolableObjectFactory.instance)
        ExecutorCompletionService<String> executorCompletionService= new ExecutorCompletionService<>(Executors.newFixedThreadPool(8))
        List<Future<String >> futureList=new ArrayList<>()
         5.times {
            100.times {
               futureList.add( executorCompletionService.submit(new Callable<String>() {
                    @Override
                    String call() throws Exception {
                        def someObject=pool.getObject()
                    }
                }))
            }
        }
        futureList.size().times {
            executorCompletionService.take().get()
        }
        println pool.currentQueueSize
        int totalNumberOfConnections=pool.objectsInUse.get()
        println pool.dump()
        println "total number of connections given $totalNumberOfConnections"
    }

    @Rule
    public ExpectedException expectedException=ExpectedException.none()

    @Ignore
    def testTooManyConnection() throws Exception{
        expectedException.expect(RuntimeException.class)
        log.info("Checking too many get connection")
        def pool = new Pool(2, 5, PoolableObjectFactory.instance)
        6.times {
            pool.getObject()
        }
    }
}
