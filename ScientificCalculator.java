import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScientificCalculator extends JFrame implements ActionListener {

    JTextField textField;
    double num1, result;
    String operator;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        String buttons[] = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sin", "cos", "tan", "sqrt",
                "log", "C", "^", "%"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if ("0123456789.".contains(command)) {
                textField.setText(textField.getText() + command);
            }
            else if (command.equals("+") || command.equals("-")
                    || command.equals("*") || command.equals("/")
                    || command.equals("^")) {

                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            }
            else if (command.equals("=")) {
                double num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    case "^":
                        result = Math.pow(num1, num2);
                        break;
                }

                textField.setText(String.valueOf(result));
            }
            else if (command.equals("sin")) {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.sin(Math.toRadians(value))));
            }
            else if (command.equals("cos")) {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.cos(Math.toRadians(value))));
            }
            else if (command.equals("tan")) {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.tan(Math.toRadians(value))));
            }
            else if (command.equals("sqrt")) {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.sqrt(value)));
            }
            else if (command.equals("log")) {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.log10(value)));
            }
            else if (command.equals("%")) {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(value / 100));
            }
            else if (command.equals("C")) {
                textField.setText("");
            }
        } catch (Exception ex) {
            textField.setText("Error");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}