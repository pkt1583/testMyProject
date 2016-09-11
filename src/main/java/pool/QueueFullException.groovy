package pool

/**
 * Created by pankaj on 9/11/2016.
 */
class QueueFullException extends RuntimeException {
    QueueFullException() {
        super()
    }

    QueueFullException(String s) {
        super(s)
    }

    QueueFullException(String s, Throwable throwable) {
        super(s, throwable)
    }

    QueueFullException(Throwable throwable) {
        super(throwable)
    }

    protected QueueFullException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1)
    }
}
