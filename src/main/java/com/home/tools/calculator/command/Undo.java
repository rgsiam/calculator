package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Deque;

/**
 * Undo Command Implementation
 * @since 1.0
 */
public class Undo extends Command{
	/**
	 * Constructor
	 * @param history  Queue with history of Expresions
	 * @param future   Queue with Expresions for future
	 */
	public Undo(Deque<Expression> history, Deque<Expression> future) {
		super(history, future);
	}
	/**
	 * Execution of the command
	 * @return List of Expressions
	 */
	@Override
	public void execute() {
		checkStackSize(1);
		Expression expression = history.pop();
		for(Expression exp:expression.operands())
			history.push(exp);
	}

}
