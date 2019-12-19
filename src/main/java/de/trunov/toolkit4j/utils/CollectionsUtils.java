package de.trunov.toolkit4j.utils;

import java.util.Collection;

/**
 * Helper / Utils methods for operations with collections.
 */
public class CollectionsUtils {
	
	/**
	 * Utils shouldn't be created.
	 */
	private CollectionsUtils() {
		throw new UnsupportedOperationException("It is not allowed to create an instance of a utility class");
	}

	/**
     * Check if current collection is null or doesn't have any elements.
     * 
     * @param collection    Collection.
     * @return True if collection is empty.
     */
    public static boolean isCollectionEmpty(final Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }
    
    /**
     * Check if current collection is not null and has some elements.
     * 
     * @param collection    Collection.
     * @return True if collection is not empty.
     */
    public static boolean isCollectionNotEmpty(final Collection<?> collection) {
        return collection != null && collection.size() > 0;
    }
    
    /**
     * Check if current collection is null or doesn't have any elements.
     * 
     * @param map    Map.
     * @return True if map is empty.
     */
    public static boolean isMapEmpty(final Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }
    
    /**
     * Check if current map is not null and has some elements.
     * 
     * @param map    Map.
     * @return True if map is not empty.
     */
    public static boolean isMapNotEmpty(final Collection<?> collection) {
        return collection != null && collection.size() > 0;
    }
}
