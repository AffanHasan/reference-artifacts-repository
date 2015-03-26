package str.frmt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 3/25/15.
 */
public class DefaultJavaTestSrcFileNameValidator implements JavaTestSrcFileNameValidator {

    private final String _expression = "[\\w[^_0-9]][\\w]+Test\\Q.\\Ejava";

    @Override
    public String getRegex() {
        return this._expression;
    }

    @Override
    public boolean isJavaTestSrcFileNameValid(String srcFileName) {
        Matcher matcher = Pattern.compile(_expression).matcher(srcFileName);
        return matcher.matches();
    }
}
