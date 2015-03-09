package regexpatterntester;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 3/8/15.
 */
public class DefaultPatternMatcher implements PatternMatcher {

    private Pattern _pattern;
    private Matcher _matcher;

    private String _inputString;

    DefaultPatternMatcher(){
    }

    @Override
    public void setPattern(String pattern) {
        this._pattern = Pattern.compile(pattern);
    }

    @Override
    public String match() {
        if(_inputString == null)
            throw new IllegalStateException("No string to match the pattern with");

        final StringBuilder sb = new StringBuilder();
        while(_matcher.find()){
            sb.append("%nMatch found starting at index " + _matcher.start() + " ending at index " + _matcher.end() + " : " + _matcher.group());
        }
        return sb.toString();
    }

    @Override
    public String getPattern() {
        return this._pattern.pattern();
    }

    @Override
    public void setInputString(String inputString) {
        this._inputString = inputString;
        this._matcher = _pattern.matcher(this._inputString);
    }

    @Override
    public String getInputString() {
        return this._inputString;
    }

}
