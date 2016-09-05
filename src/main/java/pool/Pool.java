package pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pankaj on 4/9/16.
 */
public class Pool<T> {

    private static Pool _instance = new Pool();
    private BlockingQueue<T> poolQueue;
    private volatile int initialSize;
    private volatile int maxSize;
    private AtomicInteger currentBorrowedInstance = new AtomicInteger(0);

    private Pool() {
        poolQueue = new ArrayBlockingQueue<T>(initialSize);
        this.initialSize = initialSize;
        this.maxSize = maxSize;
    }

    public static final Pool getInstance() {
        synchronized (Pool.class) {
            if (_instance != null) {
                return _instance;
            } else {
                return new Pool();
            }
        }
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
