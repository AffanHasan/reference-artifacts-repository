package jdkhttprestserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetSocketAddress;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.RuntimeDelegate;

/**
 *
 * @author Affan Hasan
 */
public class DefaultRestTestingServer implements RestTestingServer{
    
    private HttpServer httpServer;

    @Override
    public void close() throws Exception {
        stopServer();
    }

    
    private class DefaultHttpHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange he) throws IOException {
           String response = "Server is running";
           he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
           os.write(response.getBytes());
           os.close();
        }
        
    }
    
    private int bindServer(){
        int port = 8080;
        for(;;){
            try {
                bindServer(port);
                break;
            } catch (BindException ex) {
                port++;
                continue;
            }
        }
//      Create Default Context
        httpServer.createContext("/", new DefaultHttpHandler());
        return port;
    }
    
    private void bindServer(int port) throws BindException{
        try {
            httpServer = HttpServer.create(new InetSocketAddress("localhost", port), 1);
        } catch (IOException ex) {
            throw new java.net.BindException();
        }
    }
    
    @Override
    public int startServer(Application app, String appContextName) {
        int port = bindServer();
        httpServer.createContext("/"+appContextName, RuntimeDelegate.getInstance().createEndpoint(app, HttpHandler.class));
        httpServer.start();
        return port;
    }
    
    @Override
    public int startServer(Application app) {
        int port = bindServer();
        httpServer.createContext("/" + app.getClass().getAnnotation(ApplicationPath.class).value(), RuntimeDelegate.getInstance().createEndpoint(app, HttpHandler.class));
        httpServer.start();
        return port;
    }

    @Override
    public void stopServer() {
        httpServer.stop(1);
    }
    
}