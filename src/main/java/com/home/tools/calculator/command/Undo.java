package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Stack;

public class Undo extends Command{

	public Undo(Stack<Expression> history, Stack<Expression> future) {
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
