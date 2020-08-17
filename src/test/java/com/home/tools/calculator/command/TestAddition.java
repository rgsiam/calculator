package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.ConstantExpression;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.CommandFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAddition {
    Deque<Expression> history = new ArrayDeque<>();
    Deque<Expression> future = new ArrayDeque<>();

    @Test
    @DisplayName("Test execution of Addition command with simple values")
    void testCreationOfAddition() {
        history.push(new ConstantExpression(5D));
        history.push(new ConstantExpression(2D));
        Addition addition = new Addition(history, future);
        addition.execute();
        Command command = CommandFactory.newCommand("+", history, future);
        assertEquals("7",history.pop().toString());
    }
}
