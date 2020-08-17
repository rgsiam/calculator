package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.ExpressionFactory;

import java.util.Deque;

/**
 *
 */
public class Addition extends Command{

	public Addition(Deque<Expression> history, Deque<Expression> future) {
		super(history, future);
	}

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
