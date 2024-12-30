package user;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserView {
    JButton jBtnLogin;
    JButton jBtnRegisterCustomer;
    JButton jBtnRegisterStaff;
    JButton jBtnCancel;
    JTextField jTxtUsername;
    JTextField jTxtEmail;
    JTextField jTxtIdentificationNumber;
    JTextField jTxtCorporationName;
    JTextField jTxtAddress;
    JTextField jTxtPhoneNumber;
    JPasswordField jTxtPassword;
    JPanel panel;
    JFrame frame;

    public UserView() {
    }

    public void staffRegisterGUI(JFrame frame) {
        this.frame = frame;
        this.panel = new JPanel();
        this.panel.setLayout((LayoutManager)null);
        JLabel jLblUsername = new JLabel("Username: ");
        JLabel jLblPassword = new JLabel("Password: ");
        JLabel jLblTitle = new JLabel("Enter Staff's Login Detail");
        Font font1 = new Font("SansSerif", 1, 25);
        jLblTitle.setFont(font1);
        this.jTxtUsername = new JTextField(8);
        this.jTxtPassword = new JPasswordField(8);
        this.jBtnRegisterStaff = new JButton("Register");
        this.jBtnRegisterCustomer = new JButton();
        this.jBtnCancel = new JButton("Cancel");
        jLblTitle.setBounds(360, 80, 400, 30);
        jLblUsername.setBounds(330, 180, 200, 30);
        this.jTxtUsername.setBounds(490, 180, 200, 30);
        jLblPassword.setBounds(330, 250, 200, 30);
        this.jTxtPassword.setBounds(490, 250, 200, 30);
        this.jBtnRegisterStaff.setBounds(510, 330, 200, 30);
        this.jBtnCancel.setBounds(300, 330, 200, 30);
        this.panel.add(jLblTitle);
        this.panel.add(jLblUsername);
        this.panel.add(this.jTxtUsername);
        this.panel.add(jLblPassword);
        this.panel.add(this.jTxtPassword);
        this.panel.add(this.jBtnRegisterStaff);
        this.panel.add(this.jBtnCancel);
        this.panel.setSize(1000, 700);
        frame.add(this.panel);
    }

    public void customerRegisterGUI(JFrame frame) {
        this.frame = frame;
        this.panel = new JPanel();
        JPanel addCustomerPanel = new JPanel();
        this.panel.setLayout((LayoutManager)null);
        JLabel jLblTitle = new JLabel("Enter Customer's Detail");
        Font font1 = new Font("SansSerif", 1, 25);
        jLblTitle.setFont(font1);
        JLabel jLblIdentificationNumber = new JLabel("Customer Identification Number: ");
        JLabel jLblCorporationName = new JLabel("Corporation Name: ");
        JLabel jLblAddress = new JLabel("Address: ");
        JLabel jLblPhoneNumber = new JLabel("Phone Number: ");
        JLabel jLblEmail = new JLabel("Email: ");
        JLabel jLblUsername = new JLabel("Username: ");
        JLabel jLblPassword = new JLabel("Password: ");
        this.jTxtIdentificationNumber = new JTextField(8);
        this.jTxtCorporationName = new JTextField(8);
        this.jTxtAddress = new JTextField(8);
        this.jTxtPhoneNumber = new JTextField(8);
        this.jTxtEmail = new JTextField(8);
        this.jTxtUsername = new JTextField(8);
        this.jTxtPassword = new JPasswordField(8);
        this.jBtnRegisterCustomer = new JButton("Register");
        this.jBtnRegisterStaff = new JButton();
        this.jBtnCancel = new JButton("Cancel");
        this.jBtnCancel.setMaximumSize(new Dimension(350, 50));
        this.jBtnRegisterCustomer.setMaximumSize(new Dimension(350, 50));
        addCustomerPanel.add(jLblTitle);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addCustomerPanel.add(jLblIdentificationNumber);
        addCustomerPanel.add(this.jTxtIdentificationNumber);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addCustomerPanel.add(jLblCorporationName);
        addCustomerPanel.add(this.jTxtCorporationName);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addCustomerPanel.add(jLblAddress);
        addCustomerPanel.add(this.jTxtAddress);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addCustomerPanel.add(jLblPhoneNumber);
        addCustomerPanel.add(this.jTxtPhoneNumber);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addCustomerPanel.add(jLblEmail);
        addCustomerPanel.add(this.jTxtEmail);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addCustomerPanel.add(jLblUsername);
        addCustomerPanel.add(this.jTxtUsername);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addCustomerPanel.add(jLblPassword);
        addCustomerPanel.add(this.jTxtPassword);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addCustomerPanel.add(this.jBtnRegisterCustomer);
        addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addCustomerPanel.add(this.jBtnCancel);
        addCustomerPanel.setLayout(new BoxLayout(addCustomerPanel, 1));
        addCustomerPanel.setBounds(370, 10, 300, 600);
        this.panel.add(addCustomerPanel);
        frame.add(this.panel);
    }

    public String getIdentificationNumber() {
        return this.jTxtIdentificationNumber.getText().trim();
    }

    public String getCorporationName() {
        return this.jTxtCorporationName.getText().trim();
    }

    public String getAddress() {
        return this.jTxtAddress.getText().trim();
    }

    public String getPhoneNumber() {
        return this.jTxtPhoneNumber.getText().trim();
    }

    public String getEmail() {
        return this.jTxtEmail.getText().trim();
    }

    public String getUsername() {
        return this.jTxtUsername.getText().trim();
    }

    public String getPassword() {
        return this.jTxtPassword.getText().trim();
    }

    public void displayError(ArrayList<String> errors) {
        String err = "";

        for(String error : errors) {
            err = err + error + "\n";
        }

        JOptionPane.showMessageDialog(this.frame, err, "Error", 2);
    }
}
