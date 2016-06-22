package jmx

import javax.management.MBeanInfo
import javax.management.MBeanServer
import javax.management.ObjectInstance
import javax.management.ObjectName
import java.lang.management.ManagementFactory

/**
 * Created by pankaj on 22-06-2016.
 */
class JmxExplorer {
    public static void main(String[] args) {
        MBeanServer mBeanServer=ManagementFactory.getPlatformMBeanServer();
        mBeanServer.getDomains().each { domains->
            println "processing for $domains"
            ObjectName tempObjectName=new ObjectName(domains+":*")
            mBeanServer.queryMBeans(tempObjectName,null).each { objectInstance->
                MBeanInfo mBeanInfo= mBeanServer.getMBeanInfo(objectInstance.getObjectName())
                println "The Mean  is "+mBeanInfo.attributes
            }

        }
    }
}
