package assignment;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class InterestCalculator extends JFrame {
                                                         
    private JTextField textPrinciple;
    private JTextField textInterest;
    private JTextField textYears;
    private JTextField textAmount;
    private JButton buttonCalculate;
    private JButton buttonCancel;

    public InterestCalculator() {
                                                           
        setTitle("Interest Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,2,4,4));

        JLabel Principle = new JLabel("    Amount Deposited (RM)");
        JLabel Years = new JLabel("    Years");
        JLabel Interest = new JLabel("    Interest Rate");
        JLabel Amount = new JLabel("    Matured Amount (RM)");

        textPrinciple = new JTextField();
        textYears = new JTextField();
        textInterest = new JTextField();
        textAmount = new JTextField();
        textAmount.setEditable(false);
        buttonCalculate = new JButton("Calculate");
        buttonCancel = new JButton("Cancel");

        add (Principle);
        add (textPrinciple);
        add (Years);
        add (textYears);
        add (Interest);
        add (textInterest);
        add (Amount);
        add (textAmount);
        add (buttonCalculate);
        add (buttonCancel);

        ListenerClass listener = new ListenerClass();
        buttonCalculate.addActionListener(listener);
        buttonCancel.addActionListener(listener);
        setVisible(true);
    }


    private void Calculate() {                        
        try {
            double Interest = Double.parseDouble(textInterest.getText());
            int Years = Integer.parseInt(textYears.getText());
            double Principle = Double.parseDouble(textPrinciple.getText());
            double Amount = Principle+(Principle*(Interest/100)*Years);
            textAmount.setText(String.format("%.2f",Amount));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Invalid value entered");
        }
    }

 
    private class ListenerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonCalculate) {
                Calculate();
            }
            if (e.getSource() == buttonCancel) {
            	setVisible(false); 
            }
        }
    }
}