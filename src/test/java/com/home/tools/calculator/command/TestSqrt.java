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

class TestSqrt {
	
	private Deque<Expression> history;
	private Deque<Expression> future;
	private Sqrt sqrt;
		
	@BeforeEach
	public void setup() {
		history=new ArrayDeque<>();
		future=new ArrayDeque<>();
		sqrt= new Sqrt(history, future);
	}

	@Test
	@DisplayName("Test Square root of a number should pass")
	public void testSqrtNormal() {
		history.push(createExpression(25.0));
		sqrt.execute();
		assertEquals(history.peek().result().doubleValue(), 5.0);
	}
	
	@Test
	@DisplayName("Test Square root of no number should throw Exception")
	public void testSqrtInvalid() {
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> {
			sqrt.execute();
        });
        assertTrue(undefinedException.getMessage().contains("insufficient parameters"));
	}
}
