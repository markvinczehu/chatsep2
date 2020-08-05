package Chat.client.view.registration;
import Chat.client.core.ViewHandler;
import Chat.client.model.registration.RegistrationModel;
import DAO.DAOImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;


public class RegistrationViewModel {

    private RegistrationModel registrationModel;
    private StringProperty username;
    private StringProperty password;
    private StringProperty confirmPassword;
    private StringProperty error;
    private ViewHandler vh;
    public RegistrationViewModel(RegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        confirmPassword = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public boolean registerUserChecker(){
        System.out.println("cunttits");
        String un = username.get();
        String pw = password.get();
        String cpw = confirmPassword.get();
        if (un != null && !"".equals(un)) {
            username.set(un);
        }
        else {
            error.set("Please input a username");
            return false;
        }
        if(pw != null) {
            password.set(pw);
        }
        else {
            error.set("Please input a password");
            return false;
        }
        if (!pw.equals(confirmPassword.get())) {
            error.set("Passwords do not match");
            return false;
        }
            registrationModel.registerUserChecker(un, pw);
            return true;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty confirmPasswordProperty() {
        return confirmPassword;
    }

    public StringProperty errorProperty()
    {
        return error;
    }
    public void clear() {
        username.set("");
        password.set("");
        confirmPassword.set("");
        error.set("");
    }
}