package str.frmt.validators;

/**
 * Created by root on 3/26/15.
 */
public interface JavaSrcFileNameValidator {

    public String getRegex();

    public boolean isJavaSrcFileNameValid(String srcFileName);
}
