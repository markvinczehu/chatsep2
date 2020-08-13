package Chat.client.model.profile;

import Chat.shared.transferobjects.UserInfo;

public interface ProfileModel
{
  void editProfileChecker(String un, String pw, String fn, String ln, String age, String pnumb, String email);
  UserInfo getProfileInfo();
}
