package Chat.client.view.login;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Chat.client.view.registration.RegistrationViewModel;

import java.sql.SQLException;

import java.rmi.RemoteException;

public class LoginController implements ViewController
{
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;
  @FXML private Label loginErrorLabel;

  private LoginViewModel lvm;
  private ViewHandler vh;
  private RegistrationViewModel rvm;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf){
    this.vh = vh;
    lvm = vmf.getLoginViewModel();
    rvm=vmf.getRegistrationViewModel();
    loginErrorLabel.textProperty().bindBidirectional(lvm.errorProperty());
    usernameField.textProperty().bindBidirectional(lvm.usernameProperty());
    passwordField.textProperty().bindBidirectional(lvm.passwordProperty());
  }

  public void onLoginButton(ActionEvent actionEvent){
    boolean b = lvm.loginUser();
    if(b)
    {
      vh.openCommonChat();
      usernameField.clear();
      passwordField.clear();
      lvm.errorProperty().setValue("");
    }
  }

  @FXML
  void onRegisterRequest(ActionEvent actionEvent) {
    vh.openRegistrationView();
    rvm.clear();
  }

  @FXML
  void onEnterGuest (ActionEvent actionEvent) {
    lvm.setGuestUser();
    vh.openCommonChat();
  }
}
