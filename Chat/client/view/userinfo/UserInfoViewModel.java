package Chat.client.view.userinfo;

import Chat.client.model.userinfo.UserInfoModel;
import DAO.DAOImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public class UserInfoViewModel {

private UserInfoModel userInfoModel;
  private StringProperty username;
  private StringProperty firstName;
  private StringProperty lastName;
  private StringProperty yearsOld;
  private StringProperty profileName;
  private StringProperty emailAddress;
  private StringProperty phoneNumber;



  public UserInfoViewModel(UserInfoModel userInfoModel)
  {
    this.userInfoModel=userInfoModel;
    username = new SimpleStringProperty();
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    yearsOld = new SimpleStringProperty();
    profileName = new SimpleStringProperty();
    emailAddress = new SimpleStringProperty();
    phoneNumber = new SimpleStringProperty();
  }

  public void seeUserInfo()
  {
    System.out.println("fuck u!!!!!!!!!");
    String un = username.get();

    userInfoModel.getInfo(un);
  }
  public StringProperty usernameProperty()
  {
    return username;
  }
  public StringProperty firstNameProperty()
  {
    return firstName;
  }
  public StringProperty lastNameProperty()
  {
    return lastName;
  }
  public StringProperty ageProperty()
  {
    return yearsOld;
  }
  public StringProperty emailProperty()
  {
    return emailAddress;
  }
  public StringProperty profileNameProperty()
  {
    return profileName;
  }
  public StringProperty phoneNumberProperty()
  {
    return phoneNumber;
  }
}