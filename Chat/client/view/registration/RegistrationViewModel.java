package Chat.client.view.registration;
import Chat.client.model.registration.RegistrationModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;



public class RegistrationViewModel {

    private RegistrationModel registrationModel;
    private StringProperty username;
    private StringProperty password;
    private StringProperty confirmPassword;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public RegistrationViewModel(RegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        confirmPassword = new SimpleStringProperty();
    }

    public void registerUser() {
        String un = username.get();
        if (un == null || un.equals("")) {
            alert.setTitle("Wrong information");
            alert.setContentText("Please input a username.");
            alert.showAndWait();
        }

        String pw = password.get();
        if(pw == null) {
            alert.setTitle("Wrong information");
            alert.setContentText("Please input a password.");
            alert.showAndWait();
        }

        if (!pw.equals(confirmPassword.get())) {
            alert.setTitle("Wrong information");
            alert.setContentText("Passwords do not match.");
            alert.showAndWait();
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