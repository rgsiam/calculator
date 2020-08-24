package com.home.tools.calculator.factory;

import com.home.tools.calculator.expression.BinaryExpression;
import com.home.tools.calculator.expression.ConstantExpression;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.expression.UnaryExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class TestExpressionFactory {
    Expression firstExpression;
    Expression secondExpression;
    Double aDouble = 0D;
    @Test
    @DisplayName("Test creation of Constant Expresion")
     void testCreationOfConstantExpresion() {
        Expression expression = ExpressionFactory.createExpression(aDouble);
        assertTrue(expression instanceof ConstantExpression);
    }

    @Test
    @DisplayName("Test creation of Unary Expresion")
     void testCreationOfUnaryExpresion() {
        Expression expression = ExpressionFactory.createExpression(firstExpression,aDouble);
        assertTrue(expression instanceof UnaryExpression);
    }
    @Test
    @DisplayName("Test creation of Binary Expresion")
     void testCreationOfBinaryExpresion() {
        Expression expression = ExpressionFactory.createExpression(firstExpression, secondExpression, aDouble);
        assertTrue(expression instanceof BinaryExpression);
    }
     @Test
     @DisplayName("Test creation failure of Constant Expresion when result is NULL")
     void testCreationFailureOfConstantExpresion() {
         IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> ExpressionFactory.createExpression(null));
         assertTrue(undefinedException.getMessage().contains("Argument to the Constructor cannot be null"));
     }
     @Test
     @DisplayName("Test creation failure of Unary Expresion when result is NULL")
     void testCreationFailureOfUnaryExpression() {
         IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> ExpressionFactory.createExpression(firstExpression,null));
         assertTrue(undefinedException.getMessage().contains("Argument to the Constructor cannot be null"));
     }
     @Test
     @DisplayName("Test creation failure of Binary Expresion when result is NULL")
     void testCreationFailureOfBinaryExpression() {
         IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> ExpressionFactory.createExpression(firstExpression, secondExpression,null));
         assertTrue(undefinedException.getMessage().contains("Argument to the Constructor cannot be null"));
     }
}
