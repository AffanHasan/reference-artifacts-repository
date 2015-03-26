package str.frmt.validators;

/**
 * Created by root on 3/26/15.
 */
public interface JavaTestClassFileNameValidator {

    public String getRegex();

    public boolean isJavaTestClassFileNameValid(String srcFileName);
}
