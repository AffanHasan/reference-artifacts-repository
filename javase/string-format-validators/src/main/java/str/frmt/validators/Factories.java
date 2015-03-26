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

    public static class JavaTestSrcFileNameValidatorFactory implements FactoryInterface{

        public static JavaTestSrcFileNameValidator getInstance(){
            return new DefaultJavaTestSrcFileNameValidator();
        }
    }

    public static class JavaTestClasscFileNameValidatorFactory implements FactoryInterface{

        public static JavaTestClassFileNameValidator getInstance(){
            return new DefaultJavaTestClassFileNameValidator();
        }
    }

    public static class JavaSrcFileNameValidatorFactory implements FactoryInterface{

        public static JavaSrcFileNameValidator getInstance(){
            return new DefaultJavaSrcFileNameValidator();
        }
    }

    public static class JavaClassFileNameValidatorFactory implements FactoryInterface{

        public static JavaClassFileNameValidator getInstance(){
            return new DefaultJavaClassFileNameValidator();
        }
    }
}