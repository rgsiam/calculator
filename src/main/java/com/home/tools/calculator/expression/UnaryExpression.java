package com.home.tools.calculator.expression;

import java.util.List;

/**
 * {@code UnaryExpression} defines the implementation of an {@link Expression} which operates on a Single Operand
 * Used to parse expressions with Unary Commands such as {Sqrt, QubeRoot etc}
 * @since 1.0
 */
public class UnaryExpression extends Expression {
	/** Expresion*/
	private Expression expression;

	/**
	 * Constructor
	 * @param expression  Expresion
	 * @param result  Result of the Expresion
	 */
	public UnaryExpression(Expression expression,Double result) {
		super(result);
		this.expression = expression;
	}

	/**
	 * Returns the operands of this Expression
	 * @return List of Expressions
	 */
	@Override
	public List<Expression> operands() {
		return List.of(expression);
	}

}
