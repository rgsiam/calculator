package com.home.tools.calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestHelperUtil {
    @Test
    @DisplayName("Test for a valid Number as String")
     void testIsNumericForValid() {
        assertTrue(HelperUtil.isNumeric("4"));
    }
    @Test
    @DisplayName("Test for an non numeric Input as String")
     void testIsNumericForInvalidNumber() {
        assertFalse(HelperUtil.isNumeric("4HJ"));
    }

    @Test
    @DisplayName("Test the Exception Type thrown by raiseException")
     void testRaiseExceptionType() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> HelperUtil.raiseException("My Exception"));
        assertTrue(illegalArgumentException instanceof IllegalArgumentException);
    }

    @Test
    @DisplayName("Test the message thrown by raiseException")
     void testRaiseExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> HelperUtil.raiseException("My Exception"));
        assertEquals("My Exception", illegalArgumentException.getMessage());
    }
}
