package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.ExpressionFactory;

import java.util.Stack;

public class Sqrt extends Command{

	public Sqrt(Stack<Expression> history, Stack<Expression> future) {
		super(history, future);
	}

	@Override
	public void execute() {
		checkStackSize(1);
		Expression e1=history.pop();
		Double result=Math.sqrt(e1.result());
		Expression e= ExpressionFactory.createExpression(e1, result);
		history.push(e);
	}

}
