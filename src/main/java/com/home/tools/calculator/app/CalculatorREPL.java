package com.home.tools.calculator.app;

import com.home.tools.calculator.executor.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Simple REPL for the Calculator to validate the Calculator implementation in Command Line
 */
public class CalculatorREPL {

    private static final String newLine = System.lineSeparator();
    private static Logger logger = LogManager.getLogger(CalculatorREPL.class);
    public static void main(String[] args) {
        logger.info("==> RPN Based Calculator" + newLine);
        logger.info("===> The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators." + newLine);
        logger.info("===> Available operators are +, -, *, /, sqrt, undo, clear." + newLine);
        logger.info("===> After processing an input string, the calculator displays the current contents of the stack as a space-separated list." + newLine);
        Calculator calculator = new Calculator();
        final Scanner scanner = new Scanner(System.in);

        while (true){
            final String inputExpression = scanner.nextLine();
            if(inputExpression.isEmpty()){
                break;
            } else{
                logger.info("==> " + calculator.evaluate(inputExpression) + newLine);
            }
        }
    }
}
