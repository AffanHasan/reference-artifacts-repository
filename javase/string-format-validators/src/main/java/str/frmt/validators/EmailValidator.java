package str.frmt.validators;

/**
 * Created by root on 3/5/15.
 */
public interface EmailValidator {

    public boolean isEmailValid(String email);

    public String getRegex();
}