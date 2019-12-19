package toolkit4jde.trunov.toolkit4j.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.BeforeClass;
import org.junit.Test;

import de.trunov.toolkit4j.utils.StringUtils;

public class StringUtilsTest {
    
    private static String blankString1;
    private static String blankString2;
    private static String blankString3;
    private static String notBlankString1;
    private static String notBlankString2;
    private static String notBlankString3;
    private static String dirtyString1;
    private static String dirtyString2;
    private static String dirtyString3;
    private static String cleanString1;
    private static String cleanString2;
    private static String cleanString3;
    private static String sameCharString1;
    private static String sameCharString2;
    private static String sameCharString3;
    private static String sameCharString4;
    private static String notSameCharString1;
    private static String notSameCharString2;
    private static String notSameCharString3;
    
    @BeforeClass
    public static void init() {
        StringUtilsTest.blankString1 = "";
        StringUtilsTest.blankString2 = "    ";
        StringUtilsTest.blankString3 = null;
        StringUtilsTest.notBlankString1 = "testString";
        StringUtilsTest.notBlankString2 = "tes t";
        StringUtilsTest.notBlankString3 = "         test";
        StringUtilsTest.dirtyString1 = "  test   ";
        StringUtilsTest.dirtyString2 = "  TesT   ";
        StringUtilsTest.dirtyString3 = "  2Tes T   ";
        StringUtilsTest.cleanString1 = "test";
        StringUtilsTest.cleanString2 = "test";
        StringUtilsTest.cleanString3 = "2tes t";
        StringUtilsTest.sameCharString1 = "1111";
        StringUtilsTest.sameCharString2 = "aaaa";
        StringUtilsTest.sameCharString3 = "///";
        StringUtilsTest.sameCharString4 = "       ";
        StringUtilsTest.notSameCharString1 = " qqqq";
        StringUtilsTest.notSameCharString2 = "qq q";
        StringUtilsTest.notSameCharString3 = "qq7q";
    }
    
    @Test
    public void constructorTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Constructor<StringUtils> constructor = StringUtils.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    public void isBlankTest() {
        assertTrue(StringUtils.isBlank(StringUtilsTest.blankString1));
        assertTrue(StringUtils.isBlank(StringUtilsTest.blankString2));
        assertTrue(StringUtils.isBlank(StringUtilsTest.blankString3));
        assertFalse(StringUtils.isBlank(StringUtilsTest.notBlankString1));
        assertFalse(StringUtils.isBlank(StringUtilsTest.notBlankString2));
        assertFalse(StringUtils.isBlank(StringUtilsTest.notBlankString3));
    }
    
    @Test
    public void isNotBlankTest() {
        assertFalse(StringUtils.isNotBlank(StringUtilsTest.blankString1));
        assertFalse(StringUtils.isNotBlank(StringUtilsTest.blankString2));
        assertFalse(StringUtils.isNotBlank(StringUtilsTest.blankString3));
        assertTrue(StringUtils.isNotBlank(StringUtilsTest.notBlankString1));
        assertTrue(StringUtils.isNotBlank(StringUtilsTest.notBlankString2));
        assertTrue(StringUtils.isNotBlank(StringUtilsTest.notBlankString3));
    }
    
    @Test
    public void cleanTest() {
        assertEquals(StringUtils.clean(StringUtilsTest.dirtyString1), StringUtilsTest.cleanString1);
        assertEquals(StringUtils.clean(StringUtilsTest.dirtyString2), StringUtilsTest.cleanString2);
        assertEquals(StringUtils.clean(StringUtilsTest.dirtyString3), StringUtilsTest.cleanString3);
    }
    
    @Test
    public void containsOnlyTest() {
        assertTrue(StringUtils.containsOnly(StringUtilsTest.sameCharString1, '1'));
        assertTrue(StringUtils.containsOnly(StringUtilsTest.sameCharString2, 'a'));
        assertTrue(StringUtils.containsOnly(StringUtilsTest.sameCharString3, '/'));
        assertTrue(StringUtils.containsOnly(StringUtilsTest.sameCharString4, ' '));
        assertFalse(StringUtils.containsOnly(StringUtilsTest.notSameCharString1, 'q'));
        assertFalse(StringUtils.containsOnly(StringUtilsTest.notSameCharString2, 'q'));
        assertFalse(StringUtils.containsOnly(StringUtilsTest.notSameCharString3, 'q'));
    }
}
