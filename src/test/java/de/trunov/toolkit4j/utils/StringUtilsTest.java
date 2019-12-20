package de.trunov.toolkit4j.utils;

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
    
    private static String BLANK_STRING_1;
    private static String BLANK_STRING_2;
    private static String BLANK_STRING_3;
    private static String NOT_BLANK_STRING_1;
    private static String NOT_BLANK_STRING_2;
    private static String NOT_BLANK_STRING_3;
    private static String DIRTY_STRING_1;
    private static String DIRTY_STRING_2;
    private static String DIRTY_STRING_3;
    private static String CLEAN_STRING_1;
    private static String CLEAN_STRING_2;
    private static String CLEAN_STRING_3;
    private static String SAME_CHAR_STRING_1;
    private static String SAME_CHAR_STRING_2;
    private static String SAME_CHAR_STRING_3;
    private static String SAME_CHAR_STRING_4;
    private static String NOT_SAME_CHAR_STRING_1;
    private static String NOT_SAME_CHAR_STRING_2;
    private static String NOT_SAME_CHAR_STRING_3;
    private static String STRING_SAME_CHARS_1_1;
    private static String STRING_SAME_CHARS_1_2;
    private static String STRING_SAME_CHARS_2_1;
    private static String STRING_SAME_CHARS_2_2;
    private static String STRING_NOT_SAME_CHARS_1_1;
    private static String STRING_NOT_SAME_CHARS_1_2;
    private static String STRING_NOT_SAME_CHARS_2_1;
    private static String STRING_NOT_SAME_CHARS_2_2;
    
    @BeforeClass
    public static void init() {
        StringUtilsTest.BLANK_STRING_1 = "";
        StringUtilsTest.BLANK_STRING_2 = "    ";
        StringUtilsTest.BLANK_STRING_3 = null;
        StringUtilsTest.NOT_BLANK_STRING_1 = "testString";
        StringUtilsTest.NOT_BLANK_STRING_2 = "tes t";
        StringUtilsTest.NOT_BLANK_STRING_3 = "         test";
        StringUtilsTest.DIRTY_STRING_1 = "  test   ";
        StringUtilsTest.DIRTY_STRING_2 = "  TesT   ";
        StringUtilsTest.DIRTY_STRING_3 = "  2Tes T   ";
        StringUtilsTest.CLEAN_STRING_1 = "test";
        StringUtilsTest.CLEAN_STRING_2 = "test";
        StringUtilsTest.CLEAN_STRING_3 = "2tes t";
        StringUtilsTest.SAME_CHAR_STRING_1 = "1111";
        StringUtilsTest.SAME_CHAR_STRING_2 = "aaaa";
        StringUtilsTest.SAME_CHAR_STRING_3 = "///";
        StringUtilsTest.SAME_CHAR_STRING_4 = "       ";
        StringUtilsTest.NOT_SAME_CHAR_STRING_1 = " qqqq";
        StringUtilsTest.NOT_SAME_CHAR_STRING_2 = "qq q";
        StringUtilsTest.NOT_SAME_CHAR_STRING_3 = "qq7q";
        StringUtilsTest.STRING_SAME_CHARS_1_1 = "abcdef";
        StringUtilsTest.STRING_SAME_CHARS_1_2 = "fedcba";
        StringUtilsTest.STRING_SAME_CHARS_2_1 = " qwertz";
        StringUtilsTest.STRING_SAME_CHARS_2_2 = "q werzt";
        StringUtilsTest.STRING_NOT_SAME_CHARS_1_1 = "qwertz";
        StringUtilsTest.STRING_NOT_SAME_CHARS_1_2 = "qwert z";
        StringUtilsTest.STRING_NOT_SAME_CHARS_2_1 = "qwertz";
        StringUtilsTest.STRING_NOT_SAME_CHARS_2_2 = "qwert";
    }
    
    @Test
    public void constructorTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Constructor<StringUtils> constructor = StringUtils.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    public void isBlankTest() {
        assertTrue(StringUtils.isBlank(StringUtilsTest.BLANK_STRING_1));
        assertTrue(StringUtils.isBlank(StringUtilsTest.BLANK_STRING_2));
        assertTrue(StringUtils.isBlank(StringUtilsTest.BLANK_STRING_3));
        assertFalse(StringUtils.isBlank(StringUtilsTest.NOT_BLANK_STRING_1));
        assertFalse(StringUtils.isBlank(StringUtilsTest.NOT_BLANK_STRING_2));
        assertFalse(StringUtils.isBlank(StringUtilsTest.NOT_BLANK_STRING_3));
    }
    
    @Test
    public void isNotBlankTest() {
        assertFalse(StringUtils.isNotBlank(StringUtilsTest.BLANK_STRING_1));
        assertFalse(StringUtils.isNotBlank(StringUtilsTest.BLANK_STRING_2));
        assertFalse(StringUtils.isNotBlank(StringUtilsTest.BLANK_STRING_3));
        assertTrue(StringUtils.isNotBlank(StringUtilsTest.NOT_BLANK_STRING_1));
        assertTrue(StringUtils.isNotBlank(StringUtilsTest.NOT_BLANK_STRING_2));
        assertTrue(StringUtils.isNotBlank(StringUtilsTest.NOT_BLANK_STRING_3));
    }
    
    @Test
    public void cleanTest() {
        assertEquals(StringUtils.clean(StringUtilsTest.DIRTY_STRING_1), StringUtilsTest.CLEAN_STRING_1);
        assertEquals(StringUtils.clean(StringUtilsTest.DIRTY_STRING_2), StringUtilsTest.CLEAN_STRING_2);
        assertEquals(StringUtils.clean(StringUtilsTest.DIRTY_STRING_3), StringUtilsTest.CLEAN_STRING_3);
    }
    
    @Test
    public void containsOnlyTest() {
        assertTrue(StringUtils.containsOnly(StringUtilsTest.SAME_CHAR_STRING_1, '1'));
        assertTrue(StringUtils.containsOnly(StringUtilsTest.SAME_CHAR_STRING_2, 'a'));
        assertTrue(StringUtils.containsOnly(StringUtilsTest.SAME_CHAR_STRING_3, '/'));
        assertTrue(StringUtils.containsOnly(StringUtilsTest.SAME_CHAR_STRING_4, ' '));
        assertFalse(StringUtils.containsOnly(StringUtilsTest.NOT_SAME_CHAR_STRING_1, 'q'));
        assertFalse(StringUtils.containsOnly(StringUtilsTest.NOT_SAME_CHAR_STRING_2, 'q'));
        assertFalse(StringUtils.containsOnly(StringUtilsTest.NOT_SAME_CHAR_STRING_3, 'q'));
    }
    
    @Test
    public void haveSameCharsTest() {
        assertTrue(StringUtils.haveSameChars(StringUtilsTest.STRING_SAME_CHARS_1_1, StringUtilsTest.STRING_SAME_CHARS_1_2));
        assertTrue(StringUtils.haveSameChars(StringUtilsTest.STRING_SAME_CHARS_2_1, StringUtilsTest.STRING_SAME_CHARS_2_2));
        assertFalse(StringUtils.haveSameChars(StringUtilsTest.STRING_NOT_SAME_CHARS_1_1, StringUtilsTest.STRING_NOT_SAME_CHARS_1_2));
        assertFalse(StringUtils.haveSameChars(StringUtilsTest.STRING_NOT_SAME_CHARS_2_1, StringUtilsTest.STRING_NOT_SAME_CHARS_2_2));
    }
}
