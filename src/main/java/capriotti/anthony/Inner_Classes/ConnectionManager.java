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


    public  Connection buildConnection(String ip, String protocol){
        return null;
    }

    public Connection buildConnection(String ip, int port, String protocol){
        return null;
    }

    public Connection buildConnection(String ip, int port){
        return null;
    }

    public boolean checkMaxConnection(){
        return false;
    }


    class ManagedConnection implements Connection{
         private String ip, protocol;
         private int port;
         boolean closed;

         ManagedConnection(String ip, int port, String protocol){
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

         public void close(){}

         public boolean isClosed(){
             return false;
         }
     }






}
