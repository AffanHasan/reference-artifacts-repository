/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdkhttprestserver;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
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

    public void startServer(Application app) {
        try {
            httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), 8);
        } catch (IOException ex) {
            Logger.getLogger(DefaultRestTestingServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        httpServer.createContext("/rstest", RuntimeDelegate.getInstance().createEndpoint(app, HttpHandler.class));
        httpServer.start();
    }

    public void stopServer() {
        httpServer.stop(8);
    }
    
}