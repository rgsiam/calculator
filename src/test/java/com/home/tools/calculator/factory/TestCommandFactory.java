package com.home.tools.calculator.factory;

import com.home.tools.calculator.command.*;
import com.home.tools.calculator.expression.Expression;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCommandFactory {

    Stack<Expression> history;
    Stack<Expression> future;

    @Test
    @DisplayName("Test creation of Addition command")
    public void testCreationOfAddition() {
        Command command = CommandFactory.newCommand("+", history, future);
        assertTrue(command instanceof Addition);
    }
    @Test
    @DisplayName("Test creation of Subtraction command")
    public void testCreationOfSubtraction() {
        Command command = CommandFactory.newCommand("-", history, future);
        assertTrue(command instanceof Subtraction);
    }
    @Test
    @DisplayName("Test creation of Multiplication command")
    public void testCreationOfMultiplication() {
        Command command = CommandFactory.newCommand("*", history, future);
        assertTrue(command instanceof Multiplication);
    }

    @Test
    @DisplayName("Test creation of Division command")
    public void testCreationOfDivision() {
        Command command = CommandFactory.newCommand("/", history, future);
        assertTrue(command instanceof Division);
    }

    @Test
    @DisplayName("Test creation of Sqrt command")
    public void testCreationOfSqrt() {
        Command command = CommandFactory.newCommand("sqrt", history, future);
        assertTrue(command instanceof Sqrt);
    }
    @Test
    @DisplayName("Test creation of Undo command")
    public void testCreationOfUndo() {
        Command command = CommandFactory.newCommand("undo", history, future);
        assertTrue(command instanceof Undo);
    }

    @Test
    @DisplayName("Test creation of Clear command")
    public void testCreationOfClear() {
        Command command = CommandFactory.newCommand("clear", history, future);
        assertTrue(command instanceof Clear);
    }

    @Test
    @DisplayName("Test creation of an non implemented command")
    public void testCreationOfAnUndefinedCommand() {
        IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> {
            CommandFactory.newCommand("crazy", null, null);
        });
        assertTrue(undefinedException.getMessage().contains("Invalid Command crazy"));
    }

}
