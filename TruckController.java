
package Truck;

import dashboard.CustomerDashboardView;
import dashboard.Dashboard;
import dashboard.DashboardController;
import dashboard.StaffDashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class TruckController implements ActionListener {
    private TruckView view;
    private Truck model;
    private String username;

    public TruckController(TruckView view, Truck model, JFrame frame, String username) {
        this.view = view;
        this.model = model;
        this.username = username;
        view.addTruckGUI(frame);
        view.jBtnAddTruck.addActionListener(this);
        view.jBtnCancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.jBtnAddTruck) {
            new ArrayList();
            ArrayList<String> errors = this.model.validateTruck(this.view.jTxtMake.getText(), this.view.jTxtModel.getText(), this.view.jTxtTopSpeed.getText(), this.view.jTxtRegistrationNumber.getText(), this.view.jTxtDailyHireRate.getText(), this.view.jTxtSeatingCapacity.getText());
            if (errors.size() == 0) {
                Truck Truck = new Truck(this.view.getMake(), this.view.getModel(), this.view.getTopSpeed(), this.view.getRegistrationNumber(), this.view.getDailyHireRate(), this.view.getSeatingCapacity());
                this.model.storeObject(Truck, "./src/resources/TruckObjects.dat");
                this.homepage();
                this.view.displaySuccessMessage();
            } else {
                this.view.displayError(errors);
            }
        } else if (e.getSource() == this.view.jBtnCancel) {
            this.homepage();
        }

    }

    public void homepage() {
        this.view.panel.setVisible(false);
        Dashboard dashboard = new Dashboard();
        StaffDashboardView staffDashboardView = new StaffDashboardView();
        CustomerDashboardView customerDashboardView = new CustomerDashboardView();
        new DashboardController(staffDashboardView, customerDashboardView, dashboard, this.view.frame, "staff", this.username);
    }
}
