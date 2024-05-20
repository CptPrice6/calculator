public class ClearButton extends Button {

    public ClearButton(CalculatorGUI calculatorGUI) {
        super(calculatorGUI);
    }

    @Override
    public void execute() {
        calculatorGUI.clearExpression();
    }
}