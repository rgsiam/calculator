package com.home.tools.calculator.app;

import com.home.tools.calculator.executor.Calculator;

import java.util.Scanner;

/**
 * Simple REPL for the Calculator to validate the Calculator implementation in Command Line
 */
public class CalculatorREPL {
    public static void main(String[] args) {
        System.out.println("==> RPN Based Calculator");
        System.out.println("===> The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.");
        System.out.println("===> Available operators are +, -, *, /, sqrt, undo, clear.");
        System.out.println("===> After processing an input string, the calculator displays the current contents of the stack as a space-separated list.");
        Calculator calculator = new Calculator();
        final Scanner scanner = new Scanner(System.in);

        while (true){
            final String inputExpression = scanner.nextLine();
            if(inputExpression.isEmpty()){
                break;
            } else{
                System.out.println("==> " + calculator.evaluate(inputExpression));
            }
        }
    }
}
