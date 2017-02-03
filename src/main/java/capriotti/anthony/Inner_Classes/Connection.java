package capriotti.anthony.Inner_Classes;

import java.io.Closeable;

/**
 * Created by anthonycapriotti on 2/2/17.
 */
public interface Connection extends Closeable {

    public String connect();

    public String getIp();

    public String getProtocol();

    public int getPort();

    boolean isClosed();
}
