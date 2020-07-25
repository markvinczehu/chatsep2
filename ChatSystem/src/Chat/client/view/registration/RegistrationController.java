package Chat.client.view.registration;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @FXML
    private Button resetButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;
    
    private RegistrationViewModel rvm;
    private ViewHandler vh;

    public void init(ViewHandler vh, RegistrationViewModel rvm) {
        this.RegistrationViewModel = rvm;
        this.ViewHandler = vh;
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

