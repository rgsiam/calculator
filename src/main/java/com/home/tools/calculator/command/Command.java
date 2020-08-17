package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Stack;

/**
 * Abstraction to be used to implement various Commands in a calculator
 * Uses stack{@link Stack} to retain the history of Expression evaluated during execution of each Command
 */
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
	
	/**
	 * Executes command
	 */
	public abstract void execute();
	
}
