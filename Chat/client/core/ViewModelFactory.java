package Chat.client.core;

import Chat.client.view.commonchat.CommonChatViewModel;
import Chat.client.view.login.LoginViewModel;
import Chat.client.view.registration.RegistrationViewModel;
import Chat.client.view.profile.ProfileViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private LoginViewModel loginViewModel;
  private RegistrationViewModel registrationViewModel;
  private CommonChatViewModel commonChatViewModel;
  private ProfileViewModel profileViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    modelFactory = mf;
  }

  public LoginViewModel getLoginViewModel()
  {
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

  public ProfileViewModel getProfileViewModel() {
    if(profileViewModel == null) {
      profileViewModel = new ProfileViewModel(modelFactory.getProfileModel());
    }
    return profileViewModel;
  }
}
