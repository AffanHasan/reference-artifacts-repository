package languagetags;

import java.util.List;
import java.util.Locale;

public class App {
    public static void main( String[] args ){
        
//        Create a language range for English Any Region
        Locale.LanguageRange lr = new Locale.LanguageRange("en-*", 0.5);
        
//      Language Range For English Language
        Locale.LanguageRange lr1 = new Locale.LanguageRange("en", 0.5);
//      Language Range For Any US Spoken Language
        Locale.LanguageRange lr2 = new Locale.LanguageRange("*-US", 0.5);
        
//      Language Priority List can be created as:
        String languageRange = "ur-PK-*,en-*;q=0.9";//By defining language range as a "csv string"
        List<Locale.LanguageRange> langPriorityList = Locale.LanguageRange.parse(languageRange);
        
//      Language Tag Lookup
    }
}