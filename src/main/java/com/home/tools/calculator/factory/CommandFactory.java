package com.home.tools.calculator.factory;

import com.home.tools.calculator.command.*;
import com.home.tools.calculator.expression.Expression;

import java.util.Stack;

public class CommandFactory {
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
