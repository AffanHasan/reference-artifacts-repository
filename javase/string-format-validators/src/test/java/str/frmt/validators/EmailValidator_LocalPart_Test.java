package str.frmt.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Contains Tests for "local part" in an email address
 */
public class EmailValidator_LocalPart_Test extends AbstractEmailValidatorTest{

    @Test
    public void must_return_regex_as_string(){
        Assert.assertTrue(_emailValidatorFixture.getRegex() instanceof String);
    }

    @Test
    public void plain_email_test(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("abcxyz@abcxyz.com"));
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

    /**
     * johny.depp@carribean.com
     */
    @Test
    public void validate_single_dot_in_between_the_local_part_is_valid(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("johny.depp@carribean.com"));
    }

    /**
     * johny..depp@carribean.com
     */
    @Test
    public void validate_two_consecutive_dots_in_local_part_is_invalid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johny..depp@carribean.com"));
    }

    /**
     * .johnydepp@carribean.com
     */
    @Test
    public void validate_single_dot_at_the_beginning_of_local_part_is_invalid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid(".johnydepp@carribean.com"));
    }

    /**
     * ..johnydepp@carribean.com
     */
    @Test
    public void validate_two_single_dots_at_the_beginning_of_local_part_is_invalid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid(".johnydepp@carribean.com"));
    }

    /**
     * johnydepp.@carribean.com
     */
    @Test
    public void validate_single_dot_at_the_end_of_local_part_is_invalid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johnydepp.@carribean.com"));
    }

    /**
     * johnydepp..@carribean.com
     */
    @Test
    public void validate_2_consecutive_dots_at_the_end_of_local_part_is_invalid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johnydepp..@carribean.com"));
    }

    /**
     * JOHNYDEPP@carribean.com
     */
    @Test
    public void validate_UPPER_CASE_LETTERS_A_TO_Z_are_valid_in_local_part(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("JOHNYDEPP@carribean.com"));
    }

    /**
     * JOHNYdepp@carribean.com
     */
    @Test
    public void validate_UPPER_CASE_plus_lower_case_letters_a_to_z_are_valid_in_local_part(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("JOHNYdepp@carribean.com"));
    }

    /**
     * DEPPjohny@carribean.com
     */
    @Test
    public void validate_UPPER_CASE_letters_a_to_z_are_valid_at_the_start_of_local_part(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("DEPPjohny@carribean.com"));
    }

    /**
     * 123johnydepp@carribean.com
     */
    @Test
    public void validate_local_part_starting_from_0_to_9_is_valid(){
        for(int i = 0; i <=9; i++){
            Assert.assertTrue(_emailValidatorFixture.isEmailValid(i + "johnydepp@carribean.com"));
        }
    }

    /**
     * johny123Depp@carribean.com
     */
    @Test
    public void validate_local_part_containing_digits_from_0_to_9_is_valid(){
        for(int i = 0; i <=9; i++){
            Assert.assertTrue(_emailValidatorFixture.isEmailValid("johny" + i + "Depp@carribean.com"));
        }
    }

    /**
     * johny123Depp123@carribean.com
     */
    @Test
    public void validate_local_part_ending_with_digits_from_0_to_9_is_valid(){
        for(int i=0; i<=9; i++){
            Assert.assertTrue(_emailValidatorFixture.isEmailValid("johny123Depp" + i + "@carribean.com"));
        }
    }

    /**
     * @johnydepp@carribean.com
     */
    @Test
    public void validate_local_part_starting_with_at_the_rate_character_is_in_valid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("@johnydepp@carribean.com"));
    }

    /**
     * johny@depp@carribean.com
     */
    @Test
    public void validate_local_part_containing_at_the_rate_character_is_in_valid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johny@depp@carribean.com"));
    }

    /**
     * johnydepp@@carribean.com
     */
    @Test
    public void validate_local_part_ending_with_at_the_rate_character_is_in_valid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johnydepp@@carribean.com"));
    }

    /**
     * johny:depp@carribean.com
     */
    @Test
    public void validate_local_part_containing_colon_character_is_in_valid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johny:depp@carribean.com"));
    }

    /**
     * :johnydepp@carribean.com
     */
    @Test
    public void validate_local_part_starting_with_colon_character_is_in_valid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid(":johnydepp@carribean.com"));
    }

    /**
     * johnydepp:@carribean.com
     */
    @Test
    public void validate_local_part_ending_with_colon_character_is_in_valid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johnydepp:@carribean.com"));
    }

    /**
     * (office address)johnydepp@carribean.com
     */
    @Test
    public void validate_local_part_starting_with_comments_is_valid(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("(office address)johnydepp@carribean.com"));
    }

    /**
     * johnydepp(office address)@carribean.com
     */
    @Test
    public void validate_local_part_ending_with_comments_is_valid(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("johnydepp(office address)@carribean.com"));
    }

    /**
     * ()johnydepp@carribean.com
     */
    @Test
    public void validate_local_part_starting_with_and_ending_with_empty_comments_is_valid(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("()johnydepp@carribean.com"));
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("johnydepp()@carribean.com"));
    }

    /**
     * johny(office address)depp@carribean.com
     */
    @Test
    public void validate_local_part_containing_comments_is_in_valid(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johny(office address)depp@carribean.com"));
    }

    /**
     * johny_depp@carribean.com
     */
    @Test
    public void validate_local_part_containing_underscore_is_valid(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("johny_depp@carribean.com"));
    }

    /**
     * _johnydepp@carribean.com
     */
    @Test
    public void validate_local_part_starting_with_underscore_is_valid(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("_johnydepp@carribean.com"));
    }

    /**
     * johnydepp_@carribean.com
     */
    @Test
    public void validate_local_part_ending_with_underscore_is_valid(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("johnydepp_@carribean.com"));
    }
}