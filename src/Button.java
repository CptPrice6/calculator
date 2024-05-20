public abstract class Button {
    protected CalculatorGUI calculatorGUI;

    public Button(CalculatorGUI calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
    }

    public abstract void execute();
}
