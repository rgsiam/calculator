package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Deque;

/**
 * Abstraction to be used to implement various Commands in a calculator
 * Uses stack{@link Deque} to retain the history of Expression evaluated during execution of each Command
 */
public abstract class Command {

	protected Deque<Expression> history;
	protected Deque<Expression> future;

	/**
	 *
	 * @param history
	 * @param future
	 * @throws IllegalArgumentException in case any of the arguments is null
	 */
	public Command(Deque<Expression> history, Deque<Expression> future) {
		if(history == null || future == null){
			throw new IllegalArgumentException ("Arguments to the Constructor cannot be null");
		}
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
