package de.trunov.toolkit4j.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.BeforeClass;
import org.junit.Test;

import de.trunov.toolkit4j.utils.IOUtils;

public class IOUtilsTest {

    public static String FILE_PATH;

    @BeforeClass
    public static void init() {
        IOUtilsTest.FILE_PATH = "src/test/resources/";
    }
    
    @Test
    public void getFileNamesInDirTest() {
        assertTrue(IOUtils.getFileNamesInDir(IOUtilsTest.FILE_PATH).contains("first.json"));
        assertTrue(IOUtils.getFileNamesInDir(IOUtilsTest.FILE_PATH).contains("second.txt"));
    }
    
    @Test
    public void getFilesInDirTest() { 
        assertEquals(2, IOUtils.getFilesInDir(IOUtilsTest.FILE_PATH).size());
    }
    
    @Test
    public void getDataAsJsonStringFromUrlTest() throws MalformedURLException, IOException {
        assertEquals("\"test\": \"success\"",
                IOUtils.getDataAsJsonStringFromUrl(new File(IOUtilsTest.FILE_PATH + "first.json").toURI().toURL()));
    }
}
