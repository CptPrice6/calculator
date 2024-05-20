// Made by Domantas Petkevicius, student of Vilniaus Universitetas, Matematikos ir Informatikos fakultetas (MIF), domasp902@gmail.com

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) throws Exception {

        try {
            SwingUtilities.invokeLater(() -> {
                CalculatorGUI calculator = new CalculatorGUI();
                calculator.setVisible(true);
            });
        } catch (Exception e) {
            System.out.println("An unknown exception has occured:" + e.getStackTrace());
            System.out.println("Message:" + e.getMessage());
        }
    }
}
