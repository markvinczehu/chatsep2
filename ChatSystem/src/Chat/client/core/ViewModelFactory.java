package Chat.client.core;

import Chat.client.view.commonchat.CommonChatViewModel;
import Chat.client.view.login.LoginViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private LoginViewModel loginViewModel;
  private CommonChatViewModel commonChatViewModel;

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

  public CommonChatViewModel getCommonChatViewModel()
  {
    if (commonChatViewModel == null)
    {
      commonChatViewModel = new CommonChatViewModel();
    }
    return commonChatViewModel;
  }
}
