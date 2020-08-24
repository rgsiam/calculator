package com.home.tools.calculator.factory;

import com.home.tools.calculator.command.*;
import com.home.tools.calculator.expression.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCommandFactory {

    Deque<Expression> history = new ArrayDeque<>();
    Deque<Expression> future = new ArrayDeque<>();

    @Test
    @DisplayName("Test creation of Addition command")
    void testCreationOfAddition() {
        Command command = CommandFactory.newCommand("+", history, future);
        assertTrue(command instanceof Addition);
    }
    @Test
    @DisplayName("Test creation of Subtraction command")
    void testCreationOfSubtraction() {
        Command command = CommandFactory.newCommand("-", history, future);
        assertTrue(command instanceof Subtraction);
    }
    @Test
    @DisplayName("Test creation of Multiplication command")
    void testCreationOfMultiplication() {
        Command command = CommandFactory.newCommand("*", history, future);
        assertTrue(command instanceof Multiplication);
    }

    @Test
    @DisplayName("Test creation of Division command")
    void testCreationOfDivision() {
        Command command = CommandFactory.newCommand("/", history, future);
        assertTrue(command instanceof Division);
    }

    @Test
    @DisplayName("Test creation of Sqrt command")
    void testCreationOfSqrt() {
        Command command = CommandFactory.newCommand("sqrt", history, future);
        assertTrue(command instanceof Sqrt);
    }
    @Test
    @DisplayName("Test creation of Undo command")
    void testCreationOfUndo() {
        Command command = CommandFactory.newCommand("undo", history, future);
        assertTrue(command instanceof Undo);
    }

    @Test
    @DisplayName("Test creation of Clear command")
    void testCreationOfClear() {
        Command command = CommandFactory.newCommand("clear", history, future);
        assertTrue(command instanceof Clear);
    }

    @Test
    @DisplayName("Test creation of an non implemented command")
    void testCreationOfAnUndefinedCommand() {
        IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> CommandFactory.newCommand("crazy", history, future));
        assertTrue(undefinedException.getMessage().contains("Invalid Command crazy"));
    }

    @Test
    @DisplayName("Test creation commands with history Queue parameter as NULL")
    void testCreationOfCommandWithHistoryQueueAsNull() {
        IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> CommandFactory.newCommand("+", null, future));
        assertTrue(undefinedException.getMessage().contains("Arguments to the Constructor cannot be null"));
    }


    @Test
    @DisplayName("Test creation commands with future Queue parameter as NULL")
    void testCreationOfCommandWithFutureQueueAsNull() {
        IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> CommandFactory.newCommand("-", history, null));
        assertTrue(undefinedException.getMessage().contains("Arguments to the Constructor cannot be null"));
    }

}
