import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {
    private JTextField textField;
    private String expression;

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        expression = "";

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4)); // 5 rows, 4 columns

        // Add number buttons and operations in the specified order
        addButtonToPanel(buttonPanel, new NumberButton(this, "1"), "1");
        addButtonToPanel(buttonPanel, new NumberButton(this, "2"), "2");
        addButtonToPanel(buttonPanel, new NumberButton(this, "3"), "3");
        addButtonToPanel(buttonPanel, new OperationButton(this, "+"), "+");

        addButtonToPanel(buttonPanel, new NumberButton(this, "4"), "4");
        addButtonToPanel(buttonPanel, new NumberButton(this, "5"), "5");
        addButtonToPanel(buttonPanel, new NumberButton(this, "6"), "6");
        addButtonToPanel(buttonPanel, new OperationButton(this, "-"), "-");

        addButtonToPanel(buttonPanel, new NumberButton(this, "7"), "7");
        addButtonToPanel(buttonPanel, new NumberButton(this, "8"), "8");
        addButtonToPanel(buttonPanel, new NumberButton(this, "9"), "9");
        addButtonToPanel(buttonPanel, new OperationButton(this, "*"), "*");

        addButtonToPanel(buttonPanel, new ClearButton(this), "C");
        addButtonToPanel(buttonPanel, new NumberButton(this, "0"), "0");
        addButtonToPanel(buttonPanel, new EqualsButton(this), "=");
        addButtonToPanel(buttonPanel, new OperationButton(this, "/"), "/");
        addButtonToPanel(buttonPanel, new UndoButton(this), "Undo");

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void addButtonToPanel(JPanel panel, Button button, String text) {
        JButton jButton = new JButton(text);
        jButton.addActionListener(e -> button.execute());
        panel.add(jButton);
    }

    public void appendToExpression(String str) {
        expression += str;
        textField.setText(expression);
    }

    public void clearExpression() {
        expression = "";
        textField.setText("");
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void calculateResult() {

        if (expression.charAt(0) == '+' || expression.charAt(0) == '-' || expression.charAt(0) == '*'
                || expression.charAt(0) == '/') {
            textField.setText("Invalid operation!");
            return;
        }

        try {
            String result = Calculator.simplifyExpression(expression);
            textField.setText(result);
        } catch (Exception e) {
            if (e.getMessage().equals("Division by zero")) {
                textField.setText("Invalid operation: " + e.getMessage());
            } else {
                textField.setText("Invalid format!");
            }

        }

    }

    public void undoLastEntry() {
        if (!expression.isEmpty()) {
            expression = expression.substring(0, expression.length() - 1);
            textField.setText(expression);
        }
    }

}