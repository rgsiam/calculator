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

	/**
	 * Constructor
	 * @param firstExpression  first Expresion
	 * @param secondExpression second Expresion
	 * @param result Result of the Expresion
	 */
	public BinaryExpression(Expression firstExpression, Expression secondExpression, Double result) {
		super(result);
		this.firstExpression = firstExpression;
		this.secondExpression = secondExpression;
	}
	/**
	 * Returns the operands of this Expression
	 * @return List of Expressions
	 */
	@Override
	public List<Expression> operands() {
		return List.of(firstExpression, secondExpression);
	}
}
