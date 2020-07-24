package Chat.server.model;

import java.util.ArrayList;

public class ServerModelManager implements ServerModel
{
  private ArrayList<String> users;

  public ServerModelManager()
  {
    users = new ArrayList<String>();
    users.add("Alex");
  }
  
  @Override public void loginUser()
  {
    for (String user: users)
    {
      if(user.equals("Alex"))
      {
        System.out.println("Yes");
      }
    }
  }
}
