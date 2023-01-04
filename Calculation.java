package calculator;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculation {

    //Perform calculation when = button is clicked
    public void addOutput(String operatorStr, double number, JLabel label, JTextField textField){

        // System.out.println("::Calc operator::" + operator + "::double number::" + number);

        double answer = 0.0;
        try {
            switch (operatorStr) {
                case "+":
                    answer = number + Double.parseDouble(textField.getText());
                    if (Double.toString(answer).endsWith(".0")) {
                        textField.setText(Double.toString(answer).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(answer));
                    }
                    label.setText("");
                    break;
                case "-":
                    answer = number - Double.parseDouble(textField.getText());
                    if (Double.toString(answer).endsWith(".0")) {
                        textField.setText(Double.toString(answer).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(answer));
                    }
                    label.setText("");
                    break;
                case "x":
                    answer = number * Double.parseDouble(textField.getText());
                    if (Double.toString(answer).endsWith(".0")) {
                        textField.setText(Double.toString(answer).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(answer));
                    }
                    label.setText("");
                    break;
                case "/":
                    answer = number / Double.parseDouble(textField.getText());

                    if (Double.toString(answer).endsWith(".0")) {
                        textField.setText(Double.toString(answer).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(answer));
                    }
                    label.setText("");
                    break;

            }
        } catch (Exception e){
            if(e instanceof ArithmeticException){
                e.printStackTrace();
                System.out.println("Arithmetic error in evaluating expression : " + number + " " + operatorStr + " "  + Double.parseDouble(textField.getText()));
            } else {
                System.out.println(e.getMessage());
                label.setText("");
            }
        }
    }
}
