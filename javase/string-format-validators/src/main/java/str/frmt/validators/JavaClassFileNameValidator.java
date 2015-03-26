package str.frmt.validators;

/**
 * Created by root on 3/26/15.
 */
public interface JavaClassFileNameValidator {

    public String getRegex();

    public boolean isJavaClassFileNameValid(String srcFileName);
}
