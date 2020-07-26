package Chat.client.view.registration;
import Chat.client.model.registration.RegistrationModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class RegistrationViewModel {

    private RegistrationModel registrationModel;
    private StringProperty username;
    private StringProperty password;
    private StringProperty confirmPassword;

    public RegistrationViewModel(RegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        confirmPassword = new SimpleStringProperty();
    }

    public void registerUser() {
        String un = username.get();
        if (un == null || un.equals("")) {
            registerResponse.set("Username needed!");
            return;
        }

        String pw = password.get();
        if(pw == null) {
            registerResponse.set("Password needed!");
            return;
        }

        if (!pw.equals(confirmPassword.get())) {
            registerResponse.set("Passwords do not match!");
            return;
        }
        registrationModel.registerUser(un, pw);
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

    public void clear() {
        username.set("");
        password.set("");
        confirmPassword.set("");
    }
}