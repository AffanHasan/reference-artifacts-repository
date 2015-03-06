package str.frmt.validators;

/**
 * Created by Affan Hasan on 3/5/15.
 */
public class Factories {

    public static class EmailValidatorFactory implements FactoryInterface{

        public static EmailValidator getInstance(){
            return new DefaultEmailValidator();
        }
    }
}