package com.home.tools.calculator.executor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
 class TestCalculator {
    Calculator calculator = new Calculator();
    @Test
     void testExample1() {
        assertEquals("20 5", calculator.evaluate("5 4 3 2 undo undo * 5 * undo"));
    }

}
