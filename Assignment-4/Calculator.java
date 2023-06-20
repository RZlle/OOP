import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private final JTextField firstNumField;
    private final JTextField secondNumField;
    private final JTextField resultNumField;

    public Calculator() {
        // Creating Frame to hold text fields
        JFrame frame = new JFrame("Calculator");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        // JPanel with grid layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 0, 10));

        // Font for labels
        Font labelFont = new Font("Arial", Font.BOLD, 18);

        // Labels for fields
        JLabel firstNumLabel = new JLabel("First Number:");
        firstNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstNumLabel.setFont(labelFont);

        JLabel secondNumLabel = new JLabel("Second Number:");
        secondNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secondNumLabel.setFont(labelFont);

        JLabel resultNumLabel = new JLabel("Result:");
        resultNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultNumLabel.setFont(labelFont);
        resultNumLabel.setForeground(Color.MAGENTA);

        // Create fields
        firstNumField = new JTextField();
        secondNumField = new JTextField();
        resultNumField = new JTextField();
        resultNumField.setEditable(false);

        // Create Buttons
        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");
        JButton clearButton = new JButton("Clear");
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLUE);

        // Add action listeners to the buttons
        addButton.addActionListener(new OperationListener());
        subtractButton.addActionListener(new OperationListener());
        multiplyButton.addActionListener(new OperationListener());
        divideButton.addActionListener(new OperationListener());
        clearButton.addActionListener(new ClearListener());

        // Add the text fields to the panel
        panel.add(firstNumLabel);
        panel.add(firstNumField);
        panel.add(secondNumLabel);
        panel.add(secondNumField);
        panel.add(resultNumLabel);
        panel.add(resultNumField);

        // New panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 5, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(clearButton);

        // Add panel to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.EAST);
        // Display frame
        frame.setVisible(true);
    }

    //method for operations
    private class OperationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String firstNumText = firstNumField.getText();
                String secondNumText = secondNumField.getText();

                if (firstNumText.isEmpty() || secondNumText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "  The field is empty! \nPlease input a number...", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                double firstNum = Double.parseDouble(firstNumText);
                double secondNum = Double.parseDouble(secondNumText);
                double result;
                String operator = e.getActionCommand();

                result = switch (operator) {
                    case "Add" -> firstNum + secondNum;
                    case "Subtract" -> firstNum - secondNum;
                    case "Multiply" -> firstNum * secondNum;
                    case "Divide" -> firstNum / secondNum;
                    default -> 0.0;
                };

                resultNumField.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "          Invalid input! \nPlease enter a valid number...", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // method for clearing the data
    private class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            firstNumField.setText("");
            secondNumField.setText("");
            resultNumField.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
