package str.frmt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 3/26/15.
 */
public class DefaultJavaClassFileNameValidator implements JavaClassFileNameValidator {

    private String _regex = "[\\w[^_0-9]][\\w]+\\Q.\\Eclass";

    @Override
    public boolean isJavaClassFileNameValid(String srcFileName) {
        Matcher m = Pattern.compile(this.getRegex()).matcher(srcFileName);
        return m.matches();
    }

    @Override
    public String getRegex() {
        return this._regex;
    }
}
