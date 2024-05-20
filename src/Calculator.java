import java.util.AbstractMap;

public class Calculator {

    public static String simplifyExpression(String expression) {
        while (containsOperators(expression)) {
            boolean isFirstNegative = false;
            if (expression.charAt(0) == '-') {
                boolean areAllDigits = true;
                for (int i = 1; i < expression.length(); i++) {
                    if (!Character.isDigit(expression.charAt(i))) {
                        areAllDigits = false;
                        break;
                    }
                }
                if (areAllDigits) {
                    break;
                } else {
                    isFirstNegative = true;
                }
            }

            StringBuilder newExpression = new StringBuilder();
            int opCount = 0;
            int newI = 0;

            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                Operation operation = null;

                if (i > 0 && (c == '-' || c == '+' || c == '*' || c == '/')) {
                    opCount++;
                }

                if (Character.isWhitespace(c)) {
                    continue;
                }

                if (Character.isDigit(c)) {
                    newExpression.append(c);
                    newI++;
                    continue;
                }

                // Choose an operation based on symbol
                if (c == '*') {
                    operation = new Multiplication();
                } else if (c == '/') {
                    operation = new Division();
                } else if (!expression.contains("*") && !expression.contains("/") && c == '+') {
                    operation = new Addition();
                } else if (!expression.contains("*") && !expression.contains("/") && c == '-') {
                    operation = new Subtraction();
                }

                // If operation was chosen, perform simplification
                if (operation != null) {
                    boolean isRightNegative = false;

                    // Checks if the right number from the operator is negative
                    if (c == '*' || c == '/') {
                        if (expression.charAt(i + 1) == '-') {
                            isRightNegative = true;
                            expression = expression.substring(0, i + 1) + expression.substring(i + 2);
                        }
                    } else {
                        // Skips the first negative sign (if found)
                        if (i == 0) {
                            newI++;
                            newExpression.append(c);
                            continue;
                        }
                    }

                    AbstractMap.SimpleEntry<Integer, Integer> leftAndRightNums = getLeftAndRightNums(expression, i);
                    int leftNum = leftAndRightNums.getKey();
                    int rightNum = leftAndRightNums.getValue();
                    int leftNumLen = getNumberLength(leftNum);
                    int rightNumLen = getNumberLength(rightNum);

                    if (isRightNegative) {
                        rightNum *= -1;
                    }

                    if (opCount == 1 && isFirstNegative) {
                        leftNum *= -1;
                        leftNumLen++;
                    }

                    int result = operation.operate(leftNum, rightNum);

                    // Constructs new expression with simplified bit inserted in its place
                    newExpression.delete(newI - leftNumLen, newI);
                    newExpression.append(result);
                    newExpression.append(expression.substring(i + rightNumLen + 1));

                    break;
                }

                if (c != '+' && c != '-' && c != '/' && c != '*') {
                    throw new IllegalArgumentException("Unknown symbol");
                } else {
                    newExpression.append(c);
                    newI++;
                }
            }

            expression = newExpression.toString();
        }

        return expression;
    }

    private static boolean containsOperators(String expression) {
        return expression.contains("+") || expression.contains("-") ||
                expression.contains("*") || expression.contains("/");
    }

    public static int getNumberLength(int number) {
        int length = 0;
        int tempNumber = Math.abs(number); // Ensure we handle negative numbers correctly

        if (tempNumber == 0) {
            return 1;
        }

        while (tempNumber != 0) {
            length++;
            tempNumber /= 10;
        }

        return length;
    }

    public static AbstractMap.SimpleEntry<Integer, Integer> getLeftAndRightNums(String expression, int i) {
        StringBuilder leftNumStrBuilder = new StringBuilder();
        int start = i - 1;
        while (start >= 0 && Character.isDigit(expression.charAt(start))) {
            leftNumStrBuilder.append(expression.charAt(start));
            start--;
        }
        int leftNum = Integer.parseInt(leftNumStrBuilder.reverse().toString());

        StringBuilder rightNumStrBuilder = new StringBuilder();
        start = i + 1;
        while (start < expression.length() && Character.isDigit(expression.charAt(start))) {
            rightNumStrBuilder.append(expression.charAt(start));
            start++;
        }
        int rightNum = Integer.parseInt(rightNumStrBuilder.toString());

        return new AbstractMap.SimpleEntry<>(leftNum, rightNum);
    }

}
