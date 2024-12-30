
package user;

import dashboard.CustomerDashboardView;
import dashboard.Dashboard;
import dashboard.DashboardController;
import dashboard.StaffDashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserController implements ActionListener {
    private User model;
    private UserView view;

    public UserController(UserView view, User model, JFrame frame, String accountType) {
        this.view = view;
        this.model = model;
        if (accountType.contentEquals("customer")) {
            this.view.customerRegisterGUI(frame);
        } else {
            this.view.staffRegisterGUI(frame);
        }

        view.jBtnRegisterCustomer.addActionListener(this);
        view.jBtnRegisterStaff.addActionListener(this);
        view.jBtnCancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.jBtnRegisterCustomer) {
            new ArrayList();
            ArrayList<String> errors = this.model.validateCustomer(this.view.getIdentificationNumber(), this.view.getCorporationName(), this.view.getAddress(), this.view.getPhoneNumber(), this.view.getEmail(), this.view.getUsername(), this.view.getPassword());
            if (errors.size() == 0) {
                this.model.setIdentificationNumber(this.view.getIdentificationNumber());
                this.model.setCorporationName(this.view.getCorporationName());
                this.model.setPhoneNumber(this.view.getPhoneNumber());
                this.model.setAddress(this.view.getAddress());
                this.model.setEmail(this.view.getEmail());
                this.model.setUsername(this.view.getUsername());
                this.model.setPassword(this.view.getPassword());
                this.model.storeObject(this.model, "./src/resources/customerObjects.dat");
                this.staffHomePage();
                JOptionPane.showMessageDialog(this.view.frame, "Customer Record Created!", "Success", 1);
            } else {
                this.view.displayError(errors);
            }
        } else if (e.getSource() == this.view.jBtnRegisterStaff) {
            new ArrayList();
            ArrayList<String> var3 = this.model.validateStaff(this.view.getUsername(), this.view.getPassword());
            if (var3.size() == 0) {
                this.model.setUsername(this.view.getUsername());
                this.model.setPassword(this.view.getPassword());
                this.model.storeObject(this.model, "./src/resources/staffObjects.dat");
                this.staffHomePage();
                JOptionPane.showMessageDialog(this.view.frame, "Staff Record Created!", "Success", 1);
            } else {
                this.view.displayError(var3);
            }
        } else if (e.getSource() == this.view.jBtnCancel) {
            this.staffHomePage();
        }

    }

    public void staffHomePage() {
        this.view.panel.setVisible(false);
        Dashboard dashboard = new Dashboard();
        StaffDashboardView staffDashboardView = new StaffDashboardView();
        CustomerDashboardView customerDashboardView = new CustomerDashboardView();
        new DashboardController(staffDashboardView, customerDashboardView, dashboard, this.view.frame, "staff", this.view.getUsername());
    }
}
