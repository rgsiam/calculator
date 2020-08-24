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

class TestAddition {
	
	private Deque<Expression> history;
	private Deque<Expression> future;
	private Addition addition;
		
	@BeforeEach
	 void setup() {
		history=new ArrayDeque<>();
		future=new ArrayDeque<>();
		addition= new Addition(history, future);
	}

	@Test
	@DisplayName("Test Adding 2 positive numbers should pass")
	 void testAdditionNormal() {
		history.push(createExpression(10.0));
		history.push(createExpression(10.0));
		addition.execute();
		assertEquals("20",history.pop().toString());
	}
	
	@Test
	@DisplayName("Test Adding 2 mixed numbers should pass with Precision check")
	 void testAdditionOfMixedNumbersWithPrecision() {
		history.push(createExpression(-10.0));
		history.push(createExpression(15.127339302022627));
		addition.execute();
		assertEquals("5.127339302", history.peek().toString());
	}
	
	@Test
	@DisplayName("Test Adding 1 number alone should throw Exception")
	 void testAdditionInvalid() {
		history.push(createExpression(-10.0));
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> addition.execute());
        assertTrue(undefinedException.getMessage().contains("insufficient parameters"));
    
	}

}
