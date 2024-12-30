package login;

import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {
    JButton jBtnLoginCustomer;
    JButton jBtnLoginStaff;
    JTextField jTxtUsername;
    JPasswordField jTxtPassword;
    JPanel panel;

    public LoginView() {
    }

    public void GUI(JFrame frame) {
        this.panel = new JPanel();
        this.panel.setLayout((LayoutManager)null);
        JLabel jLblLogin = new JLabel("LOGIN");
        JLabel jLblUsername = new JLabel("Username: ");
        JLabel jLblPassword = new JLabel("Password: ");
        this.jTxtUsername = new JTextField(8);
        this.jTxtPassword = new JPasswordField(8);
        this.jBtnLoginCustomer = new JButton("Customer Login");
        this.jBtnLoginStaff = new JButton("Staff Login");
        Font font1 = new Font("SansSerif", 1, 25);
        jLblLogin.setFont(font1);
        jLblLogin.setBounds(460, 90, 100, 30);
        jLblUsername.setBounds(330, 180, 100, 30);
        this.jTxtUsername.setBounds(490, 180, 200, 30);
        jLblPassword.setBounds(330, 250, 100, 30);
        this.jTxtPassword.setBounds(490, 250, 200, 30);
        this.jBtnLoginCustomer.setBounds(340, 350, 150, 30);
        this.jBtnLoginStaff.setBounds(530, 350, 150, 30);
        this.panel.add(jLblLogin);
        this.panel.add(jLblUsername);
        this.panel.add(this.jTxtUsername);
        this.panel.add(jLblPassword);
        this.panel.add(this.jTxtPassword);
        this.panel.add(this.jBtnLoginCustomer);
        this.panel.add(this.jBtnLoginStaff);
        this.panel.setSize(1000, 700);
        frame.add(this.panel);
    }

    public String getUsername() {
        return this.jTxtUsername.getText().trim();
    }

    public String getPassword() {
        return this.jTxtPassword.getText().trim();
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
