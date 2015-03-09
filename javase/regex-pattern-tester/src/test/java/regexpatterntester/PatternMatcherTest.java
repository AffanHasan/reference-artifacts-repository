package regexpatterntester;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for interface PatternMatcherTest.
 */
public class PatternMatcherTest{

    private final PatternMatcher _patternMatcher = Factories.PatternMatcherFactory.getInstance();

    private void _fixture1(){
        final String pattern = "\\w{3}";
        _patternMatcher.setPattern(pattern);
        Assert.assertEquals(_patternMatcher.getPattern(), pattern);
    }

    private void _fixture2(){
        final String inputString = "Input String";
        _patternMatcher.setInputString(inputString);
        Assert.assertEquals(_patternMatcher.getInputString(), inputString);
    }

    @Test
    public void must_accept_a_regex_pattern_as_string(){
        _fixture1();
    }

    @Test
    public void must_return_a_regex_pattern_as_string(){
        _fixture1();
    }

    @Test
    public void must_accept_an_input_string(){
        _fixture2();
    }

    @Test
    public void must_make_a_pattern_match_for_the_given_input_string(){
        final String pattern = "\\w{3}";
        final String inputString = "ABC&&&&&AB";
        _patternMatcher.setPattern(pattern);
        _patternMatcher.setInputString(inputString);

        String result = "%nMatch found starting at index 0 ending at index 3 : ABC";
        String results = _patternMatcher.match();
        Assert.assertEquals(results, result);
    }

    @Test
    public void must_throw_illegal_state_exception_when_no_input_string_is_provided_prior(){
        PatternMatcher pm = Factories.PatternMatcherFactory.getInstance();
        pm.setPattern("\\w{3}");
        try{
            pm.match();
        }catch (IllegalStateException e){
            return;
        }
        Assert.fail();
    }

    @Test(enabled = false)
    public void must_match_all_characters_when_no_regex_pattern_is_set_initially(){
        final String input = "Hello world";
        PatternMatcher pm = Factories.PatternMatcherFactory.getInstance();
        pm.setInputString(input);
        Assert.assertEquals(pm.match(), "%nMatch found starting at index 0 ending at index 11 : Hello world");
    }
}