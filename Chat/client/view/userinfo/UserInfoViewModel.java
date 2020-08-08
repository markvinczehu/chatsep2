package Chat.client.view.userinfo;

import Chat.client.model.userinfo.UserInfoModel;
import Chat.shared.networking.UserInfo;
import DAO.DAOImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.sql.SQLException;

public class UserInfoViewModel {

private UserInfoModel userInfoModel;
  private StringProperty username;
  private StringProperty firstName;
  private StringProperty lastName;
  private StringProperty yearsOld;
  private StringProperty emailAddress;
  private StringProperty phoneNumber;
  private StringProperty status;



  public UserInfoViewModel(UserInfoModel userInfoModel)
  {
    this.userInfoModel=userInfoModel;
    username = new SimpleStringProperty();
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    yearsOld = new SimpleStringProperty();
    emailAddress = new SimpleStringProperty();
    phoneNumber = new SimpleStringProperty();
    status = new SimpleStringProperty();
    userInfoModel.addListener("UserInfo", this::onUserInfo);
  }

  private void onUserInfo(PropertyChangeEvent event)
  {
    UserInfo userInfo = (UserInfo) event.getNewValue();
    System.out.println(userInfo.getUsername() + "back to viewmodel for userinfo");
    username.setValue(userInfo.getUsername());
    firstName.setValue(userInfo.getFirstName());
    lastName.setValue(userInfo.getLastName());
    yearsOld.setValue(userInfo.getAge());
    emailAddress.setValue(userInfo.getEmail());
    phoneNumber.setValue(userInfo.getPhoneNumber());
    if (userInfo.getIsOnline())
    {
      status.setValue("Online");
    }
    else
    {
      status.setValue("Offline");
    }

  }

  public void getInfo()
  {
    userInfoModel.getInfo();
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
  public StringProperty phoneNumberProperty()
  {
    return phoneNumber;
  }
  public StringProperty statusProperty(){
    return status;
  }
}