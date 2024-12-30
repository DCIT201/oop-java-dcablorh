package car;

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

public class CarView {
    JButton jBtnAddCar;
    JButton jBtnCancel;
    JTextField jTxtmake;
    JTextField jTxtmodel;
    JTextField jTxttopSpeed;
    JTextField jTxtregistrationNumber;
    JTextField jTxtdailyHireRate;
    JTextField jTxtfuelType;
    JTextField jTxtnumberOfDoors;
    JPanel panel;
    JPanel addCarPanel;
    JFrame frame;

    public CarView() {
    }

    public void addCarGUI(JFrame frame) {
        this.frame = frame;
        this.panel = new JPanel();
        this.addCarPanel = new JPanel();
        this.addCarPanel.setLayout((LayoutManager)null);
        JLabel jLblMake = new JLabel("Make (Honda, Ford): ");
        JLabel jLblModel = new JLabel("Model (2015): ");
        JLabel jLblTopSpeed = new JLabel("Top Speed (150): ");
        JLabel jLblRegistrationNumber = new JLabel("Registration Number: ");
        JLabel jLblDailyHireRate = new JLabel("Daily Hire Rate: ");
        JLabel jLblFuelType = new JLabel("Fuel Type (Petrol/Diesel): ");
        JLabel jLblNumberOfDoors = new JLabel("Number of Doors: ");
        JLabel jLblTitle = new JLabel("Enter Car Details");
        Font font1 = new Font("SansSerif", 1, 25);
        jLblTitle.setFont(font1);
        this.jTxtmake = new JTextField(8);
        this.jTxtmodel = new JTextField(8);
        this.jTxttopSpeed = new JTextField(8);
        this.jTxtregistrationNumber = new JTextField(8);
        this.jTxtdailyHireRate = new JTextField(8);
        this.jTxtfuelType = new JTextField(8);
        this.jTxtnumberOfDoors = new JTextField(8);
        this.jBtnAddCar = new JButton("Add Car");
        this.jBtnCancel = new JButton("Cancel");
        this.jBtnAddCar.setMaximumSize(new Dimension(260, 50));
        this.jBtnCancel.setMaximumSize(new Dimension(260, 50));
        this.panel.add(jLblTitle);
        this.panel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.panel.add(jLblMake);
        this.panel.add(this.jTxtmake);
        this.panel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.panel.add(jLblModel);
        this.panel.add(this.jTxtmodel);
        this.panel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.panel.add(jLblTopSpeed);
        this.panel.add(this.jTxttopSpeed);
        this.panel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.panel.add(jLblRegistrationNumber);
        this.panel.add(this.jTxtregistrationNumber);
        this.panel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.panel.add(jLblDailyHireRate);
        this.panel.add(this.jTxtdailyHireRate);
        this.panel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.panel.add(jLblFuelType);
        this.panel.add(this.jTxtfuelType);
        this.panel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.panel.add(jLblNumberOfDoors);
        this.panel.add(this.jTxtnumberOfDoors);
        this.panel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.panel.add(this.jBtnAddCar);
        this.panel.add(Box.createRigidArea(new Dimension(0, 10)));
        this.panel.add(this.jBtnCancel);
        this.panel.setLayout(new BoxLayout(this.panel, 1));
        this.panel.setBounds(370, 10, 250, 600);
        this.addCarPanel.add(this.panel);
        frame.add(this.addCarPanel);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public String getMake() {
        return this.jTxtmake.getText().trim();
    }

    public int getModel() {
        return Integer.parseInt(this.jTxtmodel.getText());
    }

    public int getTopSpeed() {
        return Integer.parseInt(this.jTxttopSpeed.getText());
    }

    public int getNumberOfDoors() {
        return Integer.parseInt(this.jTxtnumberOfDoors.getText());
    }

    public double getDailyHireRate() {
        return Double.parseDouble(this.jTxtdailyHireRate.getText());
    }

    public String getFuelType() {
        return this.jTxtfuelType.getText().trim();
    }

    public String getRegistrationNumber() {
        return this.jTxtregistrationNumber.getText().trim();
    }

    public void displayError(ArrayList<String> errors) {
        String err = "";

        for(String error : errors) {
            err = err + error + "\n";
        }

        JOptionPane.showMessageDialog(this.frame, err, "Error", 2);
    }

    public void displaySuccessMessage() {
        JOptionPane.showMessageDialog(this.frame, "Car Created!", "Success", 1);
    }
}
