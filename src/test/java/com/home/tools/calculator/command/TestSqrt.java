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

class TestSqrt {
	
	private Stack<Expression> history;
	private Stack<Expression> future;
	private Sqrt sqrt;
		
	@BeforeEach
	 void setup() {
		history=new Stack<>();
		future=new Stack<>();
		sqrt= new Sqrt(history, future);
	}

	@Test
	@DisplayName("Test Square root of a number should pass")
	 void testSqrtNormal() {
		history.push(createExpression(25.0));
		sqrt.execute();
		assertEquals(5.0, history.peek().result().doubleValue());
	}
	
	@Test
	@DisplayName("Test Square root of no number should throw Exception")
	 void testSqrtInvalid() {
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> sqrt.execute());
        assertTrue(undefinedException.getMessage().contains("insufficient parameters"));
	}
}
