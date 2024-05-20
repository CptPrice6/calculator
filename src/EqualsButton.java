public class EqualsButton extends Button {

    public EqualsButton(CalculatorGUI calculatorGUI) {
        super(calculatorGUI);
    }

    @Override
    public void execute() {
        calculatorGUI.calculateResult();
    }
}