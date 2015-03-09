package str.frmt.validators;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * * Contains Tests for "domain part" in an email address
 * Created by root on 3/8/15.
 */
public class EmailValidator_DomainName_Test extends AbstractEmailValidatorTest {

    /**
     * Domain names can contain ipv4 addresses
     *
     * johnydepp@[192.168.1.1]
     */
    @Test
    public void domain_names_can_contain_valid_ip_addresses_within_square_brackets1(){
        Assert.assertTrue(_emailValidatorFixture.isEmailValid("johnydepp@[192.168.1.1]"));
    }

    /**
     * Domain names can contain ipv4 addresses
     *
     * johnydepp@[255.255.255.255]
     */
    @Test
    public void domain_names_can_contain_valid_ip_addresses_within_square_brackets2(){
        for(int i = 0; i <=255; i++){
            Assert.assertTrue(_emailValidatorFixture.isEmailValid("johnydepp@[" + i + "." + i + "." + i + "." + i + "]"));
        }
    }

    /**
     * Domain names can contain A-Z characters
     *
     * johnydepp@A-Z
     */
    @Test
    public void domain_names_can_contain_A_TO_Z_characters(){
        for(int i = 65; i<=90; i++){
            Assert.assertTrue(_emailValidatorFixture.isEmailValid("johnydepp@" + (char)i));
        }
    }

    /**
     * Domain names can contain a-z characters
     *
     * johnydepp@a-z
     */
    @Test
    public void domain_names_can_contain_a_to_z_characters(){
        for(int i = 97; i<=122; i++){
            Assert.assertTrue(_emailValidatorFixture.isEmailValid("johnydepp@" + (char)i));
        }
    }

    /**
     * Domain name containing more than 64 characters is in valid
     *
     * johnydepp@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaABCDEF
     */
    @Test
    public void domain_names_can_not_contain_more_than_64_characters(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid
                ("johnydepp@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaABCDEF"));
    }

    /**
     * Domain name containing two consecutive dot (..) characters is in valid
     *
     * johnydepp@carribean..com
     */
    @Test
    public void domain_names_can_not_contain_two_consecutive_dot_characters(){
        Assert.assertFalse(_emailValidatorFixture.isEmailValid("johnydepp@carribean..com"));
    }
}