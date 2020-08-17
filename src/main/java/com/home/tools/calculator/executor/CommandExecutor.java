package com.home.tools.calculator.executor;

import com.home.tools.calculator.command.Command;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.CommandFactory;
import com.home.tools.calculator.factory.ExpressionFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.StringJoiner;

public class CommandExecutor {
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
				if (cmd == null && !isNumeric(command))
					raiseException("Invalid expression " + command);
				else if (cmd == null && isNumeric(command))
					this.history.push(ExpressionFactory.createExpression(Double.valueOf(command)));
				else
					cmd.execute();
				position ++;
			}
		} catch (IllegalArgumentException exception){
			errorMessage=	String.format("Operator '%s' (position:%2d) %s", currentCommand,position,exception.getMessage());
		}
		finally {
			return errorMessage.isEmpty() ? getStackState() : errorMessage + System.lineSeparator() + getStackState();
		}

	}

	private String getStackState() {
		StringJoiner joiner = new StringJoiner(" ");
		history.descendingIterator().forEachRemaining(his -> joiner.add(his.toString()));
		return String.format("stack: %s", joiner);
	}

	private void raiseException(String message) {
		throw new IllegalArgumentException(message);
	}

	private boolean isNumeric(String num) {
		try {
			Double.parseDouble(num);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
