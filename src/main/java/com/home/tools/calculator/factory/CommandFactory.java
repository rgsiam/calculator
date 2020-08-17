package com.home.tools.calculator.factory;

import com.home.tools.calculator.command.*;
import com.home.tools.calculator.expression.Expression;

import java.util.Stack;

/**
 * Factory to be used to fetch desired Commands based on representation of the {@code Command}
 *
 * @since 1.0
 */
public class CommandFactory {
	/**
	 * Return Specific Command Implementions based on the param {command}
	 * @param command representation of the {@code Command}
	 * @param history  holds the history of expressions {@link Expression} in a stack {@link Stack}
	 * @param future   holds the expressions removed from{@code history} {@link Expression} in a stack {@link Stack}
	 * @return
	 */
	public static Command newCommand(String command, Stack<Expression> history, Stack<Expression> future) {
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
