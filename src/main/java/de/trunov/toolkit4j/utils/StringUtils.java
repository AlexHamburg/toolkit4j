package de.trunov.toolkit4j.utils;

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
        if (StringUtils.containsOnly(str, ' ')) {
            return true;
        }
        return false;
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
        if (StringUtils.containsOnly(str, ' ')) {
            return false;
        }
        return true;
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
    
    public static boolean containsOnlySameChars(final String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return false;
    }
}
