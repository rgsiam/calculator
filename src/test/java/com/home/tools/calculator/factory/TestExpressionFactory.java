package com.home.tools.calculator.factory;

import com.home.tools.calculator.command.Addition;
import com.home.tools.calculator.command.Command;
import com.home.tools.calculator.expression.BinaryExpression;
import com.home.tools.calculator.expression.ConstantExpression;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.expression.UnaryExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExpressionFactory {
    Expression firstExpression;
    Expression secondExpression;
    Double aDouble;
    @Test
    public void testCreationOfConstantExpresion() {
        Expression expression = ExpressionFactory.createExpression(aDouble);
        assertTrue(expression instanceof ConstantExpression);
    }

    @Test
    public void testCreationOfUnaryExpresion() {
        Expression expression = ExpressionFactory.createExpression(firstExpression,aDouble);
        assertTrue(expression instanceof UnaryExpression);
    }
    @Test
    public void testCreationOfBinaryExpresion() {
        Expression expression = ExpressionFactory.createExpression(firstExpression, secondExpression, aDouble);
        assertTrue(expression instanceof BinaryExpression);
    }
}
