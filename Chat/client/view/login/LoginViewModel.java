package Chat.client.view.login;

import Chat.client.model.login.LoginModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private LoginModel loginModel;
  private StringProperty username;
  private StringProperty password;
  private StringProperty error;

  public LoginViewModel(LoginModel loginModel)
  {
    this.loginModel = loginModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }
  public boolean loginUserChecker(String username)
  {
    loginModel.loginUser(username);
    if (username == null || username.equals(""))
    {
      error.set("Incorrect username");
      return false;
    }
    if (password == null)
      {
        error.set("Incorrect password");
        return false;
      }
    return true;
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }
  public StringProperty errorProperty()
  {
    return error;
  }
}
