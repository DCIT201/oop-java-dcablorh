package Truck;

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

public class TruckView {
    JButton jBtnAddTruck;
    JButton jBtnCancel;
    JTextField jTxtMake;
    JTextField jTxtModel;
    JTextField jTxtTopSpeed;
    JTextField jTxtRegistrationNumber;
    JTextField jTxtDailyHireRate;
    JTextField jTxtSeatingCapacity;
    JPanel panel;
    JFrame frame;

    public TruckView() {
    }

    public void addTruckGUI(JFrame frame) {
        this.frame = frame;
        this.panel = new JPanel();
        JPanel addTruckPanel = new JPanel();
        this.panel.setLayout((LayoutManager)null);
        JLabel jLblTitle = new JLabel("Enter Truck Details");
        Font font1 = new Font("SansSerif", 1, 25);
        jLblTitle.setFont(font1);
        JLabel jLblMake = new JLabel("Make (Honda, Ford): ");
        JLabel jLblModel = new JLabel("Model (2015): ");
        JLabel jLblTopSpeed = new JLabel("Top Speed (150): ");
        JLabel jLblRegistrationNumber = new JLabel("Registration Number: ");
        JLabel jLblDailyHireRate = new JLabel("Daily Hire Rate: ");
        JLabel jLblSeatingCapacity = new JLabel("Seating Capacity: ");
        this.jTxtMake = new JTextField(8);
        this.jTxtModel = new JTextField(8);
        this.jTxtTopSpeed = new JTextField(8);
        this.jTxtRegistrationNumber = new JTextField(8);
        this.jTxtDailyHireRate = new JTextField(8);
        this.jTxtSeatingCapacity = new JTextField(8);
        this.jBtnAddTruck = new JButton("Add");
        this.jBtnCancel = new JButton("Cancel");
        this.jBtnAddTruck.setMaximumSize(new Dimension(300, 70));
        this.jBtnCancel.setMaximumSize(new Dimension(300, 70));
        addTruckPanel.add(jLblTitle);
        addTruckPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addTruckPanel.add(jLblMake);
        addTruckPanel.add(this.jTxtMake);
        addTruckPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addTruckPanel.add(jLblModel);
        addTruckPanel.add(this.jTxtModel);
        addTruckPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addTruckPanel.add(jLblTopSpeed);
        addTruckPanel.add(this.jTxtTopSpeed);
        addTruckPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addTruckPanel.add(jLblRegistrationNumber);
        addTruckPanel.add(this.jTxtRegistrationNumber);
        addTruckPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addTruckPanel.add(jLblDailyHireRate);
        addTruckPanel.add(this.jTxtDailyHireRate);
        addTruckPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addTruckPanel.add(jLblSeatingCapacity);
        addTruckPanel.add(this.jTxtSeatingCapacity);
        addTruckPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addTruckPanel.add(this.jBtnAddTruck);
        addTruckPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addTruckPanel.add(this.jBtnCancel);
        addTruckPanel.setLayout(new BoxLayout(addTruckPanel, 1));
        addTruckPanel.setBounds(370, 10, 300, 530);
        this.panel.add(addTruckPanel);
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

    public int getSeatingCapacity() {
        return Integer.parseInt(this.jTxtSeatingCapacity.getText());
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

    public void displaySuccessMessage() {
        JOptionPane.showMessageDialog(this.frame, "Truck Created!", "Success", 1);
    }
}
