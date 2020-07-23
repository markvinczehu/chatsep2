package Chat.server.network;

import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements RMIServer
{
  public RMIServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public void message(String str, ClientCallback clientCallback)
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException ignored) {

    }

    try
    {
      clientCallback.messageResult(str);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
