package de.trunov.toolkit4j.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.Test;

import de.trunov.toolkit4j.utils.CollectionsUtils;

public class CollectionsUtilsTest {

    private static List<String> COLLECTION_NULL;
    private static List<String> EMPTY_LIST;
    private static Set<String> EMPTY_SET;
    private static List<Object> NOT_EMPTY_LIST;
    private static Set<String> NOT_EMPTY_SET;
    private static Map<Integer, String> EMPTY_MAP;
    private static Map<Integer, String> NOT_EMPTY_MAP;
    private static Map<Integer, String> NULL_MAP;
    
    @SuppressWarnings("serial")
    @BeforeClass
    public static void init() {
        CollectionsUtilsTest.COLLECTION_NULL = null;
        CollectionsUtilsTest.EMPTY_LIST = new ArrayList<>();
        CollectionsUtilsTest.EMPTY_SET = new HashSet<>();
        CollectionsUtilsTest.NOT_EMPTY_LIST = Stream.of("foo", "bar", "baz").collect(Collectors.toList());
        CollectionsUtilsTest.NOT_EMPTY_SET = Stream.of("foo", "bar", "baz").collect(Collectors.toSet());
        CollectionsUtilsTest.EMPTY_MAP = new HashMap<>();
        CollectionsUtilsTest.NOT_EMPTY_MAP = new HashMap<Integer, String>() {{put(1, "One");}};
        CollectionsUtilsTest.NULL_MAP = null;
    }
    
    @Test
    public void isCollectionEmptyTest() {
        assertTrue(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.COLLECTION_NULL));
        assertTrue(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.EMPTY_LIST));
        assertTrue(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.EMPTY_SET));
        assertFalse(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.NOT_EMPTY_LIST));
        assertFalse(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.NOT_EMPTY_SET));
    }
    
    @Test
    public void isCollectionNotEmptyTest() {
        assertFalse(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.COLLECTION_NULL));
        assertFalse(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.EMPTY_LIST));
        assertFalse(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.EMPTY_SET));
        assertTrue(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.NOT_EMPTY_LIST));
        assertTrue(CollectionsUtils.isCollectionEmpty(CollectionsUtilsTest.NOT_EMPTY_SET));
    }
    
    @Test
    public void isMapEmptyTest() {
        assertTrue(CollectionsUtils.isMapEmpty(CollectionsUtilsTest.EMPTY_MAP));
        assertTrue(CollectionsUtils.isMapEmpty(CollectionsUtilsTest.NULL_MAP));
        assertFalse(CollectionsUtils.isMapEmpty(CollectionsUtilsTest.NOT_EMPTY_MAP));
    }
    
    @Test
    public void isMapNotEmptyTest() {
        assertFalse(CollectionsUtils.isMapNotEmpty(CollectionsUtilsTest.EMPTY_MAP));
        assertFalse(CollectionsUtils.isMapNotEmpty(CollectionsUtilsTest.NULL_MAP));
        assertTrue(CollectionsUtils.isMapNotEmpty(CollectionsUtilsTest.NOT_EMPTY_MAP));
    }
}
