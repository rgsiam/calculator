package com.home.tools.calculator.executor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCommandExecutor {
    CommandExecutor commandExecutor = new CommandExecutor();
    @Test
    public void testExample1() {
        assertEquals("stack: 5 2", commandExecutor.evaluate("5 2"));
    }
    @Test
    @DisplayName("Test precision of results of commands in stack")
    public void testExampleForPrecision() {
        assertEquals("stack: 1.4142135623", commandExecutor.evaluate("2 sqrt"));
    }
    @Test
    @DisplayName("Test clear Command ")
    public void testExample2() {
        assertEquals("stack: 3", commandExecutor.evaluate("2 sqrt clear 9 sqrt"));
    }
    @Test
    public void testExample3() {
        assertEquals("stack: ", commandExecutor.evaluate("5 2 - 3 - clear"));
    }

    @Test
    public void testExample4() {
        assertEquals("stack: 20 5", commandExecutor.evaluate("5 4 3 2 undo undo * 5 * undo"));
    }

    @Test
    public void testExample5() {
        assertEquals("stack: 10.5", commandExecutor.evaluate("7 12 2 / * 4 /"));
    }

    @Test
    public void testExample6() {
        assertEquals("stack: -1", commandExecutor.evaluate("1 2 3 4 5 * clear 3 4 -"));
    }

    @Test
    public void testExample7() {
        assertEquals("stack: 120", commandExecutor.evaluate("1 2 3 4 5 * * * *"));
    }

    @Test
    @DisplayName("Test operators with insufficient parameters")
    public void testExample8() {
        String evaluatedResult = commandExecutor.evaluate("1 2 3 * 5 + * * 6 5");
        assertTrue(evaluatedResult.contains("Operator '*' (position: 8)  insufficient parameters"));
        assertTrue(evaluatedResult.contains("stack: 11"));
    }

}
