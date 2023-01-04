package calculator;

//import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        CalcFrame calc;
        calc = new CalcFrame(300, 500, 10, 110, 50, 250);
        calc.prepareCalcGUI();
        calc.addCalcItems();
    }
}