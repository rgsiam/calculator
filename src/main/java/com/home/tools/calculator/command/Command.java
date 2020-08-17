package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.utils.HelperUtil;

import java.util.Deque;

/**
 * Abstraction to be used to implement various Commands in a calculator
 * Uses stack{@link Deque} to retain the history of Expression evaluated during execution of each Command
 * @since 1.0
 */
public abstract class Command {

	protected Deque<Expression> history;
	protected Deque<Expression> future;

	/**
	 * Constructor to initialize the member variables
	 * @param history Queue to hold history of Expressions
	 * @param future  Queue to hold Expressions for future usage
	 * @throws IllegalArgumentException in case any of the arguments is null
	 */
	public Command(Deque<Expression> history, Deque<Expression> future) {
		if(history == null || future == null){
			throw new IllegalArgumentException ("Arguments to the Constructor cannot be null");
		}
		this.history=history;
		this.future=future;
	}

	/**
	 * Check for size of the <pre>history</pre> Queue size if suitable to execute the Command
	 * @param size Input size to validate against <pre>history</pre> Queue size
	 * @throws IllegalArgumentException Exception thrown if size check fails
	 */
	protected void checkStackSize(int size) {
		if(history.size()<size)
			HelperUtil.raiseException(" insufficient parameters");
	}

	/**
	 * Abstraction for execution of command
	 */
	public abstract void execute();

}
