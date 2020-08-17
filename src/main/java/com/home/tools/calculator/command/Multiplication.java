package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.ExpressionFactory;

import java.util.Deque;

/**
 * Multiplication Command Implementation
 * @since 1.0
 */
public class Multiplication extends Command{
	/**
	 * Constructor
	 * @param history  Queue with history of Expresions
	 * @param future   Queue with Expresions for future
	 */
	public Multiplication(Deque<Expression> history, Deque<Expression> future) {
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
		Double result=e1.result()*e2.result();
		Expression e= ExpressionFactory.createExpression(e1, e2, result);
		history.push(e);
	}

}
