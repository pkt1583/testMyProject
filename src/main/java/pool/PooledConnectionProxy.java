package pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.BlockingQueue;

/**
 * Created by pankaj on 4/9/16.
 */
public class PooledConnectionProxy<T extends Connection> {

    private T actualConnection;
    private volatile boolean isClosed=false;
    private BlockingQueue<PooledConnectionProxy<T>> connnectionPool;

    public PooledConnectionProxy(BlockingQueue<PooledConnectionProxy<T>> connnectionPool, T actualConnection) {
        this.connnectionPool = connnectionPool;
        this.actualConnection = actualConnection;
    }

    public T getConnection() {
        if (Proxy.isProxyClass(actualConnection.getClass())) {
            return actualConnection;
        } else {
            return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Connection.class}, new ProxyConnectionHandler());
        }
    }

    private class ProxyConnectionHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
           // if (!isClosed) {
                /*if (method.getName().equals("close")) {
                    isClosed = true;
                    return null;
                  //  connnectionPool.add(this.parent);
                } else {
                    return method.invoke(proxy, args);
                }*/

                if(method.getDeclaringClass().isAssignableFrom(proxy.getClass())) {
                    return method.invoke(proxy, args);
                }
                return null;

            /*} else {
                throw new RuntimeException("The connection for class " + actualConnection + " is closed");
            }*/
        }
    }
}
