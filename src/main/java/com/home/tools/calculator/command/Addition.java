package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.ExpressionFactory;

import java.util.Deque;

/**
 * Addition Command Implementation
 * @since 1.0
 */
public class Addition extends Command{
	/**
	 * Constructor
	 * @param history  Queue with history of Expressions
	 * @param future   Queue with Expressions for future
	 */
	public Addition(Deque<Expression> history, Deque<Expression> future) {
		super(history, future);
	}
	/**
	 * Execution of the command
	 */
	@Override
	public void execute() {
		checkStackSize(2);
		Expression e2=history.pop();
		Expression e1=history.pop();
		Double result=e1.result()+e2.result();
		Expression e= ExpressionFactory.createExpression(e1, e2, result);
		history.push(e);
	}

}
