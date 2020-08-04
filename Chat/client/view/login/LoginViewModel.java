package Chat.client.view.login;

import Chat.client.model.login.LoginModel;
import Chat.server.model.ServerModelManager;
import DAO.DAOImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public class LoginViewModel
{
  private LoginModel loginModel;
  private StringProperty username;
  private StringProperty password;
  private StringProperty error;

  public LoginViewModel(LoginModel loginModel) throws SQLException
  {
    this.loginModel = loginModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }
  public boolean loginUserChecker() throws SQLException {
    String un = username.get();
    String pw = password.get();

    if (un !=null && !"".equals(un))
    {
      username.set(un);
    }
    else
    {
      error.set("Please input a correct username");
      return false;
    }
    if (pw != null && !"".equals(pw))
    {
      password.set(pw);
    }
    else
    {
      error.set("Please input a correct password");
      return false;
    }
    loginModel.loginUser(un, pw);
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
