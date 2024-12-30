package login;

import java.io.File;
import java.util.ArrayList;
import user.User;

public class Login {
    public Login() {
    }

    public String validate(String username, String password, ArrayList<User> users) {
        if (this.checkIfUserExists(username, users)) {
            for(User user : users) {
                if (username.contentEquals(user.getUsername()) && password.contentEquals(user.getPassword())) {
                    return "Password Matched!";
                }
            }

            return "Password does not match!";
        } else {
            return "Username does not Exist!";
        }
    }

    public boolean checkIfUserExists(String username, ArrayList<User> users) {
        for(User user : users) {
            if (username.contentEquals(user.getUsername())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
}
