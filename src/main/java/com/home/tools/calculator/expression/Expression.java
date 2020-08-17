package com.home.tools.calculator.expression;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public abstract class Expression {
	
	private Double result;
	
	public Expression(Double result) {
		this.result=result;
	}
	
	public Double result() {
		return this.result;
	}

	/**
	 * Formats the <pre>result <pre/> of the Expression to ensure Precision is not lost
	 * @return Formatted Result of the Expression
	 */
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##########");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		return decimalFormat.format(this.result);
	}
	
	public abstract List<Expression> operands();
}
