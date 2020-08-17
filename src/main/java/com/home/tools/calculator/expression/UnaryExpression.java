package com.home.tools.calculator.expression;

import java.util.List;

/**
 * {@code UnaryExpression} defines the implementation of an {@link Expression} which operates on a Single Operand
 * Used to parse expressions with Unary Commands such as {Sqrt, QubeRoot etc}
 * @since 1.0
 */
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
