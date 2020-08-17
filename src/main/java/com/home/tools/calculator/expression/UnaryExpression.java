package com.home.tools.calculator.expression;

import java.util.List;

public class UnaryExpression extends Expression {

	private Expression expression;
	
	public UnaryExpression(Expression expression,Double result) {
		super(result);
		this.expression = expression;
	}

	@Override
	public List<Expression> operands() {
		return List.of(expression);
	}

}
