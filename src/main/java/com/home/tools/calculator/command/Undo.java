package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Deque;

/**
 * Undo Command Implementation
 * @since 1.0
 */
public class Undo extends Command{

	public Undo(Deque<Expression> history, Deque<Expression> future) {
		super(history, future);
	}

	@Override
	public void execute() {
		checkStackSize(1);
		Expression expression = history.pop();
		for(Expression exp:expression.operands())
			history.push(exp);
	}

}
