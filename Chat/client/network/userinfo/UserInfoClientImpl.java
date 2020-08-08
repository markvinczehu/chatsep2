package Chat.client.network.userinfo;

import Chat.shared.networking.RMIServer;
import Chat.shared.networking.UserInfo;

import java.beans.PropertyChangeListener;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class UserInfoClientImpl implements UserInfoClient, Remote
{
    private RMIServer rmiServer;

    public UserInfoClientImpl()
    {

    }

 //   @Override public void seeUserInfo(String username, String firstName,
  //      String lastName, String age, String profileName, String email,
    //    String phoneNumber)
    {
//        try
//        {
//            rmiServer.seeUserInfo(username, firstName, lastName, age, profileName, email, phoneNumber);
//        } catch (RemoteException e)
//        {
//            e.printStackTrace();
//        }
    }

    @Override public void startClient()
    {
        try
        {
            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            rmiServer = (RMIServer) registry.lookup("Server");
        }catch (RemoteException | NotBoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override public void addListener(String evtName,
        PropertyChangeListener listener)
    {

    }

    @Override public void removeListener(String evtName,
        PropertyChangeListener listener)
    {

    }
    @Override public UserInfo getInfo(String username)
    {
        try
        {
            rmiServer.getCurrentUserInfo(username);
        } catch (RemoteException throwable)
        {
            throwable.printStackTrace();
        }
        return null;
    }
}
