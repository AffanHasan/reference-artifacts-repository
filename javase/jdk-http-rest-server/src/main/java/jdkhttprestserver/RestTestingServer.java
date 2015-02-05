package jdkhttprestserver;

import javax.ws.rs.core.Application;

public interface RestTestingServer extends AutoCloseable{

    /**
     * 
     * @param app : The JAX-RS rest application
     * @return Returns the port number to which the server is listening to
     */
    public int startServer(Application app);
    
    /**
     * 
     * @param appContextName : The JAX-RS rest application name
     * @return Returns the port number to which the server is listening to
     */
    public int startServer(Application app, String appContextName);
    
    public void stopServer();
}
