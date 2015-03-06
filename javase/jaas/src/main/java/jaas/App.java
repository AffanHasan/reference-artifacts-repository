package jaas;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    private static String _regexMessage = "%n Enter regex: ";
    private static String _stringMessage = "%n Enter string: ";
    private static String _message = _regexMessage;
    private static Console _console = System.console();

    public static void main( String... args ){
        boolean continueLoop = true;
        String input;
        Pattern pattern = null;
        Matcher matcher;

        while(continueLoop)
            switch (input = _console.readLine(_message)) {

                default :

                    if(_message.equals(_regexMessage)){
                        _toggleMessage();
                        pattern = Pattern.compile(input);
                    }else{
                        _toggleMessage();
                        matcher = pattern.matcher(input);
                        while(matcher.find()){
                            _console.printf("%n Pattern found starting from index: %d to index : %d value : %s"
                                    , matcher.start(), matcher.end(), matcher.group());
                        }
                        _console.printf("%n search ended...");
                    }

                    break;

                case "EXIT" : case "exit":
                    continueLoop = false;
                    break;
            }
    }

    private static void _toggleMessage(){
        _message = _message.equals(_regexMessage) ? _stringMessage : _regexMessage;
    }
}