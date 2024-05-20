public class UndoButton extends Button {

    public UndoButton(CalculatorGUI calculatorGUI) {
        super(calculatorGUI);
    }

    @Override
    public void execute() {
        calculatorGUI.undoLastEntry();
    }
}