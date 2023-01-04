package calculator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//implementing ActionListener interface
public class CalcFrame implements ActionListener {
    //Creating variables for our calculations
    double firstNumber;
    String calcOperation;
    int frmWidth, frmheight, boundx, boundy, lblWiHi, lblx;
    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();

    // Define array of buttons in calculator.
    String buttons[] = { "/", "C", "DEL",
                         "x", "+", "-",
                         "7", "8", "9",
                         "4", "5", "6",
                         "1", "2", "3",
                         ".", "0", "="
                       };


    public CalcFrame(int wi, int hi, int xi, int yi, int li, int lh) {
        frmWidth  = wi;
        frmheight = hi;
        boundx    = xi;
        boundy    = yi;
        lblWiHi   = li;
        lblx      = lh;
    }
    public void prepareCalcGUI() {
        frame = new JFrame();
        frame.setTitle("Java Calculator");
        frame.setSize(frmWidth, frmheight);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Function to create an instance of button.
    private JButton addCalcButtons(String txt, int x, int y, int w, int h) {
        JButton button = new JButton(txt);
        button.setBounds(x, y, w, h);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.addActionListener(this);
        return button;
    }

    public void addCalcItems() {
        int setBoundX = boundx;
        int setBoundY = boundy;
        int count = 1;

        label.setBounds(lblx, 0, lblWiHi, lblWiHi);
        label.setForeground(Color.white);
        frame.add(label);

        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        // Loop through array of buttons
        for (String buttonStr : buttons)
        {
            // Add instance of button(returned by addButton method) to frame.
            frame.add(addCalcButtons(buttonStr, setBoundX, setBoundY, boundx * 8, boundx * 4));

            // After every 3 buttons reset x and y bounds for calculator
            if (count % 3 == 0) {
                setBoundY += 60;
                setBoundX = 10;
            } else {
                setBoundX += 90;
            }
            count++;
        }
    }

    //Overriding actionPerformed() method
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton) event.getSource();
        String buttonText = clickedButton.getText();
        // System.out.println("Clicked Button::::: " + buttonText);

        // create Input class object
        Input  inputVal = new Input();

        // create Calculation class object
        Calculation perfCalc = new Calculation();

        // Perform the calculation when = is clicked
        if(buttonText.equals("="))
        {
            // System.out.println("IFF::" + calcOperation);
            // Don't take any action if operation button is unnecessary clicked
            if (calcOperation == null) {
                return;
            }
            //System.out.println("Before addOutput:buttonText::" + calcOperation + "::calculation::" + firstNumber);
            perfCalc.addOutput(calcOperation, firstNumber, label, textField);
            calcOperation = null; // set the operator to null if '=' is unnecessary clicked
            //System.out.println("IF buttonText::" + buttonText);
        }
        //else take input number
        else
        {
            //System.out.println("Before ELSE:buttonText::" + buttonText + "::operation::" + inputVal.operation + "--CACL number==" + inputVal.number);
            inputVal.addInput(buttonText, label, textField);

            // save the operation (=, - , x, /) in calcOperation when clicked.
            if (inputVal.operation != null && inputVal.operation.length() > 0) {
                calcOperation = inputVal.operation;
                firstNumber   = inputVal.number;
            }
            // System.out.println("After :ELSE:buttonText::" + buttonText + "::operation::" + calcOperation + "--CACL number==" + firstNumber);
        }
    }
}
