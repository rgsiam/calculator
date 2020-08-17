package com.home.tools.calculator.expression;

import java.util.Collections;
import java.util.List;

/**
 * {@code ConstantExpression} defines the implementation of an {@link Expression} which is a Constant{@link Double}
 * @since 1.0
 */
public class ConstantExpression extends Expression{
	/**
	 * Constructor
	 * @param result  Result of the Expresion
	 */
	public ConstantExpression(Double result) {
		super(result);
	}
	/**
	 * Returns the operands of this Expression
	 * @return List of Expressions
	 */
	@Override
	public List<Expression> operands() {
		return Collections.emptyList();
	}
	
}
