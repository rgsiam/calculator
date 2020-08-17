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

class TestUndo {
	
	private Deque<Expression> history;
	private Deque<Expression> future;
	private Undo undo;
		
	@BeforeEach
	public void setup() {
		history=new ArrayDeque<>();
		future=new ArrayDeque<>();
		undo= new Undo(history, future);
	}

	@Test
	@DisplayName("Test Undo should remove the previous expression from history")
	public void testUndoNormal() {
		history.push(createExpression(25.0));
		history.push(createExpression(10.0));
		undo.execute();
		assertEquals("25", history.pop().toString());
	}
	
	@Test
	@DisplayName("Test Undo on empty history queue should throw Exception")
	public void testUndoInvalid() {
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> {
			undo.execute();
        });
        assertTrue(undefinedException.getMessage().contains("Insufficient parameters"));
	}
}
