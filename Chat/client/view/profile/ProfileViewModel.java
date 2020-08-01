package Chat.client.view.profile;

import Chat.client.model.profile.ProfileModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProfileViewModel
{

  private ProfileModel profileModel;
  private StringProperty username;
  private StringProperty password;
  private StringProperty firstName;
  private StringProperty lastName;
  private StringProperty yearsOld;
  private StringProperty profileName;
  private StringProperty emailAddress;
  private StringProperty phoneNumber;
  private StringProperty error;

  public ProfileViewModel(ProfileModel profileModel)
  {
    this.profileModel = profileModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    yearsOld = new SimpleStringProperty();
    profileName = new SimpleStringProperty();
    emailAddress = new SimpleStringProperty();
    phoneNumber = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public boolean editProfileChecker()
  {
    System.out.println("bitchballs");
    String un = username.get();
    String pw = password.get();
    String fn = firstName.get();
    String ln = lastName.get();
    String age = yearsOld.get();
    String pn = profileName.get();
    String email = emailAddress.get();
    String pnumb = phoneNumber.get();

    if (un != null && !"".equals(un))
    {
      username.set(un);
    }
    else
    {
      error.set("Please input a username");
      return false;
    }
    if (pw != null)
    {
      password.set(pw);
    }
    else
    {
      error.set("Please input a password");
      return false;
    }
    if (fn != null && !"".equals(fn) || ln != null && !"".equals(ln)
        || age != null && !"".equals(age) || email != null && !"".equals(email)
        || pn != null && !"".equals(pn) || pnumb != null && !"".equals(pnumb))
    {
      firstName.set(fn);
      lastName.set(ln);
      yearsOld.set(age);
      emailAddress.set(email);
      profileName.set(pn);
      phoneNumber.set(pnumb);
    }
    else
    {
      firstName.set("N/A");
      lastName.set("N/A");
      yearsOld.set("N/A");
      emailAddress.set("N/A");
      profileName.set("N/A");
      phoneNumber.set("N/A");
    }
    if (pn != null && !"".equals(pn))
    {
      error.set("Please input a profile name");
      return false;
    }
    profileModel.editProfileChecker(un, pw, fn, ln, age, pn, pnumb, email);
    return true;
  }

  public void clear() {
    username.set("");
    password.set("");
    firstName.set("");
    lastName.set("");
    yearsOld.set("");
    emailAddress.set("");
    profileName.set("");
    phoneNumber.set("");
    error.set("");
  }

  public StringProperty usernameProperty()
  {
    return username;
  }
  public StringProperty passwordProperty()
  {
    return password;
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
  public StringProperty errorProperty()
  {
    return error;
  }
}
