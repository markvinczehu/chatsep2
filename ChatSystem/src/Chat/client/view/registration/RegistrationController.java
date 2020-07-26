package Chat.client.view.registration;
import Chat.client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Chat.client.view.registration.RegisterViewModel;


public class RegistrationController {

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordrep;

    @FXML
    private TextField userName;

    @FXML
    private Button resetButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;
    
    private RegisterViewModel rvm;
    private ViewHandler vh;

    public void init(ViewHandler vh, RegisterViewModel rvm) {
        this.rvm = rvm;
        this.vh = vh;
        userName.textProperty().bindBidirectional(rvm.usernameProperty());
        password.textProperty().bindBidirectional(rvm.passwordProperty());
        confirmPassword.textProperty().bindBidirectional(rvm.confirmPasswordProperty());
        errorLabel.textProperty().bind(rvm.registerResponseProperty());
        registerButton.disableProperty().bind(rvm.registerButtonDisabledProperty());
        rvm.registerResponseProperty().addListener((observableValue, oldValue, newValue) -> onRegisterResult(newValue));
    }

    @FXML
    void onCancel(ActionEvent event) {
        rvm.clear();
        vh.openLogin();
    }

    @FXML
    void createAccount(ActionEvent event) {
        rvm.registerUser();
    }

    @FXML
    void resetData(ActionEvent event) {

    }

}

