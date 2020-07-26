package Chat.client.view.registration;
import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class RegistrationController  implements ViewController
{

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
    @FXML
    private Label errorLabel;
    
    private RegistrationViewModel rvm;
    private ViewHandler vh;

    @Override public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.vh = vh;
        userName.textProperty().bindBidirectional(rvm.usernameProperty());
        password.textProperty().bindBidirectional(rvm.passwordProperty());
        passwordrep.textProperty().bindBidirectional(rvm.confirmPasswordProperty());
    }

    private void onRegisterResult(ActionEvent event) {

        rvm.clear();
        vh.openLogin();
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
        rvm.clear();
    }
}

