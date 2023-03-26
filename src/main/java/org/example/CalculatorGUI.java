package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public CalculatorGUI() {
        setTitle("Abakus");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel num1Label = new JLabel("1:");
        num1Field = new JTextField(10);

        JLabel num2Label = new JLabel("2:");
        num2Field = new JTextField(10);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton(":");

        JLabel resultLabel = new JLabel("=:");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(resultLabel);
        add(resultField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = Calculator.add(num1, num2);
            } else if (e.getSource() == subtractButton) {
                result = Calculator.subtract(num1, num2);
            } else if (e.getSource() == multiplyButton) {
                result = Calculator.multiply(num1, num2);
            } else if (e.getSource() == divideButton) {
                result = Calculator.divide(num1, num2);
            }

            resultField.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ZADEJ PLATNÉ ČÍSLO.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "CHYBA", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }

}
