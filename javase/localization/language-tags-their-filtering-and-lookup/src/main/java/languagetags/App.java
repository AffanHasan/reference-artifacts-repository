package languagetags;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class App {
    public static void main( String[] args ){
        
//      Invalid language range
//        Locale.LanguageRange lrAllLangs1 = new Locale.LanguageRange(".");
        
//      Invalid language range
//        Locale.LanguageRange lrAllLangs1 = new Locale.LanguageRange("en*");
        
////      Invalid language range
//        Locale.LanguageRange lrAllLangs1 = new Locale.LanguageRange("en_US*");
        
//      Invalid language range
//        Locale.LanguageRange lrAllLangs2 = new Locale.LanguageRange("*.*");
        
//      Create a language range for English Any Region
        Locale.LanguageRange lr = new Locale.LanguageRange("en-*", Locale.LanguageRange.MIN_WEIGHT);
        
//      Language Range For English Language
        Locale.LanguageRange lr1 = new Locale.LanguageRange("en", 0.5);
        
//      Language Range For Any US Spoken Language
        Locale.LanguageRange lr2 = new Locale.LanguageRange("*-US", Locale.LanguageRange.MAX_WEIGHT);
        
//      Language Priority List can be created as:
        String languageRange = "ur-PK-*,en-*;q=0.9";//By defining language range as a "csv string"
        List<Locale.LanguageRange> langPriorityList = Locale.LanguageRange.parse(languageRange);
        
//      -------------------------------------------------------------------------------------------------
//      Process of filtering language tags
//      -------------------------------------------------------------------------------------------------
        Collection<Locale> availableLocales = Arrays.asList( 
                new Locale[]//Create a Collection of locales
                { 
                    new Locale("fr", "CA"),
                    Locale.TAIWAN,
//                  Any language spoken in the city of Karachi, Pakistan
                    Locale.forLanguageTag("ur-PK-KHI"),
//                  French spoken in any region of the world
                    new Locale.Builder().setLanguageTag("sd-PK").build()
                });
        
//      Create a language LanguagePriorityList
        List<Locale.LanguageRange> userPriorityLst = Locale.LanguageRange.parse("*-PK;q=0.9,fr-*;q=1.0");
//      Now Filtering
        List<Locale> localeList =  Locale.filter(userPriorityLst, availableLocales);
        for( Locale locale : localeList){
            System.console().printf("\nLocale : %s\n", locale.getLanguage());
        }
        
//      OUT PUT:
//      --------
//      Locale : fr

//      Locale : ur
//
//      Locale : sd

//      -------------------------------------------------------------------------------------------------
        
    }
}