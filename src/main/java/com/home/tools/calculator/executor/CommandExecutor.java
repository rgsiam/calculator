package com.home.tools.calculator.executor;

import com.home.tools.calculator.command.Command;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.CommandFactory;
import com.home.tools.calculator.factory.ExpressionFactory;
import com.home.tools.calculator.utils.HelperUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * {@code CommandExecutor} Represents the core of the Calculator
 * It is a Command Manager/Executor which Evaluates the received input String and executes relevant Commands by parsing the Input Expresion
 * @since 1.0
 */
class CommandExecutor {
	/**
	 * Logger for logging the exceptions
	 */
	Logger logger = LogManager.getLogger(CommandExecutor.class);
	/** Queue to retain history of Execution of Expressions in Commands*/
	private final Deque<Expression> history;
	/** Queue to retain Execution of Expressions in Commands for future usage such as redo*/
	private final Deque<Expression> future;

	/**
	 * Constructor to initialize the member variables
	 */
	public CommandExecutor() {
		this.history = new ArrayDeque<>();
		this.future = new ArrayDeque<>();
	}

	/**
	 * Evaluate the received input String and executes relevant Commands by parsing the Input Expresion
	 * 1. Returns <pre>Unhandled Response</pre> In case of an Unexpected internal exception
	 * 2. In case of Un-executable Commands it returns response with message to denote Invalid Command
	 * @param input Input String provided for calculation
	 * @return Return {@link String} return the output of the commands executed
	 * @throws IllegalArgumentException In case of Invalid Command or Commands with Insufficient input parameters
	 */
	public String evaluate(String input) {
		String currentCommand = input;
		int position = 1;
		String errorMessage = "";
		boolean isNumeric;
		try {
			String[] commandsArray = input.split("\\s+");
			for (String command : commandsArray) {
				currentCommand = command;
				isNumeric = HelperUtil.isNumeric(currentCommand);
				Command cmd = isNumeric ? null : CommandFactory.newCommand(command, history, future);
				if(cmd != null) {
					cmd.execute();
				}
				else {
					pushConstantExpression(command);
				}
				position+=command.length()+1;
			}
		} catch (IllegalArgumentException exception){
			logger.warn("Verify if expected behaviour " ,exception);
			errorMessage=String.format("Operator '%s' (position:%2d) %s", currentCommand,position,exception.getMessage());
		} catch (Exception exception){
			/*
			 * NOTE:Exception is caught to allow the application to continue to service in case of Failure To be Refined further
			 * based on usage and exposure conditions
			 * */
			logger.error("Unexpected Exception occurred : " ,exception);
			errorMessage  = "Invalid response";
		}
		return errorMessage.isEmpty() ? getQueueState() : errorMessage + System.lineSeparator() + getQueueState();
	}

	/**
	 * Pushes Constant Expresion to <pre>history</pre>
	 * @param value Input for {@link com.home.tools.calculator.expression.ConstantExpression}
	 */
	private void pushConstantExpression(String value) {
		if (!HelperUtil.isNumeric(value))
			HelperUtil.raiseException("Invalid expression " + value);
		this.history.push(ExpressionFactory.createExpression(Double.valueOf(value)));
	}

	/**
	 * Format Queue content with <pre>space</pre> as Delimiter
	 * @return Returns Formatted State of the Queue
	 */
	private String getQueueState() {
		StringJoiner joiner = new StringJoiner(" ");
		history.descendingIterator().forEachRemaining(his -> joiner.add(his.toString()));
		return joiner.toString();
	}


}
