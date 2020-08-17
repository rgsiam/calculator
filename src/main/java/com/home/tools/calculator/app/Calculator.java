package com.home.tools.calculator.app;

import com.home.tools.calculator.executor.CommandExecutor;

public class Calculator {
    CommandExecutor commandExecutor = new CommandExecutor();
    public  String evaluate(String inputExpression) {
        return commandExecutor.evaluate(inputExpression);
    }
}
