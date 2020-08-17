package com.home.tools.calculator.expression;

import java.util.Collections;
import java.util.List;

public class ConstantExpression extends Expression{
	
	public ConstantExpression(Double result) {
		super(result);
	}
	
	@Override
	public List<Expression> operands() {
		return Collections.emptyList();
	}
	
}
