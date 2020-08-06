package Chat.client.core;

import Chat.client.model.commonchat.CommonChatModel;
import Chat.client.model.commonchat.CommonChatModelManager;
import Chat.client.model.login.LoginModel;
import Chat.client.model.login.LoginModelManager;
import Chat.client.model.registration.RegistrationModel;
import Chat.client.model.registration.RegistrationModelManager;
import Chat.client.model.profile.ProfileModel;
import Chat.client.model.profile.ProfileModelManager;
import Chat.client.model.userinfo.UserInfoModel;
import Chat.client.model.userinfo.UserInfoModelManager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private LoginModel loginModel;
  private CommonChatModel commonChatModel;
  private RegistrationModel registrationModel;
  private ProfileModel profileModel;
  private UserInfoModel userInfoModel;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public LoginModel getLoginModel()
  {
    if(loginModel == null)
    {
      loginModel = new LoginModelManager(clientFactory.getLoginClient());
    }
    return loginModel;
  }

  public CommonChatModel getCommonChatModel()
  {
    if(commonChatModel == null)
    {
      commonChatModel = new CommonChatModelManager(clientFactory.getCommonChatClient());
    }
    return commonChatModel;
  }

  public RegistrationModel getRegistrationModel()
  {
    if (registrationModel == null) {
      registrationModel = new RegistrationModelManager(clientFactory.getRegistrationClient());
    }
    return registrationModel;
  }

  public ProfileModel getProfileModel()
  {
    if(profileModel == null)
    {
      profileModel = new ProfileModelManager(clientFactory.getProfileClient());
    }
    return profileModel;
  }
  public UserInfoModel getUserInfoModel()
  {
    if (userInfoModel == null)
    {
      userInfoModel = new UserInfoModelManager(clientFactory.getUserInfoClient());
    }
    return userInfoModel;
  }
}
