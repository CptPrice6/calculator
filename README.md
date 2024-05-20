## Made by Domantas Petkevicius, student of Vilniaus Universitetas, Matematikos ir Informatikos fakultetas (MIF), domasp902@gmail.com

## Tested on Windows 11, 2024-05-20 with Visual Studio Code

# Calculator App

This is a simple calculator application built using Java Swing. The application provides a graphical user interface (GUI) that allows users to perform basic arithmetic operations: addition, subtraction, multiplication, and division.

## Features

- Numeric buttons (0-9)
- Operation buttons (+, -, \*, /)
- Clear button (C) to reset the expression
- Equals button (=) to compute the result
- Undo button to remove the last entered character

## How to Use

1. **Enter Numbers**: Click on the number buttons (0-9) to enter numbers.
2. **Enter Operations**: Click on the operation buttons (+, -, \*, /) to add operations to your expression.
3. **Calculate Result**: Click the equals button (=) to evaluate the expression and display the result.
4. **Clear Expression**: Click the clear button (C) to reset the expression and clear the display.
5. **Undo Last Entry**: Click the undo button to remove the last entered character from the expression.

## Button Classes

- **Button.java**: Abstract base class for all buttons. Provides common functionality for button actions.
- **NumericButton.java**: Represents a button for numeric input. Extends `Button`.
- **OperationButton.java**: Represents a button for arithmetic operations. Extends `Button`.
- **ClearButton.java**: Represents a button to clear the expression. Extends `Button`.
- **EqualsButton.java**: Represents a button to compute the result. Extends `Button`.
- **UndoButton.java**: Represents a button to undo the last entry. Extends `Button`.

## Polymorphism and Abstraction

- The button classes extend the `Button` class, which provides common functionality.
- Polymorphism is achieved by overriding the `execute` method in each button class to handle specific button actions.
- Abstraction is applied by creating an abstract base class (`Button`) with common functionality and allowing specific button implementations to define their behavior.

## Requirements

- Java Development Kit (JDK) 8 or higher

## Code Overview

- **CalculatorGUI.java**: Contains the main GUI class for the calculator. Implements the action listeners for button clicks and updates the display accordingly.
- **Calculator.java**: Contains the method `simplifyExpression` that takes a mathematical expression as a string and returns the simplified result.

## Example

- Enter the expression `8-15/2+45/7`
- Click the equals button (=)
- The display will show the result: `7`
