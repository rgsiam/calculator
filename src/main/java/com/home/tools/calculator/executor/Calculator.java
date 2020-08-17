package com.home.tools.calculator.executor;

/**
 * A simple <pre>Calculator</pre> implementation to be utilized by clients
 *
 * @since 1.0
 */
public class Calculator {
    /**
     * Holds the reference to the CommandExecutor
     */
    CommandExecutor commandExecutor = new CommandExecutor();

    /**
     * Parses the Input String to evaluate the Operands received
     * @param inputExpression Input Expression from Client
     * @return Return processed output from the Calculator
     */
    public  String evaluate(String inputExpression) {
        return commandExecutor.evaluate(inputExpression);
    }
}
