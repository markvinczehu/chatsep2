package Chat.client.view.userinfo;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.rmi.RemoteException;

public class UserInfoController implements ViewController
{

  @FXML
  private TextField username;
  @FXML
  private TextField firstName;
  @FXML
  private TextField lastName;
  @FXML
  private TextField age;
  @FXML
  private TextField PhoneNumber;
  @FXML
  private TextField eMailAddress;
  @FXML
  private TextField statusField;

  private UserInfoViewModel userInfoViewModel;
  private ViewHandler vh;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh=vh;
    userInfoViewModel=vmf.getUserInfoViewModel();
    username.textProperty().bindBidirectional(userInfoViewModel.usernameProperty());
    firstName.textProperty().bindBidirectional(userInfoViewModel.firstNameProperty());
    lastName.textProperty().bindBidirectional(userInfoViewModel.lastNameProperty());
    age.textProperty().bindBidirectional(userInfoViewModel.ageProperty());
    PhoneNumber.textProperty().bindBidirectional(userInfoViewModel.phoneNumberProperty());
    eMailAddress.textProperty().bindBidirectional(userInfoViewModel.emailProperty());
    statusField.textProperty().bindBidirectional(userInfoViewModel.statusProperty());
    userInfoViewModel.getInfo();
  }

  @FXML
  void onCancel(ActionEvent event) {
    vh.openCommonChat();
  }
}