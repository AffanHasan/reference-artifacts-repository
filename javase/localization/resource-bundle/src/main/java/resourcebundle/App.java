package resourcebundle;

import jdkhttprestserver.DefaultRestTestingServer;
import jdkhttprestserver.RestTestingServer;

public class App {

    public static void main(String... args){
        try(RestTestingServer rts = new DefaultRestTestingServer()){
            rts.startServer(new extractparameters.App());
            System.console().readLine("Press any key to stop the server\n");
        }catch( Exception e ){
        }
    }
}
