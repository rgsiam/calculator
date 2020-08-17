package com.home.tools.calculator.app;

import java.util.Scanner;

public class CommandLineTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        final Scanner scanner = new Scanner(System.in);
        while (true){
            final String inputExpression = scanner.nextLine();
            if(inputExpression.isEmpty()){
                break;
            } else{
                System.out.println(calculator.evaluate(inputExpression));
            }
        }
    }
}
