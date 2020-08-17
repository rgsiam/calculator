# Calculator based on RPN
## Initial requirements: (with the Scope for extension 👍 )

1. The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
2. Numbers are pushed on to the stack. Operators operate on numbers that are on the stack.
3. Available operators are +, -, *, /, sqrt, undo, clear.
4. Operators pop their parameters off the stack, and push their results back onto the stack.
5. The ‘clear’ operator removes all items from the stack.
6. The ‘undo’ operator undoes the previous operation. “undo undo” will undo the previous two operations.
7. sqrt performs a square root on the top item from the stack.
8. The ‘+’, ‘-’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
9. After processing an input string, the calculator displays the current contents of the stack as a space-separated list.
10. Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if it causes no loss of precision).
11. All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
12. If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed:operator (position: ): insufficient parameters
13. After displaying the warning, all further processing of the string terminates and the current state of the stack is displayed.
