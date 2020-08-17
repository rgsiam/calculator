package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Stack;

public class Clear extends Command{

	public Clear(Stack<Expression> history, Stack<Expression> future) {
		super(history, future);
	}
	
	@Override
	public void execute() {
		this.history.clear();
	}

}
