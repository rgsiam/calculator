package com.home.tools.calculator.executor;

import com.home.tools.calculator.command.Command;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.CommandFactory;
import com.home.tools.calculator.factory.ExpressionFactory;
import com.home.tools.calculator.utils.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.StringJoiner;

public class CommandExecutor {
	Logger logger = LoggerFactory.getLogger(CommandExecutor.class);
	private final Map<String, Command> commands;
	private final Deque<Expression> history;
	private final Deque<Expression> future;

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
	 * Evaluate the received input String and
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
			/**Exception is catched to allow the application to continue to service in case of Failure To be Refined further
			 * based on usuage and exposure criterias*/
			logger.error("Un Expected Exception " ,exception);
			errorMessage  = "Unhandled Response";
		}
		return errorMessage.isEmpty() ? getStackState() : errorMessage + System.lineSeparator() + getStackState();
	}

	private void pushConstantExpression(String value) {
		if (!HelperUtil.isNumeric(value))
			HelperUtil.raiseException("Invalid expression " + value);
		this.history.push(ExpressionFactory.createExpression(Double.valueOf(value)));
	}

	private String getStackState() {
		StringJoiner joiner = new StringJoiner(" ");
		history.descendingIterator().forEachRemaining(his -> joiner.add(his.toString()));
		return joiner.toString();
	}

}
