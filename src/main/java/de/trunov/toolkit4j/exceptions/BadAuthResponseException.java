package de.trunov.toolkit4j.exceptions;

import java.net.URI;

import org.fuin.objects4j.common.ExceptionShortIdentifable;

/**
 * Bad Response.
 */
public class BadAuthResponseException extends Exception implements ExceptionShortIdentifable {

    private static final long serialVersionUID = 1000L;

    private static final String ERROR_CODE = "BAD_RESPONSE";
    
    /**
     * Constructor with mandatory data.
     */
    public BadAuthResponseException(final URI targetUri, final String reason, final int status) {
        super("Bad Response from Auth Server '" + targetUri + "' with reason: '" + reason + "' Status: '" + status + "'");
    }

    /**
     * Returns the unique error code.
     * 
     * @return Error code.
     */
    @Override
    public final String getShortId() {
        return ERROR_CODE;
    }   
}