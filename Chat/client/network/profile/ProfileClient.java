package Chat.client.network.profile;

import Chat.client.network.Client;

public interface ProfileClient extends Client
{
  void editProfile(String un, String pw, String fn, String ln, String age, String pn, String pnumb, String email);
}