package com.home.tools.calculator.command;

import static com.home.tools.calculator.factory.ExpressionFactory.createExpression;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.home.tools.calculator.expression.Expression;

class TestMultiplication {
	
	private Stack<Expression> history;
	private Stack<Expression> future;
	private Multiplication multiplication;
		
	@BeforeEach
	 void setup() {
		history=new Stack<>();
		future=new Stack<>();
		multiplication= new Multiplication(history, future);
	}

	@Test
	@DisplayName("Test Multiplying 2 positive numbers should pass")
	 void testMultiplicationNormal() {
		history.push(createExpression(10.0));
		history.push(createExpression(10.0));
		multiplication.execute();
		assertEquals(100.0, history.peek().result().doubleValue());
	}
	
	@Test
	@DisplayName("Test Multiplying 2 mixed numbers should pass")
	 void testMultiplicationOfMixedNumbersWithPrecision() {
		history.push(createExpression(10.1234342233456));
		history.push(createExpression(-15.0));
		multiplication.execute();
		assertEquals( "-151.8515133501",history.pop().toString());
	}
	
	@Test
	@DisplayName("Test Multiplying with one input should throw Exception")
	 void testMultiplicationInvalid() {
		history.push(createExpression(-10.0));
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> multiplication.execute());
        assertTrue(undefinedException.getMessage().contains("insufficient parameters"));
	}
}
