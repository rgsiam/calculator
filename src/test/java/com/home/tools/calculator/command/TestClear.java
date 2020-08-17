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

class TestClear {
	
	private Deque<Expression> history;
	private Deque<Expression> future;
	private Clear clear;
		
	@BeforeEach
	public void setup() {
		history=new ArrayDeque<>();
		future=new ArrayDeque<>();
		clear= new Clear(history, future);
	}

	@Test
	@DisplayName("Test Clear of entire history")
	public void testClearNormal() {
		history.push(createExpression(25.0));
		history.push(createExpression(10.0));
		history.push(createExpression(10.0));
		clear.execute();
        assertTrue(history.isEmpty());
	}
	
	@Test
	@DisplayName("Test Clear on empty history")
	public void testClearNoNumber() {
		clear.execute();
        assertTrue(history.isEmpty());
	}
}
