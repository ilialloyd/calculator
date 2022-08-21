package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/20/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public class Calculator {

    private double total1 = 0.0;
    private double total2 = 0.0;

    private char math_operator;


    private JPanel Calculator;
    private JTextField txtDisplay;
    private JButton a0Button;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton dotButton;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton clearButton;
    private JButton plusButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton minusButton;
    private JButton multiplyButton;

    public Calculator() {

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnOne = txtDisplay.getText() + a1Button.getText();//to keep previous text+new one we do this way
                txtDisplay.setText(btnOne);
            }
        });

        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnTwo = txtDisplay.getText() + a2Button.getText();
                txtDisplay.setText(btnTwo);
            }
        });

        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnThree = txtDisplay.getText() + a3Button.getText();
                txtDisplay.setText(btnThree);
            }
        });

        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnFour = txtDisplay.getText() + a4Button.getText();
                txtDisplay.setText(btnFour);
            }
        });

        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnFive = txtDisplay.getText() + a5Button.getText();
                txtDisplay.setText(btnFive);
            }
        });

        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnSix = txtDisplay.getText() + a6Button.getText();
                txtDisplay.setText(btnSix);
            }
        });

        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnSeven = txtDisplay.getText() + a7Button.getText();
                txtDisplay.setText(btnSeven);
            }
        });

        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnEight = txtDisplay.getText() + a8Button.getText();
                txtDisplay.setText(btnEight);
            }
        });

        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnNine = txtDisplay.getText() + a9Button.getText();
                txtDisplay.setText(btnNine);
            }
        });

        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnZero = txtDisplay.getText() + a0Button.getText();
                txtDisplay.setText(btnZero);
            }
        });

        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This will make it neater - "0." instead of "."
                if (txtDisplay.getText().equals(""))
                    txtDisplay.setText("0.");

                    //This will help to avoid a bug, 'cause ".." as well as  "1.." or ".8." is not
                    //acceptable for out simple calculator, so we make it impossible
                else if (txtDisplay.getText().contains("."))
                    dotButton.setEnabled(false);

                else {
                    String btnDot = txtDisplay.getText() + dotButton.getText();
                    txtDisplay.setText(btnDot);
                }
                dotButton.setEnabled(true);//setting button enable or disable
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total2 = 0;
                txtDisplay.setText("");//setText() accepts only String "" helps to convert all to String
            }
        });


        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //first new line gets thext  from the plus button and stores it in
                // a string variable. then handed over to our method
                String button_text = plusButton.getText();
                getOperator(button_text);

            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = minusButton.getText();
                getOperator(button_text);

            }
        });


        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = divideButton.getText();
                getOperator(button_text);
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = multiplyButton.getText();
                getOperator(button_text);
            }
        });


        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (math_operator) {
                    case '+':
                        total2 = total1 + Double.parseDouble(txtDisplay.getText());
                        break;
                    case '-':
                        total2 = total1 - Double.parseDouble(txtDisplay.getText());
                        break;
                    case '*':
                        total2 = total1 * Double.parseDouble(txtDisplay.getText());
                        break;
                    case '/':
                        total2 = total1 / Double.parseDouble(txtDisplay.getText());
                        break;

                }
                txtDisplay.setText(Double.toString(total2));
                total1 = 0;
            }
        });
    }

    private void getOperator(String btnText) {//btnText for the button when it clicked it will get the char
        math_operator = btnText.charAt(0);//converting string to char
        total1 = total1 + Double.parseDouble(txtDisplay.getText());
        txtDisplay.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
