public class OperationButton extends Button {
    private String operation;

    public OperationButton(CalculatorGUI calculatorGUI, String operation) {
        super(calculatorGUI);
        this.operation = operation;
    }

    @Override
    public void execute() {
        calculatorGUI.appendToExpression(operation);
    }
}