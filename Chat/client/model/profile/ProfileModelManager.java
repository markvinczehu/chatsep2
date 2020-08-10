package Chat.client.model.profile;

import Chat.client.network.profile.ProfileClient;
import Chat.shared.networking.UserInfo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProfileModelManager implements ProfileModel {

    private ProfileClient profileClient;

    public ProfileModelManager (ProfileClient profileClient)
    {
        this.profileClient=profileClient;
        profileClient.startClient();
    }

    @Override public void editProfileChecker(String un, String pw, String fn,
        String ln, String age, String pnumb, String email)
    {
        profileClient.editProfile(un, pw, fn, ln, age, pnumb, email);
    }

    @Override public UserInfo getProfileInfo()
    {
        return profileClient.getProfileInfo();
    }
}