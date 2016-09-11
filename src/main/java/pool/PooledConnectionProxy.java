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
            return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Connection.class}, new ProxyConnectionHandler(this));
        }
    }

    private class ProxyConnectionHandler implements InvocationHandler {
        PooledConnectionProxy parent;

        private ProxyConnectionHandler(PooledConnectionProxy parent) {
            this.parent = parent;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            /*if (method.getName().equals("toString")) {
             //   System.out.println( "Calling from "+proxy);
                return "One";
            }*/
            if (!isClosed) {
                if (method.getName().equals("close")) {
                    isClosed = true;
                  //  connnectionPool.add(this.parent);
                } else {
                    return method.invoke(proxy, args);
                }

            } else {
                throw new RuntimeException("The connection for class " + actualConnection + " is closed");
            }
            return null;
        }
    }
}
