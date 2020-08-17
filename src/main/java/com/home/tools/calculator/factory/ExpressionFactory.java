package com.home.tools.calculator.factory;

import com.home.tools.calculator.expression.BinaryExpression;
import com.home.tools.calculator.expression.ConstantExpression;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.expression.UnaryExpression;

/**
 * Factory Handles creation of Expresion based of number of operands
 * @since 1.0
 */
public final class ExpressionFactory {
	private ExpressionFactory (){
		/** Factory Class*/
	}

	/**
	 * Create Expression based on Double item
	 * @param item Double Input
	 * @return {@link ConstantExpression}
	 */
	public static Expression createExpression(Double item) {
		return new ConstantExpression(item);
	}
	/**
	 * Create Expression
	 * @param e1 Expresion input
	 * @param result
	 * @return {@link UnaryExpression}
	 */
	public static Expression createExpression(Expression e1,Double result) {
		return new UnaryExpression(e1, result);
	}
	/**
	 * Create Expression
	 * @param e1 first Expression
	 * @param e2 second Expression
	 * @param result Result of the Expresion
	 * @return {@link BinaryExpression}
	 */
	public static Expression createExpression(Expression e1,Expression e2,Double result) {
		return new BinaryExpression(e1,e2,result);
	}
}
