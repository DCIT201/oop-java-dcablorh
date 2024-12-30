
package lorry;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LorryView {
    JButton jBtnAddLorry;
    JButton jBtnCancel;
    JTextField jTxtMake;
    JTextField jTxtModel;
    JTextField jTxtTopSpeed;
    JTextField jTxtRegistrationNumber;
    JTextField jTxtDailyHireRate;
    JTextField jTxtLoadCapacity;
    JPanel panel;
    JFrame frame;

    public LorryView() {
    }

    public void addLorryGUI(JFrame frame) {
        this.frame = frame;
        this.panel = new JPanel();
        JPanel addLorryPanel = new JPanel();
        this.panel.setLayout((LayoutManager)null);
        JLabel jLblMake = new JLabel("Make (Honda, Ford): ");
        JLabel jLblModel = new JLabel("Model (2015): ");
        JLabel jLblTopSpeed = new JLabel("Top Speed (150): ");
        JLabel jLblRegistrationNumber = new JLabel("Registration Number: ");
        JLabel jLblDailyHireRate = new JLabel("Daily Hire Rate: ");
        JLabel jLblLoadCapacity = new JLabel("Load Capacity: ");
        JLabel jLblTitle = new JLabel("Enter Lorry Details");
        Font font1 = new Font("SansSerif", 1, 25);
        jLblTitle.setFont(font1);
        this.jTxtMake = new JTextField(8);
        this.jTxtModel = new JTextField(8);
        this.jTxtTopSpeed = new JTextField(8);
        this.jTxtRegistrationNumber = new JTextField(8);
        this.jTxtDailyHireRate = new JTextField(8);
        this.jTxtLoadCapacity = new JTextField(8);
        this.jBtnAddLorry = new JButton("Add Lorry");
        this.jBtnCancel = new JButton("Cancel");
        this.jBtnAddLorry.setMaximumSize(new Dimension(260, 50));
        this.jBtnCancel.setMaximumSize(new Dimension(260, 50));
        addLorryPanel.add(jLblTitle);
        addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addLorryPanel.add(jLblMake);
        addLorryPanel.add(this.jTxtMake);
        addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addLorryPanel.add(jLblModel);
        addLorryPanel.add(this.jTxtModel);
        addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addLorryPanel.add(jLblTopSpeed);
        addLorryPanel.add(this.jTxtTopSpeed);
        addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addLorryPanel.add(jLblRegistrationNumber);
        addLorryPanel.add(this.jTxtRegistrationNumber);
        addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addLorryPanel.add(jLblDailyHireRate);
        addLorryPanel.add(this.jTxtDailyHireRate);
        addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addLorryPanel.add(jLblLoadCapacity);
        addLorryPanel.add(this.jTxtLoadCapacity);
        addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addLorryPanel.add(this.jBtnAddLorry);
        addLorryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addLorryPanel.add(this.jBtnCancel);
        addLorryPanel.setLayout(new BoxLayout(addLorryPanel, 1));
        addLorryPanel.setBounds(370, 10, 250, 530);
        this.panel.add(addLorryPanel);
        frame.add(this.panel);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public String getMake() {
        return this.jTxtMake.getText().trim();
    }

    public int getModel() {
        return Integer.parseInt(this.jTxtModel.getText());
    }

    public int getTopSpeed() {
        return Integer.parseInt(this.jTxtTopSpeed.getText());
    }

    public int getLoadingCapacity() {
        return Integer.parseInt(this.jTxtLoadCapacity.getText());
    }

    public double getDailyHireRate() {
        return Double.parseDouble(this.jTxtDailyHireRate.getText());
    }

    public String getRegistrationNumber() {
        return this.jTxtRegistrationNumber.getText().trim();
    }

    public void displayError(ArrayList<String> errors) {
        String err = "";

        for(String error : errors) {
            err = err + error + "\n";
        }

        JOptionPane.showMessageDialog(this.frame, err, "Error", 2);
    }

    public void displaySuccessMessage(String success) {
        JOptionPane.showMessageDialog(this.frame, success, "Success", 1);
    }
}
