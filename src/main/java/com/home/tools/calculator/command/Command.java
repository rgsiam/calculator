package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Stack;

public abstract class Command {
	
	protected Stack<Expression> history;
	protected Stack<Expression> future;
	
	public Command(Stack<Expression> history,Stack<Expression> future) {
		this.history=history;
		this.future=future;
	}
	
	protected void raiseException(String message) {
		throw new IllegalArgumentException(message);
	}
	
	protected void checkStackSize(int size) {
		if(history.size()<size)
			raiseException(" insufficient parameters");
	}
	
	public abstract void execute();
	
}
