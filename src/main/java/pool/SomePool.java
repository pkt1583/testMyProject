package pool;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pankaj on 4/9/16.
 */
public class SomePool<T> {

    private static SomePool _instance ;
    private BlockingQueue<T> poolQueue;
    private volatile int initialSize;
    private volatile int maxSize;
    private AtomicInteger currentBorrowedInstance = new AtomicInteger(0);

    protected Logger logger= Logger.getLogger(getClass());
    private SomePool(int initialSize, int maxSize) {
        logger.info("Initializing pool with maxSize "+maxSize);
        poolQueue = new ArrayBlockingQueue<T>(maxSize);
        this.initialSize = initialSize;
        this.maxSize = maxSize;
    }

    public T borrowInstance() {
        try {
            if (!poolQueue.isEmpty()) {
                currentBorrowedInstance.getAndIncrement();
                return poolQueue.take();
            } else if (currentBorrowedInstance.get() < maxSize) {
                return (T) new PoolableObject<T>();
            } else {
                return poolQueue.take(); //wait till available
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized boolean addInstance(T instance) throws InterruptedException {
        if (currentBorrowedInstance.get() == maxSize) {
            return false;
        } else {
            currentBorrowedInstance.getAndDecrement();
            return poolQueue.add((T) new PoolableObject<T>());
        }
    }
}


class PoolableObject<T> {
    T actualObject;
}
