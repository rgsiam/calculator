package com.home.tools.calculator.app;

import com.home.tools.calculator.executor.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Simple REPL for the Calculator to validate the Calculator implementation in Command Line
 */
public class CalculatorREPL {

    private static final String NEW_LINE = System.lineSeparator();
    private static Logger logger = LogManager.getLogger(CalculatorREPL.class);
    public static void main(String[] args) {
        logger.info("==> RPN Based Calculator {}" , NEW_LINE);
        logger.info("===> The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.{}" , NEW_LINE);
        logger.info("===> Available operators are +, -, *, /, sqrt, undo, clear. {}" , NEW_LINE);
        logger.info("===> After processing an input string, the calculator displays the current contents of the stack as a space-separated list. {}" , NEW_LINE);
        Calculator calculator = new Calculator();
        final Scanner scanner = new Scanner(System.in);

        while (true){
            final String inputExpression = scanner.nextLine();
            if(inputExpression.isEmpty()){
                break;
            } else{
                logger.info("==> {}" ,( calculator.evaluate(inputExpression) + NEW_LINE));
            }
        }
    }
}
