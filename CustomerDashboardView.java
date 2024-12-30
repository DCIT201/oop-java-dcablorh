package dashboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import user.User;

public class CustomerDashboardView {
    JPanel panel;
    JPanel userDataPanel;
    JPanel hiredVehiclePanel;
    JFrame frame;
    JList<String> list1;
    JList<String> list2;
    JList<String> list3;
    JList<String> hiredVehicleList;
    JButton jBtnRequestVehicle;
    JButton jBtnViewProfile;
    JButton jBtnDisplayVehicles;
    JButton jBtnDisplayHiredVehicles;
    JButton jBtnLogout;
    JLabel jLblIdentificationNumber;
    JLabel jLblIdentificationNumberValue;
    JLabel jLblCorporationName;
    JLabel jLblCorporationNameValue;
    JLabel jLblAddress;
    JLabel jLblAddressValue;
    JLabel jLblPhoneNumber;
    JLabel jLblPhoneNumberValue;
    JLabel jLblEmail;
    JLabel jLblEmailValue;
    JLabel jLblUsername;
    JLabel jLblUsernameValue;
    JLabel jLblCarTitle;
    JLabel jLblLorryTitle;
    JLabel jLblTruckTitle;
    JLabel jLblHiredVehicle;
    JLabel jLblProfileTitle;
    JScrollPane carScrollPane;
    JScrollPane lorryScrollPane;
    JScrollPane TruckScrollPane;

    public CustomerDashboardView() {
    }

    public void GUI(JFrame frame) {
        this.frame = frame;
        this.panel = new JPanel();
        this.panel.setLayout((LayoutManager)null);
        this.jBtnRequestVehicle = new JButton("Request to Hire");
        this.jBtnViewProfile = new JButton("View Profile");
        this.jBtnDisplayVehicles = new JButton("Display Vehicles");
        this.jBtnDisplayHiredVehicles = new JButton("Display Hired Vehicles");
        this.jBtnLogout = new JButton("Logout");
        this.jBtnViewProfile.setBounds(190, 10, 200, 30);
        this.jBtnRequestVehicle.setBounds(400, 10, 200, 30);
        this.jBtnDisplayVehicles.setBounds(400, 10, 200, 30);
        this.jBtnDisplayHiredVehicles.setBounds(610, 10, 200, 30);
        this.jBtnLogout.setBounds(10, 620, 200, 30);
        this.jBtnDisplayVehicles.setVisible(false);
        this.panel.add(this.jBtnViewProfile);
        this.panel.add(this.jBtnRequestVehicle);
        this.panel.add(this.jBtnDisplayVehicles);
        this.panel.add(this.jBtnDisplayHiredVehicles);
        this.panel.add(this.jBtnLogout);
        this.panel.setSize(1000, 700);
        frame.add(this.panel);
    }

    public void displayVehicles(DefaultListModel<String> l1, DefaultListModel<String> l3, DefaultListModel<String> l2, ArrayList<String> list) {
        this.carScrollPane = new JScrollPane();
        this.lorryScrollPane = new JScrollPane();
        this.TruckScrollPane = new JScrollPane();
        this.jLblCarTitle = new JLabel("Cars for Hire");
        this.jLblLorryTitle = new JLabel("Lorry for Hire");
        this.jLblTruckTitle = new JLabel("Truck for Hire");
        this.list1 = new JList(l1);
        this.carScrollPane.setViewportView(this.list1);
        this.carScrollPane.setBounds(150, 90, 700, 100);
        this.jLblCarTitle.setFont(new Font("Serif", 1, 20));
        this.jLblCarTitle.setBounds(450, 60, 200, 30);
        this.panel.add(this.jLblCarTitle);
        this.panel.add(this.carScrollPane);
        this.list2 = new JList(l2);
        this.lorryScrollPane.setViewportView(this.list2);
        this.lorryScrollPane.setBounds(150, 240, 700, 100);
        this.jLblLorryTitle.setFont(new Font("Serif", 1, 20));
        this.jLblLorryTitle.setBounds(450, 200, 200, 30);
        this.panel.add(this.lorryScrollPane);
        this.panel.add(this.jLblLorryTitle);
        this.list3 = new JList(l3);
        this.TruckScrollPane.setViewportView(this.list3);
        this.TruckScrollPane.setBounds(150, 390, 700, 100);
        this.jLblTruckTitle.setFont(new Font("Serif", 1, 20));
        this.jLblTruckTitle.setBounds(450, 350, 200, 30);
        this.panel.add(this.TruckScrollPane);
        this.panel.add(this.jLblTruckTitle);
    }

    public void displayUserData(User user) {
        this.userDataPanel = new JPanel();
        this.jLblIdentificationNumber = new JLabel("Identificaiton Number: ");
        this.jLblIdentificationNumberValue = new JLabel(user.getIdentificationNumber());
        this.jLblCorporationName = new JLabel("Corporation Name: ");
        this.jLblCorporationNameValue = new JLabel(user.getCorporationName());
        this.jLblAddress = new JLabel("Address: ");
        this.jLblAddressValue = new JLabel(user.getAddress());
        this.jLblPhoneNumber = new JLabel("Phone Number: ");
        this.jLblPhoneNumberValue = new JLabel(user.getPhoneNumber());
        this.jLblEmail = new JLabel("Email: ");
        this.jLblEmailValue = new JLabel(user.getEmail());
        this.jLblUsername = new JLabel("Username: ");
        this.jLblUsernameValue = new JLabel(user.getUsername());
        this.userDataPanel.setLayout(new BoxLayout(this.userDataPanel, 1));
        this.jLblProfileTitle = new JLabel("Your Information");
        this.userDataPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.userDataPanel.add(this.jLblIdentificationNumber);
        this.userDataPanel.add(this.jLblIdentificationNumberValue);
        this.userDataPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.userDataPanel.add(this.jLblCorporationName);
        this.userDataPanel.add(this.jLblCorporationNameValue);
        this.userDataPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.userDataPanel.add(this.jLblAddress);
        this.userDataPanel.add(this.jLblAddressValue);
        this.userDataPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.userDataPanel.add(this.jLblPhoneNumber);
        this.userDataPanel.add(this.jLblPhoneNumberValue);
        this.userDataPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.userDataPanel.add(this.jLblEmail);
        this.userDataPanel.add(this.jLblEmailValue);
        this.userDataPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.userDataPanel.add(this.jLblUsername);
        this.userDataPanel.add(this.jLblUsernameValue);
        this.userDataPanel.setVisible(true);
        this.jLblProfileTitle.setVisible(true);
        this.jLblProfileTitle.setFont(new Font("Serif", 1, 20));
        this.userDataPanel.setBounds(400, 120, 300, 400);
        this.jLblProfileTitle.setBounds(420, 90, 200, 30);
        this.panel.add(this.jLblProfileTitle);
        this.panel.add(this.userDataPanel);
    }

    public void displayError(String error) {
        JOptionPane.showMessageDialog(this.frame, error, "Error", 2);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void displayHiredVehicles(DefaultListModel<String> l1) {
        this.hiredVehiclePanel = new JPanel();
        this.jLblHiredVehicle = new JLabel("Currently Hired Vehicles");
        this.hiredVehiclePanel.setLayout((LayoutManager)null);
        this.hiredVehicleList = new JList(l1);
        this.hiredVehicleList.setBounds(0, 0, 600, 400);
        this.hiredVehiclePanel.add(this.hiredVehicleList);
        this.hiredVehiclePanel.setBounds(200, 150, 600, 400);
        this.jLblHiredVehicle.setBounds(400, 100, 300, 30);
        this.panel.add(this.hiredVehiclePanel);
        this.panel.add(this.jLblHiredVehicle);
        this.jLblHiredVehicle.setFont(new Font("Serif", 1, 20));
        this.hiredVehiclePanel.setVisible(true);
        this.jLblHiredVehicle.setVisible(true);
        this.hiredVehiclePanel.setBackground(Color.white);
    }

    public void displaySuccessMessage() {
        JOptionPane.showMessageDialog(this.frame, "Vehicle has been requested for Hire!", "Success", 1);
    }
}
