package str.frmt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 3/5/15.
 */
class DefaultEmailValidator implements EmailValidator{

    private final String _regex = "[a-z]+@[a-z]+.com";

    private final Pattern _pattern = Pattern.compile(_regex);

    @Override
    public boolean isEmailValid(String email) {
        if(email == null)
            throw new IllegalArgumentException();

        return _pattern.matcher(email).matches();
}

    @Override
    public String getRegex() {
        return this._regex;
    }
}
