package capriotti.anthony.Inner_Classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by anthonycapriotti on 2/2/17.
 */
public class ConnectionManagerTest {
    ConnectionManager connectionManager;
    Connection connection;

    @Before
    public void setUp(){
        connectionManager = new ConnectionManager(2);
        connection = connectionManager.buildConnection("1.1.1.1", 5555, "http");
    }

    @Test
    //testing build with ip and port testing via number of connections method
    public void buildConnectionTwoParametersTestIp(){
      String expected = "1.1.1.2";
      String actual = connectionManager.buildConnection("1.1.1.2", 0, "http").getIp();
      assertEquals("shoudl retuyrn ip", expected, actual);
    }

    @Test
    public void buildConnectionTwoParametersTestByPort(){
        int expected = 0;
        int actual = connectionManager.buildConnection("1.1.1.2", 0, "http").getPort();
        assertEquals("should return port 0", expected, actual);
    }

    @Test
    //testing build with 3 parameters
    public void buildConnectionThreeParametersTestIp(){
        String expected = "1.1.1.2";
        String actual =connectionManager.buildConnection("1.1.1.2", 1, "protocol").getIp();
        assertEquals("will return ip", expected, actual);

    }

    @Test
    //testing build with 3 parameters port
    public void buildConnectionThreeParametersTestByPort(){
        int expected = 0;
        int actual = connectionManager.buildConnection("ip", 0, "protocol").getPort();
        assertEquals("returns port with gettting by 3 parameters", expected, actual);
    }

    @Test
    //testing build with 3 parameters protocol
    public void buildConnectionThreeParametersTestByProtocol(){
        String expectd = "protocol";
        String actual = connectionManager.buildConnection("ip", 0, "protocol").getProtocol();
        assertEquals("returns port build with 3 parameters", expectd, actual);
    }

    @Test
    //testing 2 parameters protocol and port
    public void buildConnectionTwoParametersProtocolTest(){
        String expected = "protocol";
        String actual = connectionManager.buildConnection("ip", 0000,"protocol").getProtocol();
        assertEquals("retruns protocol", expected, actual);
    }

    @Test
    //testing 2 parameter build protocol and IP
    public void buildConnectionTwoParametersIpTest(){
        String expected = "ip";
        String actual = connectionManager.buildConnection("ip", 0000, "protocol").getIp();
        assertEquals("returns ip", expected, actual);
    }

    @Test
    public void testingConnectionMaxNull(){
        connectionManager.buildConnection("ip", 0000 , "protocl");
        Connection expected = null;
        Connection actual = connectionManager.buildConnection("ip", 0000 , "ptoyocol");
        assertNull(connectionManager.buildConnection("ip", 0000, "protocl"));
    }

    @Test
    public void tesingConnectionMaxFull(){
        connectionManager.buildConnection("ip", 0000 , "protocol");
        Boolean actual = connectionManager.checkMaxConnection();
        assertTrue("shoudl return false", actual);
    }

    @Test
    public void testingConnectionTest(){
        String expected = "Connected to IP port protocoll";
        String actual = connection.connect();
        assertEquals("Stuff", expected, actual);

    }





}
