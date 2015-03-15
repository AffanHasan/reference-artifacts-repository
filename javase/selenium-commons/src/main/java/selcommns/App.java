package selcommns;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;

class App{

    public static void main( String[] args ){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\\");
        new ChromeDriver();
    }
}