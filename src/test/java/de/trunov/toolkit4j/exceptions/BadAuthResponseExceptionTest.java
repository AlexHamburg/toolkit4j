package de.trunov.toolkit4j.exceptions;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.BeforeClass;
import org.junit.Test;

public class BadAuthResponseExceptionTest {

    private static String ERROR_CODE;
    
    private static URI EX_URI;
    
    private static String EX_REASON;
    
    private static int EX_CODE;
    
    @BeforeClass
    public static void init() throws URISyntaxException {
        BadAuthResponseExceptionTest.ERROR_CODE = "BAD_RESPONSE";
        BadAuthResponseExceptionTest.EX_URI = new URI("http://test.org");
        BadAuthResponseExceptionTest.EX_REASON = "Not found";
        BadAuthResponseExceptionTest.EX_CODE = 404;
    }
    
    @Test
    public void badAuthResponseExceptionTest() {
        final BadAuthResponseException ex = new BadAuthResponseException(BadAuthResponseExceptionTest.EX_URI,
                BadAuthResponseExceptionTest.EX_REASON, BadAuthResponseExceptionTest.EX_CODE);
        assertEquals(ex.getReason(), BadAuthResponseExceptionTest.EX_REASON);
        assertEquals(ex.getTargetUri(), BadAuthResponseExceptionTest.EX_URI);
        assertEquals(ex.getStatus(), BadAuthResponseExceptionTest.EX_CODE);
        assertEquals(ex.getShortId(), BadAuthResponseExceptionTest.ERROR_CODE);
    }
}