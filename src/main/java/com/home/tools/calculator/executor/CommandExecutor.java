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
import java.util.Map;
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
	/** Holds the map of Commands available in this executor*/
	private final Map<String, Command> commands;
	/** Queue to retain history of Execution of Expresions in Commands*/
	private final Deque<Expression> history;
	/** Queue to retain Execution of Expresions in Commands for future usage such as redo*/
	private final Deque<Expression> future;

	/**
	 * Constructor to initialize the member variables
	 */
	public CommandExecutor() {
		this.history = new ArrayDeque<>();
		this.future = new ArrayDeque<>();

		this.commands = Map.of(
				"+"    , CommandFactory.newCommand("+", history, future),
				"-"    , CommandFactory.newCommand("-", history, future),
				"*"    , CommandFactory.newCommand("*", history, future),
				"/"    , CommandFactory.newCommand("/", history, future),
				"sqrt" , CommandFactory.newCommand("sqrt", history, future),
				"undo" , CommandFactory.newCommand("undo", history, future),
				"clear", CommandFactory.newCommand("clear", history, future)
		);
	}

	/**
	 * Evaluate the received input String and executes relevant Commands by parsing the Input Expresion
	 * 1. Returns <pre>Unhandled Response</pre> In case of an Unexpected internal exception
	 * 2. In case of Unexecutable Commands it returns response with message to denote Invalid Command
	 * @param input
	 * @return Return {@link String} return the output of the commands executed
	 * @throws IllegalArgumentException In case of Invalid Command or Commands with Insufficient input parameters
	 */
	public String evaluate(String input) {
		String currentCommand = input;
		int position = 1;
		String errorMessage = "";
		try {
			String[] commandsArray = input.split(" ");
			for (String command : commandsArray) {
				currentCommand = command;
				Command cmd = this.commands.get(command);
				if(cmd!=null)
					cmd.execute();
				else pushConstantExpression(command);
				position+=command.length()+1;
			}
		} catch (IllegalArgumentException exception){
			logger.warn("" ,exception);
			errorMessage=String.format("Operator '%s' (position:%2d) %s", currentCommand,position,exception.getMessage());
		} catch (Exception exception){
			/**NOTE:Exception is catched to allow the application to continue to service in case of Failure To be Refined further
			 * based on usage and exposure conditions*/
			logger.error("Unexpected Exception occurred : " ,exception);
			errorMessage  = "Invalid response";
		}
		return errorMessage.isEmpty() ? getStackState() : errorMessage + System.lineSeparator() + getStackState();
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
	private String getStackState() {
		StringJoiner joiner = new StringJoiner(" ");
		history.descendingIterator().forEachRemaining(his -> joiner.add(his.toString()));
		return joiner.toString();
	}


}
