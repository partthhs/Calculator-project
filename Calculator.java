import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calcy extends JFrame implements ActionListener {

    JTextField textField;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calcy() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setBounds(30, 40, 220, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        add(textField);

        String buttons[] = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","C","=","+"
        };

        int x = 30, y = 100;

        for (int i = 0; i < 16; i++) {
            JButton btn = new JButton(buttons[i]);
            btn.setBounds(x, y, 50, 50);
            btn.addActionListener(this);
            add(btn);

            x += 60;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 60;
            }
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            textField.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }

            textField.setText("" + result);
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new Calcy();
    }
}
    
