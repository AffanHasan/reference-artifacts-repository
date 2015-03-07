package str.frmt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Affan Hasan on 3/5/15.
 */
class DefaultEmailValidator implements EmailValidator{

    private final String _regex =
            "(\\Q(\\E.*\\Q)\\E)?[0-9]*[a-zA-Z]+[0-9]*\\Q.\\E?[a-zA-Z]+[0-9]*(\\Q(\\E.*\\Q)\\E)?@[a-z]+.com";

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