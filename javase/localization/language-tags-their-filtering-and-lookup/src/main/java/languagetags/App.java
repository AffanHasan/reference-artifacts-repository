package languagetags;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class App {
    public static void main( String[] args ){
        
//        Create a language range for English Any Region
        Locale.LanguageRange lr = new Locale.LanguageRange("en-*", 0.5);
        System.console().printf("\n Range : %s \n", lr.getRange());
        System.console().printf("\n Range : %s \n", lr.getWeight());
        
//        For English Language
        Locale.LanguageRange lr1 = new Locale.LanguageRange("en", 0.5);
//        For Any US Spoken Language
        Locale.LanguageRange lr2 = new Locale.LanguageRange("*-US", 0.5);
        
//      Language Priority List can be created as:
        String languageRange = "ur-PK-*;q=1.0,en-*;q=0.9";
        List<Locale.LanguageRange> langPriorityList = Locale.LanguageRange.parse(languageRange);
        
        System.console().printf("\n Priority list creation \n");
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        map.put("zh", Arrays.asList( new String[]{ "ar-BH", "ar-SA" } ));
        
        List<Locale.LanguageRange> range = Locale.LanguageRange.parse("zh;q=1.0", map);
        
        for( Locale.LanguageRange item : range){
            System.console().printf("\n item :  %s \n", item.getRange());
        }
        
    }
}