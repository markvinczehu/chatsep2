package Chat.shared.networking;

import java.io.Serializable;

public class UserInfo implements Serializable
{
  private int id;
  private String username;
  private String firstName;
  private String lastName;
  private String age;
  private String email;
  private String phoneNumber;
  private boolean isOnline;

  public UserInfo(int id, String username, String firstName, String lastName, String age, String email, String phoneNumber, boolean isOnline)
  {
    this.id = id;
    this.username=username;
    this.firstName=firstName;
    this.lastName=lastName;
    this.age=age;
    this.email=email;
    this.phoneNumber=phoneNumber;
    this.isOnline = isOnline;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public void setEmail(String email)
  {
    this.email = email;
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

  public void setOnline(Boolean isOnline)
  {
    this.isOnline = isOnline;
  }

  public int getId()
  {
    return id;
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

  public String getEmail()
  {
    return email;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public Boolean getIsOnline()
  {
    return isOnline;
  }
}
