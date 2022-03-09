import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class StringProcessorTest {
    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"N", 3, "NNN"},
                {"qwe", 3, "qweqweqwe"},
                {"", 3, ""},
                {"", 0, ""},
        };
    }

    @DataProvider
    public static Object[][] countData() {
        return new Object[][]{
                {"a", "a", 1},
                {"aa", "a", 2},
                {"aaa", "aa", 2},
                {"aaaa", "vvv", 0},
                {"aeqra facwda", "a", 4}
        };
    }

    @DataProvider
    public static Object[][] countDataEx() {
        return new Object[][]{
                {"", "aa"},
                {"", ""},
                {"aa", "aaa"},
        };
    }

    @DataProvider
    public static Object[][] onetwothreeData() {
        return new Object[][]{
                {"", ""},
                {"567890", "567890"},
                {" 1 ", " один "},
                {" 2", " два"},
                {"1 2 3", "один два три"}
        };
    }

    @Test(dataProvider = "data")
    public void testCopy(String str, int N, String expected) {
        assertEquals(StringProcessor.CopyStringNTime(str, N), expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testCopyExc() throws IllegalArgumentException {
        StringProcessor.CopyStringNTime("qwe", -6);
        fail();
    }

    @Test(dataProvider = "countData")
    public void testFind(String big, String small, int expected)  {
        assertEquals(StringProcessor.CountIncludeStringToString(big, small), expected);

    }

    @Test(dataProvider = "countDataEx", expectedExceptions = {IllegalArgumentException.class})
    public void testFindExc(String big, String small) throws IllegalArgumentException {
        StringProcessor.CountIncludeStringToString(big, small);
        fail();
    }

    @Test(dataProvider = "onetwothreeData")
    public void testChange(String source, String expected) {
        assertEquals(StringProcessor.ParseStringOneTwoThree(source), expected);
    }

    @Test
    public void testChange2() {
        StringBuilder  string = new StringBuilder("1234567");
        StringBuilder temp = StringProcessor.DeleteEverySecondInStringBuilder(string);
        assertEquals(temp.toString(), "1357");
        temp = StringProcessor.DeleteEverySecondInStringBuilder(string);
        assertEquals(temp.toString(), "15");
        temp = StringProcessor.DeleteEverySecondInStringBuilder(string);
        assertEquals(temp.toString(), "1");
        temp = StringProcessor.DeleteEverySecondInStringBuilder(string);
        assertEquals(temp.toString(), "1");
    }
}