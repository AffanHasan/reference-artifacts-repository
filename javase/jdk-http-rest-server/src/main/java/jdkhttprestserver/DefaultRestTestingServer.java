/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdkhttprestserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.RuntimeDelegate;

/**
 *
 * @author Affan Hasan
 */
public class DefaultRestTestingServer implements RestTestingServer{
    
    private HttpServer httpServer;
    
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
    
    private void bindServer(int port) throws BindException{
        try {
            httpServer = HttpServer.create(new InetSocketAddress("localhost", port), 1);
        } catch (IOException ex) {
            throw new java.net.BindException();
        }
    }
    
    @Override
    public void startServer(Application app) {
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
//      Default Context
        httpServer.createContext("/", new DefaultHttpHandler());
//      Our Under Test JA Services Context
        httpServer.createContext("/rstest", RuntimeDelegate.getInstance().createEndpoint(app, HttpHandler.class));
        httpServer.start();
    }

    @Override
    public void stopServer() {
        httpServer.stop(1);
    }
    
}