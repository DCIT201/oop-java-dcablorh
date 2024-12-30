import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import login.Login;
import login.LoginController;
import login.LoginView;

public class VehicleHireSystemController implements ActionListener {
    private VehicleHireSystemView view;
    private VehicleHireSystemModel model;

    public VehicleHireSystemController(VehicleHireSystemView view, VehicleHireSystemModel model) {
        this.model = model;
        this.view = view;
        view.GUI();
        view.jBtnEnter.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        this.view.getPanel().setVisible(false);
        Login loginModel = new Login();
        LoginView loginView = new LoginView();
        new LoginController(loginView, loginModel, this.view.getFrame());
    }
}
