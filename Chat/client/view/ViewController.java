package Chat.client.view;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;

import java.rmi.RemoteException;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf) throws RemoteException;
}
