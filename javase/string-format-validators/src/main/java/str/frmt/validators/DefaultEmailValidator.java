package str.frmt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Affan Hasan on 3/5/15.
 */
class DefaultEmailValidator implements EmailValidator{

    private final String _comments = "(\\Q(\\E.*\\Q)\\E)?";
    private final String _dotCharacter = "\\Q.\\E?";

    private final String _regex;

    private final Pattern _pattern;

    DefaultEmailValidator(){
       this._regex =
               _comments + "[0-9]*[a-zA-Z]+[0-9]*" + _dotCharacter + "[a-zA-Z]+[0-9]*" + _comments + "@[a-z]+.com";

        this._pattern = Pattern.compile(_regex);
    }

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