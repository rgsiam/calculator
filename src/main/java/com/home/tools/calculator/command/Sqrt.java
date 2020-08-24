package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.ExpressionFactory;
import java.util.Deque;

/**
 * Sqrt Command Implementation
 * @since 1.0
 */
public class Sqrt extends Command{
	/**
	 * Constructor
	 * @param history  Queue with history of Expressions
	 * @param future   Queue with Expressions for future
	 */
	public Sqrt(Deque<Expression> history, Deque<Expression> future) {
		super(history, future);
	}
	/**
	 * Execution of the command
	 */
	@Override
	public void execute() {
		checkStackSize(1);
		Expression e1=history.pop();
		Double result=Math.sqrt(e1.result());
		Expression e= ExpressionFactory.createExpression(e1, result);
		history.push(e);
	}

}
