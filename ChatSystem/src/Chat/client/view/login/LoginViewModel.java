package Chat.client.view.login;

import Chat.client.model.login.LoginModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private LoginModel loginModel;
  private StringProperty username;
  private StringProperty password;

  public LoginViewModel(LoginModel loginModel)
  {
    this.loginModel = loginModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();

  }
  public void loginUser(String username)
  {
    loginModel.loginUser(username);
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }
}
