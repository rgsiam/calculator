package com.home.tools.calculator.command;

import static com.home.tools.calculator.factory.ExpressionFactory.createExpression;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.home.tools.calculator.expression.Expression;

class TestSubtraction {
	
	private Deque<Expression> history;
	private Deque<Expression> future;
	private Subtraction subtraction;
		
	@BeforeEach
	 void setup() {
		history=new ArrayDeque<>();
		future=new ArrayDeque<>();
		subtraction= new Subtraction(history, future);
	}

	@Test
	@DisplayName("Test Subtracting 2 positive numbers should pass")
	 void testSubtractionNormal() {
		history.push(createExpression(10.0));
		history.push(createExpression(10.0));
		subtraction.execute();
		assertEquals(0.0, history.peek().result().doubleValue());
	}
	
	@Test
	@DisplayName("Test Subtracting 2 mixed numbers should pass")
	 void testSubtractionOfMixedNumbersWithPrecision() {
		history.push(createExpression(10.0));
		history.push(createExpression(-15.0));
		subtraction.execute();
		assertEquals(25.0, history.peek().result().doubleValue());
	}
	
	@Test
	@DisplayName("Test Subtracting with just one number should throw Exception")
	 void testSubtractionInvalid() {
		history.push(createExpression(-10.0));
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> subtraction.execute());
        assertTrue(undefinedException.getMessage().contains("insufficient parameters"));
	}
}
