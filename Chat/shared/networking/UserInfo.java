package Chat.shared.networking;

import java.io.Serializable;

public class UserInfo implements Serializable
{
  private String username;
  private String firstName;
  private String lastName;
  private String age;
  private String profileName;
  private String email;
  private String phoneNumber;

  public UserInfo(String username, String firstName, String lastName, String age, String profileName, String email, String phoneNumber)
  {
    this.username=username;
    this.firstName=firstName;
    this.lastName=lastName;
    this.age=age;
    this.profileName=profileName;
    this.email=email;
    this.phoneNumber=phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setProfileName(String profileName)
  {
    this.profileName = profileName;
  }

  public void setAge(String age)
  {
    this.age = age;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getUsername()
  {
    return username;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getAge()
  {
    return age;
  }

  public String getProfileName()
  {
    return profileName;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }
}
