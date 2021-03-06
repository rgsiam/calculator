package com.home.tools.calculator.expression;

import com.home.tools.calculator.utils.HelperUtil;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
/**
 * {@code Expression} defines the abstraction to support various types of {@link Expression} such as {@link UnaryExpression}
 * such as {@link BinaryExpression}, {@link ConstantExpression} open to such extension of this Class
 * @since 1.0
 *
 */
public abstract class Expression {
	/**
	 * Used to hold the result of an Expression
	 */
	private final Double result;

	/**
	 * Default constructor to be used by extended classes
	 * @param result Result of the Expression as {@link Double}
	 * @since 1.0
	 * @throws IllegalArgumentException In case the argument is NULL
	 */
	public Expression(Double result) {
		if(result == null){
			HelperUtil.raiseException("Argument to the Constructor cannot be null");
		}
		this.result=result;
	}
	/**
	 * Default construct Used by {@code com.home.tools.calculator.expression.ConstantExpression}
	 * Return the {@code result} which is the <pre>Result</pre>of the evaluated expression
	 * @since 1.0
	 */
	public Double result() {
		return this.result;
	}

	/**
	 * Formats the <pre>result <pre/> of the Expression to ensure Precision is not lost
	 * @return Formatted Result of the Expression
	 * @since 1.0
	 */
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##########");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		return decimalFormat.format(this.result);
	}

	/**
	 *
	 * @return Returns {@link List} list of Operands {@link Expression} associated with an {@link Expression}
	 * @since 1.0
	 */
	public abstract List<Expression> operands();
}
