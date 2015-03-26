package str.frmt.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by root on 3/26/15.
 */
public class JavaTestClassFileNameValidatorTest {

    private final JavaTestClassFileNameValidator _javaTestClassFileNameValidator =
            Factories.JavaTestClasscFileNameValidatorFactory.getInstance();

    @Test
    public void regex(){
        String expression = "[\\w[^_0-9]][\\w]+Test\\Q.\\Eclass";
        Assert.assertEquals(_javaTestClassFileNameValidator.getRegex(), expression);
    }

    @Test
    public void isJavaSrcFileNameValid_Method(){
        String fileName = "ABCTest.class";
        Assert.assertTrue(_javaTestClassFileNameValidator.isJavaTestClassFileNameValid(fileName));
    }
}