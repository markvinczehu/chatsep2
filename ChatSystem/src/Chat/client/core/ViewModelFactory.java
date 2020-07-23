package Chat.client.core;

import Chat.client.view.login.LoginViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private LoginViewModel loginViewModel;

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
}
