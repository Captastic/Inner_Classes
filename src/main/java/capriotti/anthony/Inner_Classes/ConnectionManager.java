package capriotti.anthony.Inner_Classes;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by anthonycapriotti on 2/2/17.
 */
public class ConnectionManager{

     private final int MAX_CONNECTION;
     private int currentOpenConnections;
     ArrayList<Connection> managedConnection = new ArrayList<>();

     ConnectionManager(int max){
        this.MAX_CONNECTION = max;
     }


    public Connection buildConnection(String ip, int port, String protocol){
        if (!checkMaxConnection()){
            if (port < 0 || port > 65535)
                port = 0000;
            Connection connection = new ManagedConnection(ip, port, protocol);
            managedConnection.add(connection);
            currentOpenConnections++;
            return connection;
        } else
            return null;
    }


    public boolean checkMaxConnection(){
        return false;
    }

    public Connection getConnection(String ip, int port){
        for (Connection connection : this.managedConnection){
            if (ip.equals(connection.getIp()) && port == connection.getPort())
                return connection;
        }
        return null;
    }

    public Connection getConnection (String ip, String protocol){
        for (Connection connection : this.managedConnection){
            if (ip.equals(connection.getIp()) && protocol.equals(connection.getProtocol()))
            return connection;
        }
        return null;
    }

    public Connection getConnection(String ip, int port, String protocl){
        for (Connection connection : this.managedConnection){
            if (ip.equals(connection.getIp()) && port == connection.getPort() && protocl.equals(connection.getProtocol()))
                return connection;
        }
        return null;
    }


    class ManagedConnection implements Connection{
         private String ip, protocol;
         private int port;
         boolean closed;

         ManagedConnection(String ip, int port, String protocol){
             switch (protocol.toLowerCase()){
                 case "rip":
                 case "tcp/ip": this.protocol = protocol;
                 break;
                 default: this.protocol = "http";
             }
             this.ip = ip;
             this.port = port;
             this.protocol = protocol;
             closed = false;

         }

         public String getIp() {
             return ip;
         }

         public String getProtocol() {

             return protocol;
         }

         public int getPort() {
             return port;
         }

         public String connect(){
             return "Connected to " + getIp() + " : " + getPort() + " via " + getProtocol();
         }

         public void close(){
             this.closed = true;
             currentOpenConnections--;
         }

         public boolean isClosed(){
             return this.closed;
         }
     }






}
