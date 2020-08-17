package com.home.tools.calculator.expression;

import java.util.List;

public class BinaryExpression extends Expression{
	
	private Expression firstExpression;
	private Expression secondExpression;
	
	public BinaryExpression(Expression firstExpression, Expression secondExpression, Double result) {
		super(result);
		this.firstExpression = firstExpression;
		this.secondExpression = secondExpression;
	}
	
	@Override
	public List<Expression> operands() {
		return List.of(firstExpression, secondExpression);
	}
}
