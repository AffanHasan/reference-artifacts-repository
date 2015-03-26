package str.frmt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 3/26/15.
 */
public class DefaultJavaTestClassFileNameValidator implements JavaTestClassFileNameValidator {

    private String _regex = "[\\w[^_0-9]][\\w]+Test\\Q.\\Eclass";

    @Override
    public String getRegex() {
        return this._regex;
    }

    @Override
    public boolean isJavaTestClassFileNameValid(String srcFileName) {
        Matcher matcher = Pattern.compile(_regex).matcher(srcFileName);
        return matcher.matches();
    }
}