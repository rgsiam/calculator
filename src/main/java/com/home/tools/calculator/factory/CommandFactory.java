package com.home.tools.calculator.factory;

import com.home.tools.calculator.command.*;
import com.home.tools.calculator.expression.Expression;

import java.util.Deque;

/**
 * Factory to be used to fetch desired Commands based on representation of the {@code Command}
 *
 * @since 1.0
 */
public class CommandFactory {

	private CommandFactory (){
		//Do Nothing
	}
	/**
	 * Return Specific Command Implementions based on the param {command}
	 * @param command representation of the {@code Command}
	 * @param history  holds the history of expressions {@link Expression} in a stack {@link Deque}
	 * @param future   holds the expressions removed from{@code history} {@link Expression} in a stack {@link Deque}
	 * @return
	 */
	public static Command newCommand(String command, Deque<Expression> history, Deque<Expression> future) {
		switch(command) {
			case "+" : return new Addition(history, future);
			case "-" : return new Subtraction(history, future);
			case "*" : return new Multiplication(history, future);
			case "/" : return new Division(history, future);
			case "sqrt" : return new Sqrt(history, future);
			case "undo" : return new Undo(history, future);
			case "clear" : return new Clear(history, future);
			default  : throw new IllegalArgumentException("Invalid Command "+command);
		}
	}

}
