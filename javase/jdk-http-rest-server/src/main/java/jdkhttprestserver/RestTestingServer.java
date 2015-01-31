package jdkhttprestserver;

import javax.ws.rs.core.Application;

public interface RestTestingServer{

    public void startServer(Application app);
    
    public void stopServer();
}
