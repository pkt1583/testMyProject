package myPool

import org.apache.log4j.Logger

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by pankaj on 17/9/16.
 */
class Pool {
    int minSize
    int maxSize
    private BlockingQueue<PoolableObject> queue
    def logger = Logger.getLogger(getClass())
    def objectsInUse = new AtomicInteger(0)
    PoolableObjectFactory factory

    Pool(int minSize, int maxSize, PoolableObjectFactory factory) {
        logger.info("Initializing pool with size $minSize and maxSize $maxSize")
        queue = new ArrayBlockingQueue<>(maxSize)
        this.factory = factory
        this.minSize = minSize
        this.maxSize = maxSize
        minSize.times {
            def poolabelObject = factory.getNewObject()
            logger.debug("Adding connection $poolabelObject.id ")
            queue.add(poolabelObject)
        }
    }

    def getObject() {
        Thread.sleep(50)
        if (!queue.isEmpty()) {
            objectsInUse.getAndIncrement()
            return queue.take()
        } else if (objectsInUse.get() != maxSize) {
            logger.debug("Pool exhausted. adding new Connection")
            def pooledConnection = factory.newObject
            objectsInUse.getAndIncrement()
            return pooledConnection
        } else {
            logger.debug("Got too many calls for getObject")
            throw new RuntimeException("No connection available. Waiting implementation pendings")
        }
    }

    def returnToPool(PoolableObject poolableObject) {
        if (objectsInUse.get() == 0) {
            throw new RuntimeException("What are you returning. You haven't taken any connection")
        }
        if (queue.size() == maxSize) {
            throw new RuntimeException("Already queue is full")
        }
        queue.offer(poolableObject)
        objectsInUse.getAndDecrement()
    }

    def getCurrentQueueSize() {
        return queue.size()

    }

}
