package Chat.client.view;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf);
}
