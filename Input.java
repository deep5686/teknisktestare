package calculator;

import javax.swing.*;

import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;

public class Input {
    public String operation;
    public double number;

    // catch the number format exception
    private boolean catchNumFormatExcept(String txtField, String dataType) {
        String txt;
        try {
            txt = String.valueOf(dataType == "int" ? Integer.parseInt(txtField) : Double.parseDouble(txtField));
        } catch (NumberFormatException e) {
            System.out.println("Input String : " + txtField + " cannot be parsed to a Number");
            return TRUE;
        }
        return FALSE;
    }

    public void addInput(String buttonTxt, JLabel label, JTextField textField) {

        if (buttonTxt == "C") {
            //Clearing texts of label and text field
            label.setText("");
            textField.setText("");
        } else if (buttonTxt == "DEL") {

            if (catchNumFormatExcept(textField.getText(), "int")) {
                label.setText("");
                textField.setText("");
                // return as NumberFormatException occurred
                return;
            }
            //Setting functionality for delete button(backspace)
            int length = textField.getText().length();
            int num = length - 1;

            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(num);
                textField.setText(back.toString());
            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }
        } else if (buttonTxt == "0") {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (buttonTxt == "1") {
            textField.setText(textField.getText() + "1");
        } else if (buttonTxt == "2") {
            textField.setText(textField.getText() + "2");
        } else if (buttonTxt == "3") {
            textField.setText(textField.getText() + "3");
        } else if (buttonTxt == "4") {
            textField.setText(textField.getText() + "4");
        } else if (buttonTxt == "5") {
            textField.setText(textField.getText() + "5");
        } else if (buttonTxt == "6") {
            textField.setText(textField.getText() + "6");
        } else if (buttonTxt == "7") {
            textField.setText(textField.getText() + "7");
        } else if (buttonTxt == "8") {
            textField.setText(textField.getText() + "8");
        } else if (buttonTxt == "9") {
            textField.setText(textField.getText() + "9");
        } else if (buttonTxt == ".") {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }

        } else {
            String str = textField.getText();

            // catch NumberFormatException for operators clicked unnecessarily
            if (catchNumFormatExcept(str, "double")) {
                // return as NumberFormatException occurred
                return;
            }

            if (buttonTxt == "+") {
                str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "+");
                operation = "+";
            } else if (buttonTxt == "-") {
                str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "-");
                operation = "-";
            } else if (buttonTxt == "x") {
                str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "x");
                operation = "x";
            } else if (buttonTxt == "/") {
                str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "/");
                operation = "/";
            }
        }

    }
}