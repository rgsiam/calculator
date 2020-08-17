package com.home.tools.calculator.factory;

import com.home.tools.calculator.expression.BinaryExpression;
import com.home.tools.calculator.expression.ConstantExpression;
import com.home.tools.calculator.expression.Expression;
import com.home.tools.calculator.expression.UnaryExpression;

/**
 * Factory Handles creation of and Expresion based of number of operands
 * @since 1.0
 */
public class ExpressionFactory {
	public static Expression createExpression(Double item) {
		return new ConstantExpression(item);
	}
	
	public static Expression createExpression(Expression e1,Double result) {
		return new UnaryExpression(e1, result);
	}
	
	public static Expression createExpression(Expression e1,Expression e2,Double result) {
		return new BinaryExpression(e1,e2,result);
	}
}
