package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Deque;
/**
 * Clear Command Implementation
 * @since 1.0
 */
public class Clear extends Command{
	/**
	 * Constructor
	 * @param history  Queue with history of Expressions
	 * @param future   Queue with Expressions for future
	 */
	public Clear(Deque<Expression> history, Deque<Expression> future) {
		super(history, future);
	}
	/**
	 * Execution of the command
	 */
	@Override
	public void execute() {
		this.history.clear();
	}

}
