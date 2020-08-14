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
  private String guestUsername;

  public LoginViewModel(LoginModel loginModel)
  {
    this.loginModel = loginModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }
  public boolean loginUser(){
    if((username.getValue() == null || "".equals(username.getValue())) && (password.getValue() == null || "".equals(password.get())))
    {
      error.setValue("Please enter a username and a password");
    }
    else if(!(username.getValue() == null || "".equals(username.getValue())) && (password.getValue() == null || "".equals(password.get())))
    {
      error.setValue("Please enter a password");
    }
    else if((username.getValue() == null || "".equals(username.getValue())) && !(password.getValue() == null || "".equals(password.get())))
    {
      error.setValue("Please enter a username");
    }
    else if(!(username.getValue() == null || "".equals(username.getValue())) && !(password.getValue() == null || "".equals(password.get())))
    {
      String un = username.get();
      String pw = password.get();
      if(loginModel.loginUser(un, pw))
      {
        return true;
      }
      else
      {
        error.setValue("Account does not exist");
        return false;
      }
    }
    else return false;
    return false;
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

  public void setGuestUser()
  {
    loginModel.setGuestUser();
  }
}
