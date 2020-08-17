package com.home.tools.calculator.command;

import com.home.tools.calculator.expression.Expression;

import java.util.Deque;

public class Clear extends Command{

	public Clear(Deque<Expression> history, Deque<Expression> future) {
		super(history, future);
	}

	@Override
	public void execute() {
		this.history.clear();
	}

}
