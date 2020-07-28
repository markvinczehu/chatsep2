package Chat.client.view.login;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Chat.client.view.registration.RegistrationViewModel;

public class LoginController implements ViewController
{
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;

  private LoginViewModel lvm;
  private ViewHandler vh;
  private RegistrationViewModel rvm;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    lvm = vmf.getLoginViewModel();
    rvm=vmf.getRegistrationViewModel();
    usernameField.textProperty().bindBidirectional(lvm.usernameProperty());
    passwordField.textProperty().bindBidirectional(lvm.passwordProperty());
  }

  public void onLoginButton(ActionEvent actionEvent)
  {
    lvm.loginUser(usernameField.getText());
    vh.openCommonChat();
  }

  @FXML
  void onRegisterRequest(ActionEvent actionEvent) {
    vh.openRegistrationView();
    rvm.clear();
    rvm.registerUser();
  }
}
