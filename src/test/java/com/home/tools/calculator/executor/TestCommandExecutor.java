package com.home.tools.calculator.executor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class TestCommandExecutor {
    CommandExecutor commandExecutor = new CommandExecutor();
    @Test
    @DisplayName("Test simple history in stack")
     void testExample1() {
        assertEquals("5 2", commandExecutor.evaluate("5 2"));
    }
    @Test
    @DisplayName("Test precision of results of commands in stack")
     void testExampleForPrecision() {
        assertEquals("1.4142135623", commandExecutor.evaluate("2 sqrt"));
    }
    @Test
    @DisplayName("Test clear Command ")
     void testExample2() {
        assertEquals("3", commandExecutor.evaluate("2 sqrt clear 9 sqrt"));
    }
    @Test
    @DisplayName("Test Multi Subtraction with clear Command at end")
     void testExample3() {
        assertEquals("", commandExecutor.evaluate("5 2 - 3 - clear"));
    }

    @Test
    @DisplayName("Test Multi Undo with Multiplication and Undo at end")
     void testExample4() {
        assertEquals("20 5", commandExecutor.evaluate("5 4 3 2 undo undo * 5 * undo"));
    }

    @Test
    @DisplayName("Test Multi Commands with single result")
     void testExample5() {
        assertEquals("10.5", commandExecutor.evaluate("7 12 2 / * 4 /"));
    }

    @Test
    @DisplayName("Test Multi Commands with Unary command at end")
     void testExample6() {
        assertEquals("-1", commandExecutor.evaluate("1 2 3 4 5 * clear 3 4 -"));
    }

    @Test
    @DisplayName("Test Multi Commands in sequence till end")
     void testExample7() {
        assertEquals("120", commandExecutor.evaluate("1 2 3 4 5 * * * *"));
    }

    @Test
    @DisplayName("Test operators with insufficient parameters to check Stack result and position of Command")
     void testExample8() {
        Double d = null;
        System.out.printf(" " + Boolean.valueOf(0.0 == d));
        String evaluatedResult = commandExecutor.evaluate("1 2 3 * 5 + * * 6 5");
        assertTrue(evaluatedResult.contains("Operator '*' (position:15)  insufficient parameters"));
        assertTrue(evaluatedResult.contains("11"));
    }

}
