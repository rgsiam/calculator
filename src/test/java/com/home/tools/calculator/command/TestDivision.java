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

class TestDivision {
	
	private Deque<Expression> history;
	private Deque<Expression> future;
	private Division division;
		
	@BeforeEach
	 void setup() {
		history=new ArrayDeque<>();
		future=new ArrayDeque<>();
		division= new Division(history, future);
	}

	@Test
	@DisplayName("Test Dividing 2 positive numbers should pass")
	 void testDivisionOfNormalNumbers() {
		history.push(createExpression(10.0));
		history.push(createExpression(10.0));
		division.execute();
		assertEquals("1",history.pop().toString());
	}
	
	@Test
	@DisplayName("Test Dividing 2 mixed numbers should pass")
	 void testDivisionOfMixedNumbersWithPrecision() {
		history.push(createExpression(15.0));
		history.push(createExpression(-10.0));
		division.execute();
		assertEquals("-1.5",history.pop().toString());
	}

	@Test
	@DisplayName("Test Dividing with Precision of 10 without loss")
	 void testDivisionToCheckPrecision() {
		history.push(createExpression(1.0));
		history.push(createExpression(6.0));
		division.execute();
		assertEquals("0.1666666666",history.pop().toString());
	}

	@Test
	@DisplayName("Test Dividing with zero should throw Exception")
	 void testDivisionByZero() {
		history.push(createExpression(1.0));
		history.push(createExpression(0.0));
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> {
			division.execute();
		});
		assertTrue(undefinedException.getMessage().contains("Cannot Divide by zero"));
	}
	
	@Test
	@DisplayName("Test Dividing with one input should throw Exception")
	 void testDivisionInvalid() {
		history.push(createExpression(-10.0));
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> {
			division.execute();
        });
        assertTrue(undefinedException.getMessage().contains("insufficient parameters"));
	}
}
