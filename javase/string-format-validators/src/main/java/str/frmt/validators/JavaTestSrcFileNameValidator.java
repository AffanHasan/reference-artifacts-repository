package str.frmt.validators;

/**
 * Created by root on 3/25/15.
 */
public interface JavaTestSrcFileNameValidator {

    public String getRegex();

    public boolean isJavaTestSrcFileNameValid(String srcFileName);
}
