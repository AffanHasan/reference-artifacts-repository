package str.frmt.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by root on 3/26/15.
 */
public class JavaSrcFileNameValidatorTest {


    private final JavaSrcFileNameValidator _javaSrcFileNameValidator = Factories.JavaSrcFileNameValidatorFactory.getInstance();

    @Test
    public void regex(){
        String expression = "[\\w[^_0-9]][\\w]+\\Q.\\Ejava";
        Assert.assertEquals(_javaSrcFileNameValidator.getRegex(), expression);
    }

    @Test
    public void isJavaSrcFileNameValid_Method(){
        String fileName = "ABC.java";
        Assert.assertTrue(_javaSrcFileNameValidator.isJavaSrcFileNameValid(fileName));
    }
}
