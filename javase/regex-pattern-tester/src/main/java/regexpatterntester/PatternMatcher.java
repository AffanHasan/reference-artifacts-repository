package regexpatterntester;

/**
 * Created by Affan Hasan on 3/8/15.
 */
public interface PatternMatcher {

    void setPattern(String pattern);

    String getPattern();

    void setInputString(String inputString);

    String getInputString();

    String match();
}
