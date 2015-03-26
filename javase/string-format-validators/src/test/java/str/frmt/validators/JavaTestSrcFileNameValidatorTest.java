package str.frmt.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Affan Hasan on 3/25/15.
 */
public class JavaTestSrcFileNameValidatorTest {

    private final JavaTestSrcFileNameValidator _javaTestSrcFileNameValidator = Factories.JavaSrcFileNameValidatorFactory.getInstance();

    @Test
    public void regex(){
        String expression = "[\\w[^_0-9]][\\w]+Test\\Q.\\Ejava";
        Assert.assertEquals(_javaTestSrcFileNameValidator.getRegex(), expression);
    }

    @Test
    public void isJavaSrcFileNameValid_Method(){
        String fileName = "ABCTest.java";
        Assert.assertTrue(_javaTestSrcFileNameValidator.isJavaTestSrcFileNameValid(fileName));
    }
}