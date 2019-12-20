package de.trunov.toolkit4j.utils;

import java.util.Arrays;

/**
 * Helper / Utils methods for operations with String values.
 */
public class StringUtils {

    /**
     * Utils shouldn't be created.
     */
    private StringUtils() {
        throw new UnsupportedOperationException("It is not allowed to create an instance of a utility class");
    }
    
    /**
     * Check if string is blank or null.
     * @param str String object.
     * @return Boolean.
     */
    public static boolean isBlank(final String str) {
        if (str == null) {
            return true;
        }
        if (str.length() == 0) {
            return true;
        }
        return StringUtils.containsOnly(str, ' ');
    }
    
    /**
     * Check if string is not blank and null.
     * @param str String object.
     * @return Boolean.
     */
    public static boolean isNotBlank(final String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return false;
        }
        return !StringUtils.containsOnly(str, ' ');
    }
    
    /**
     * Remove 'waste' chars from string object.
     * @param str String object.
     * @return Clean string.
     */
    public static String clean(final String str) {
        return str.trim().toLowerCase();
    }
    
    /**
     * Check if string object contains only the same char.
     * @param str   String object.
     * @param ch    Char that should be checked.
     * @return Boolean.
     */
    public static boolean containsOnly(final String str, final char ch) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        final char[] charArray = str.toCharArray();
        for (final char c : charArray) {
            if (c != ch) { return false; }
        }
        return true;
    }
    
    /**
     * Check if both strings contain the same chars.
     * @param str1  First string.
     * @param str2  Second string.
     * @return  Boolean.
     */
    public static boolean haveSameChars(final String str1, final String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}
