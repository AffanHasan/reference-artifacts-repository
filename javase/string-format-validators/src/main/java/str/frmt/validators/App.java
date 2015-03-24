package str.frmt.validators;

import java.util.Arrays;
import java.util.regex.Matcher;

/**
 * Created by root on 3/5/15.
 */
public class App {

    public static void main(String... args){

        System.out.println("\t Here we go......... \f after \\f.\r Now after \\r");
        Matcher matcher = null;
        App a = new App();

        System.out.printf(Arrays.toString(a.getClass().getName().split("\\Q.\\E")));
    }
}