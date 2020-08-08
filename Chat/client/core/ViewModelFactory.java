package Chat.client.core;

import Chat.client.view.commonchat.CommonChatViewModel;
import Chat.client.view.login.LoginViewModel;
import Chat.client.view.registration.RegistrationViewModel;
import Chat.client.view.profile.ProfileViewModel;
import Chat.client.view.userinfo.UserInfoViewModel;
import Chat.client.view.privatechat.PrivateChatViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private LoginViewModel loginViewModel;
  private RegistrationViewModel registrationViewModel;
  private CommonChatViewModel commonChatViewModel;
  private ProfileViewModel profileViewModel;
  private UserInfoViewModel userInfoViewModel;
  private PrivateChatViewModel privateChatViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    modelFactory = mf;
  }

  public LoginViewModel getLoginViewModel(){
    if (loginViewModel == null)
    {
      loginViewModel = new LoginViewModel(modelFactory.getLoginModel());
    }
    return loginViewModel;
  }
  public RegistrationViewModel getRegistrationViewModel()
  {
    if(registrationViewModel == null)
    {
      registrationViewModel = new RegistrationViewModel(modelFactory.getRegistrationModel());
    }
    return registrationViewModel;
  }

  public CommonChatViewModel getCommonChatViewModel()
  {
    if (commonChatViewModel == null)
    {
      commonChatViewModel = new CommonChatViewModel(modelFactory.getCommonChatModel());
    }
    return commonChatViewModel;
  }

  public ProfileViewModel getProfileViewModel()
  {
    if(profileViewModel == null)
    {
      profileViewModel = new ProfileViewModel(modelFactory.getProfileModel());
    }
    return profileViewModel;
  }
  public UserInfoViewModel getUserInfoViewModel()
  {
    if (userInfoViewModel == null)
    {
      userInfoViewModel = new UserInfoViewModel(modelFactory.getUserInfoModel());
    }
    return userInfoViewModel;
  }
  public PrivateChatViewModel getPrivatChatViewModel() {
    if(privateChatViewModel == null) {
      privateChatViewModel = new PrivateChatViewModel(modelFactory.getPrivateChatModel());
    }
    return privateChatViewModel;
  }
}
