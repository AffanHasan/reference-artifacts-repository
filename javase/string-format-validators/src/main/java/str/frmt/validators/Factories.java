package str.frmt.validators;

/**
 * Created by Affan Hasan on 3/5/15.
 */
public class Factories {

    public static class EmailValidatorFactory {

        public static EmailValidator getInstance(){
            return new DefaultEmailValidator();
        }
    }

    public static class JavaTestSrcFileNameValidatorFactory {

        public static JavaTestSrcFileNameValidator getInstance(){
            return new DefaultJavaTestSrcFileNameValidator();
        }
    }

    public static class JavaTestClasscFileNameValidatorFactory {

        public static JavaTestClassFileNameValidator getInstance(){
            return new DefaultJavaTestClassFileNameValidator();
        }
    }

    public static class JavaSrcFileNameValidatorFactory {

        public static JavaSrcFileNameValidator getInstance(){
            return new DefaultJavaSrcFileNameValidator();
        }
    }

    public static class JavaClassFileNameValidatorFactory {

        public static JavaClassFileNameValidator getInstance(){
            return new DefaultJavaClassFileNameValidator();
        }
    }
}