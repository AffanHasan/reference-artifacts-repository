package str.frmt.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailValidatorTest {

    private final EmailValidator _emailValidatorFixture = Factories.EmailValidatorFactory.getInstance();

    @Test
    public void plain_email_test(){
        String email = "abcxyz@abcxyz.com";
        Assert.assertTrue(_emailValidatorFixture.isEmailValid(email));
    }

    @Test
    public void must_throw_illegal_args_exception_when_email_is_null(){
        try{
            _emailValidatorFixture.isEmailValid(null);
        }catch(IllegalArgumentException e){
            return;
        }
        Assert.fail();
    }

    @Test
    public void must_return_regex_as_string(){
        Assert.assertTrue(_emailValidatorFixture.getRegex() instanceof String);
    }
}