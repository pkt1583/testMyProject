package myPool

/**
 * Created by pankaj on 17/9/16.
 */
@Singleton
class PoolableObjectFactory {

    private volatile int id=0;
    def getNewObject(){
        id++
        return new PoolableObject(id:id)
    }
}
