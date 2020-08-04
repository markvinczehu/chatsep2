package DAO;


import Chat.client.view.registration.RegistrationViewModel;

import java.sql.SQLException;

public class StartDB
{
  private static RegistrationViewModel rvm;
  public static void main(String[] args)
  {
    try{
      DAOImpl.getInstance().create(rvm.usernameProperty().toString(), rvm.passwordProperty().toString());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  public static void setRvm(RegistrationViewModel rvm) {
    StartDB.rvm = rvm;
  }
}
