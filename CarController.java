
package car;

import dashboard.CustomerDashboardView;
import dashboard.Dashboard;
import dashboard.DashboardController;
import dashboard.StaffDashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class CarController implements ActionListener {
    private CarView view;
    private Car model;
    private String username;

    public CarController(CarView carView, Car carModel, JFrame frame, String username) {
        this.view = carView;
        this.model = carModel;
        this.username = username;
        this.view.addCarGUI(frame);
        this.view.jBtnAddCar.addActionListener(this);
        this.view.jBtnCancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.jBtnAddCar) {
            new ArrayList();
            ArrayList<String> errors = this.model.validateCar(this.view.jTxtmake.getText(), this.view.jTxtmodel.getText(), this.view.jTxttopSpeed.getText(), this.view.jTxtregistrationNumber.getText(), this.view.jTxtdailyHireRate.getText(), this.view.jTxtfuelType.getText(), this.view.jTxtnumberOfDoors.getText());
            if (errors.size() == 0) {
                Car car = new Car(this.view.getMake(), this.view.getModel(), this.view.getTopSpeed(), this.view.getRegistrationNumber(), this.view.getDailyHireRate(), this.view.getFuelType(), this.view.getNumberOfDoors());
                this.model.storeObject(car, "./src/resources/carObjects.dat");
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
        this.view.addCarPanel.setVisible(false);
        Dashboard dashboard = new Dashboard();
        StaffDashboardView staffDashboardView = new StaffDashboardView();
        CustomerDashboardView customerDashboardView = new CustomerDashboardView();
        new DashboardController(staffDashboardView, customerDashboardView, dashboard, this.view.frame, "staff", this.username);
    }
}
