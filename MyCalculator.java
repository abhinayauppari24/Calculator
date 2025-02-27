import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyCalculator extends JFrame implements ActionListener {
 // Declare buttons and text field
 private JButton[] numberButtons;
 private JButton addButton, subButton, mulButton, divButton, equButton, clrButton, delButton, 
decButton;
 private JTextField textField;
 private JPanel panel;
 
 // Variables to hold operands and result
 private double num1 = 0, num2 = 0, result = 0;
 private char operator;
 // Constructor to set up the calculator interface
 public MyCalculator() {
 setTitle("Calculator");
 setSize(400, 500);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setLocationRelativeTo(null); // Center the window
 setLayout(null);
 
 textField = new JTextField();
 textField.setBounds(50, 25, 300, 50);
 textField.setEditable(false);
 add(textField);
 
 // Create number buttons and add ActionListeners
 numberButtons = new JButton[10];
 for (int i = 0; i < 10; i++) {
 numberButtons[i] = new JButton(String.valueOf(i));
 numberButtons[i].addActionListener(this);
 }
 // Create operator buttons and add ActionListeners
 addButton = new JButton("+");
 subButton = new JButton("-");
 mulButton = new JButton("*");
 divButton = new JButton("/");
 decButton = new JButton(".");
 equButton = new JButton("=");
 clrButton = new JButton("C");
 delButton = new JButton("Del");
 addButton.addActionListener(this);
 subButton.addActionListener(this);
 mulButton.addActionListener(this);
 divButton.addActionListener(this);
 decButton.addActionListener(this);
 equButton.addActionListener(this);
 clrButton.addActionListener(this);
 delButton.addActionListener(this);
 // Create a panel to add buttons to it
 panel = new JPanel();
 panel.setBounds(50, 100, 300, 300);
 panel.setLayout(new GridLayout(4, 4, 10, 10));
 
 // Adding buttons to the panel
 panel.add(numberButtons[1]);
 panel.add(numberButtons[2]);
 panel.add(numberButtons[3]);
 panel.add(addButton);
 panel.add(numberButtons[4]);
 panel.add(numberButtons[5]);
 panel.add(numberButtons[6]);
 panel.add(subButton);
 panel.add(numberButtons[7]);
 panel.add(numberButtons[8]);
 panel.add(numberButtons[9]);
 panel.add(mulButton);
 panel.add(decButton);
 panel.add(numberButtons[0]);
 panel.add(equButton);
 panel.add(divButton);
 // Add panel and other buttons to the frame
 add(panel);
 clrButton.setBounds(50, 410, 145, 50);
 delButton.setBounds(205, 410, 145, 50);
 add(clrButton);
 add(delButton);
 
 setVisible(true);
 }
 @Override
 public void actionPerformed(ActionEvent e) {
 for (int i = 0; i < 10; i++) {
 if (e.getSource() == numberButtons[i]) {
 textField.setText(textField.getText().concat(String.valueOf(i)));
 }
 }
 if (e.getSource() == decButton) {
 textField.setText(textField.getText().concat("."));
 }
 if (e.getSource() == addButton) {
 num1 = Double.parseDouble(textField.getText());
 operator = '+';
 textField.setText("");
 }
 if (e.getSource() == subButton) {
 num1 = Double.parseDouble(textField.getText());
 operator = '-';
 textField.setText("");
 }
 if (e.getSource() == mulButton) {
 num1 = Double.parseDouble(textField.getText());
 operator = '*';
 textField.setText("");
 }
 if (e.getSource() == divButton) {
 num1 = Double.parseDouble(textField.getText());
 operator = '/';
 textField.setText("");
 }
 if (e.getSource() == equButton) {
 num2 = Double.parseDouble(textField.getText());
 switch (operator) {
 case '+':
 result = num1 + num2;
 break;
 case '-':
 result = num1 - num2;
 break;
 case '*':
 result = num1 * num2;
 break;
 case '/':
 result = num1 / num2;
 break;
 }
 textField.setText(String.valueOf(result));
 num1 = result;
 }
 if (e.getSource() == clrButton) {
 textField.setText("");
 }
 if (e.getSource() == delButton) {
 String string = textField.getText();
 textField.setText("");
 for (int i = 0; i < string.length() - 1; i++) {
 textField.setText(textField.getText() + string.charAt(i));
 }
 }
 }
 public static void main(String[] args) {
 new MyCalculator();
 }
}