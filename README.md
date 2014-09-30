Instrumenting Your Own Java Applications.
Monitoring and Management Using a programmatic JMX Client.


  The aim of this example is to show the basic features of the JMX technology
  first by performing operations using a programmatic JMX client.

 Start your Main application with the out-of-the-box management agent for remote
 management enabled (authentication and encryption have been disabled to
 simplify the example but this is discouraged in production environments)


java -Dcom.sun.management.jmxremote.port=9999 \
     -Dcom.sun.management.jmxremote.authenticate=false \
     -Dcom.sun.management.jmxremote.ssl=false \
     com.example.Main

 Start the JMX client application on a different shell window on the same host


java ntls.jmx.SystemGC
