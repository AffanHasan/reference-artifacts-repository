package str.frmt.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by root on 3/26/15.
 */
public class JavaClassFileNameValidatorTest {


    private final JavaClassFileNameValidator _javaClassFileNameValidator = Factories.JavaClassFileNameValidatorFactory.getInstance();

    @Test
    public void regex(){
        String expression = "[\\w[^_0-9]][\\w]+\\Q.\\Eclass";
        Assert.assertEquals(_javaClassFileNameValidator.getRegex(), expression);
    }

    @Test
    public void isJavaSrcFileNameValid_Method(){
        String fileName = "ABC.class";
        Assert.assertTrue(_javaClassFileNameValidator.isJavaClassFileNameValid(fileName));
    }
}
