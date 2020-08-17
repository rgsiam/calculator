package com.home.tools.calculator.executor;

/**
 * A simple <pre>Calculator</pre> implementation to be utilized by clients
 *
 * @since 1.0
 */
public class Calculator {
    /**
     * Holds the
     */
    CommandExecutor commandExecutor = new CommandExecutor();
    public  String evaluate(String inputExpression) {
        return commandExecutor.evaluate(inputExpression);
    }
}
