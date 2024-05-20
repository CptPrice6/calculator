public interface Operation {
    int operate(int left, int right);
}

class Addition implements Operation {
    public int operate(int left, int right) {
        return left + right;
    }
}

class Subtraction implements Operation {
    public int operate(int left, int right) {
        return left - right;
    }
}

class Multiplication implements Operation {
    public int operate(int left, int right) {
        return left * right;
    }
}

class Division implements Operation {
    public int operate(int left, int right) {
        if (right == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left / right;
    }
}
