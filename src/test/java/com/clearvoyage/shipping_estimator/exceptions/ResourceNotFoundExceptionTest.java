package com.clearvoyage.shipping_estimator.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceNotFoundExceptionTest {
    @Test
    void testAddSuppressed() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        Throwable suppressed = new IllegalArgumentException("Suppressed exception");
        exception.addSuppressed(suppressed);
        assertEquals(1, exception.getSuppressed().length);
        assertEquals(suppressed, exception.getSuppressed()[0]);
    }

    @Test
    void testFillInStackTrace() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        Throwable filledException = exception.fillInStackTrace();
        assertNotNull(filledException.getStackTrace());
    }

    @Test
    void testGetCause() {
        Throwable cause = new IllegalArgumentException("Cause");
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        exception.initCause(cause);
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testGetLocalizedMessage() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        assertEquals("Resource not found", exception.getLocalizedMessage());
    }

    @Test
    void testGetMessage() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        assertEquals("Resource not found", exception.getMessage());
    }

    @Test
    void testGetStackTrace() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        assertNotNull(exception.getStackTrace());
    }

    @Test
    void testGetSuppressed() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        assertEquals(0, exception.getSuppressed().length);
    }

    @Test
    void testInitCause() {
        Throwable cause = new IllegalArgumentException("Cause");
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        exception.initCause(cause);
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testPrintStackTrace() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        exception.printStackTrace();
    }

    @Test
    void testPrintStackTrace2() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        exception.printStackTrace(System.err);
    }

    @Test
    void testPrintStackTrace3() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        exception.printStackTrace(new java.io.PrintWriter(System.err));
    }

    @Test
    void testSetStackTrace() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        StackTraceElement[] stackTrace = new StackTraceElement[0];
        exception.setStackTrace(stackTrace);
        assertArrayEquals(stackTrace, exception.getStackTrace());
    }

    @Test
    void testToString() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        assertTrue(exception.toString().contains("ResourceNotFoundException"));
    }
}
