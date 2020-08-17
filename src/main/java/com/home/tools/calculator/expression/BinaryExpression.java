package com.home.tools.calculator.expression;

import java.util.List;

/**
 * {@code BinaryExpression} defines the implementation of an {@link Expression} which operates on a two Operands
 * Used to parse expressions with Binary Commands such as {Addition, Division etc}
 * @since 1.0
 */
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
