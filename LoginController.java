package login;

import dashboard.CustomerDashboardView;
import dashboard.Dashboard;
import dashboard.DashboardController;
import dashboard.StaffDashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import user.User;

public class LoginController implements ActionListener {
    private LoginView view;
    private Login model;
    private JFrame frame;

    public LoginController(LoginView view, Login model, JFrame frame) {
        this.view = view;
        this.model = model;
        this.frame = frame;
        view.GUI(frame);
        view.jBtnLoginCustomer.addActionListener(this);
        view.jBtnLoginStaff.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.jBtnLoginCustomer) {
            User userModel = new User();
            if (this.model.checkIfFileExists("./src/resources/customerObjects.dat")) {
                ArrayList<User> users = userModel.getObjects("./src/resources/customerObjects.dat");
                String status = this.model.validate(this.view.getUsername(), this.view.getPassword(), users);
                if (status.contentEquals("Password Matched!")) {
                    this.view.getPanel().setVisible(false);
                    Dashboard dashboard = new Dashboard();
                    StaffDashboardView staffDashboardView = new StaffDashboardView();
                    CustomerDashboardView customerDashboardView = new CustomerDashboardView();
                    new DashboardController(staffDashboardView, customerDashboardView, dashboard, this.frame, "customer", this.view.getUsername());
                } else {
                    JOptionPane.showMessageDialog(this.frame, status, "Error", 2);
                }
            } else {
                JOptionPane.showMessageDialog(this.frame, "Username Does not Exist!", "Error", 2);
            }
        } else if (e.getSource() == this.view.jBtnLoginStaff) {
            User userModel = new User();
            if (this.model.checkIfFileExists("./src/resources/staffObjects.dat")) {
                ArrayList<User> users = userModel.getObjects("./src/resources/staffObjects.dat");
                String status = this.model.validate(this.view.getUsername(), this.view.getPassword(), users);
                if (status.contentEquals("Password Matched!")) {
                    this.view.getPanel().setVisible(false);
                    Dashboard dashboard = new Dashboard();
                    StaffDashboardView staffDashboardView = new StaffDashboardView();
                    CustomerDashboardView customerDashboardView = new CustomerDashboardView();
                    new DashboardController(staffDashboardView, customerDashboardView, dashboard, this.frame, "staff", this.view.getUsername());
                } else {
                    JOptionPane.showMessageDialog(this.frame, status, "Error", 2);
                }
            } else {
                JOptionPane.showMessageDialog(this.frame, "Username Does not Exist!", "Error", 2);
            }
        }

    }
}
