package ntls.jmx;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * Trigger a System.gc
 */

public class SystemGC {

    private final static String PROTOCOL = "service:jmx:rmi:///jndi/rmi://";
    private final static String IP = "localhost";
    private final static String PORT = "9999";
    private final static String PATH = "/jmxrmi";
    
    
    public static void main(String[] args) {

        try {
            JMXServiceURL target = new JMXServiceURL(PROTOCOL + IP +":"+ PORT + PATH );
            JMXConnector connector = JMXConnectorFactory.connect(target);
            MBeanServerConnection connection = connector.getMBeanServerConnection();

            MemoryMXBean proxy =
                ManagementFactory.newPlatformMXBeanProxy(connection, ManagementFactory.MEMORY_MXBEAN_NAME, MemoryMXBean.class);
            proxy.gc();
            
            System.out.println("MemoryUsage " + proxy.getHeapMemoryUsage());
            
        } catch (IOException e) {
        }
    }
}