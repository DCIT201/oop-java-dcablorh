package lorry;

import dashboard.CustomerDashboardView;
import dashboard.Dashboard;
import dashboard.DashboardController;
import dashboard.StaffDashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class LorryController implements ActionListener {
    private LorryView view;
    private Lorry model;
    private String username;

    public LorryController(LorryView view, Lorry model, JFrame frame, String username) {
        this.view = view;
        this.model = model;
        this.username = username;
        view.addLorryGUI(frame);
        view.jBtnAddLorry.addActionListener(this);
        view.jBtnCancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.jBtnAddLorry) {
            new ArrayList();
            ArrayList<String> errors = this.model.validateLorry(this.view.jTxtMake.getText(), this.view.jTxtModel.getText(), this.view.jTxtTopSpeed.getText(), this.view.jTxtRegistrationNumber.getText(), this.view.jTxtDailyHireRate.getText(), this.view.jTxtLoadCapacity.getText());
            if (errors.size() == 0) {
                Lorry lorry = new Lorry(this.view.getMake(), this.view.getModel(), this.view.getTopSpeed(), this.view.getRegistrationNumber(), this.view.getDailyHireRate(), this.view.getLoadingCapacity());
                this.model.storeObject(lorry, "./src/resources/lorryObjects.dat");
                this.homepage();
                this.view.displaySuccessMessage("Lorry Created!");
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
