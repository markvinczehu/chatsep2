package Chat.client.model.profile;

import Chat.client.network.profile.ProfileClient;

public class ProfileModelManager implements ProfileModel {

    private ProfileClient profileClient;

    public ProfileModelManager (ProfileClient profileClient)
    {
        this.profileClient=profileClient;
        profileClient.startClient();
    }

    @Override public void editProfileChecker(String un, String pw, String fn,
        String ln, String age, String pn, String pnumb, String email)
    {
        profileClient.editProfile(un, pw, fn, ln, age, pn, pnumb, email);
    }
}