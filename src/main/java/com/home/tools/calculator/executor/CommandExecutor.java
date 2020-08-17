package com.home.tools.calculator.executor;

import com.home.tools.calculator.command.Command;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.factory.CommandFactory;
import com.home.tools.calculator.factory.ExpressionFactory;

import java.util.Map;
import java.util.Stack;

public class CommandExecutor {
	private final Map<String, Command> commands;
	private final Stack<Expression> history;
	private final Stack<Expression> future;

	public CommandExecutor() {
		this.history = new Stack<>();
		this.future = new Stack<>();

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

	public String evaluate(String line) {
		String currentCommand = line;
		int position = 1;
		String errorMessage = "";
		try {
			String[] commands = line.split(" ");

			for (String command : commands) {
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

	public String getStackState() {
		return String.format("stack: %s", history.toString().replaceAll("\\[", "").replaceAll(",", "")
				.replaceAll("]", ""));
	}

	protected void raiseException(String message) {
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
