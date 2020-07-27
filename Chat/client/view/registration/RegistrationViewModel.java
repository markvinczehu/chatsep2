package Chat.client.view.registration;
import Chat.client.model.registration.RegistrationModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class RegistrationViewModel {

    private RegistrationModel registrationModel;
    private StringProperty username;
    private StringProperty password;
    private StringProperty confirmPassword;
    private StringProperty error;

    public RegistrationViewModel(RegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        confirmPassword = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public void registerUser() {
        String un = username.get();
        if (un == null || un.equals("")) {
            error.set("Incorrect information");
            error.set("Please input a username");
        }

        String pw = password.get();
        if(pw == null) {
            error.set("Wrong information");
            error.set("Please input a password");
        }

        assert pw != null;
        if (!pw.equals(confirmPassword.get())) {
            error.set("Wrong information");
            error.set("Passwords do not match");
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

    public StringProperty errorProperty()
    {
        return error;
    }
    public void clear() {
        username.set("");
        password.set("");
        confirmPassword.set("");
    }
}