public class NumberButton extends Button {
    private String number;

    public NumberButton(CalculatorGUI calculatorGUI, String number) {
        super(calculatorGUI);
        this.number = number;
    }

    @Override
    public void execute() {
        calculatorGUI.appendToExpression(number);
    }
}