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

class TestUndo {
	
	private Stack<Expression> history;
	private Stack<Expression> future;
	private Undo undo;
		
	@BeforeEach
	 void setup() {
		history=new Stack<>();
		future=new Stack<>();
		undo= new Undo(history, future);
	}

	@Test
	@DisplayName("Test Undo should remove the previous expression from history")
	 void testUndoNormal() {
		history.push(createExpression(25.0));
		history.push(createExpression(10.0));
		undo.execute();
		assertEquals("25", history.pop().toString());
	}
	
	@Test
	@DisplayName("Test Undo on empty history queue should throw Exception")
	 void testUndoInvalid() {
		IllegalArgumentException undefinedException = assertThrows(IllegalArgumentException.class, () -> {
			undo.execute();
        });
        assertTrue(undefinedException.getMessage().contains("insufficient parameters"));
	}
}
