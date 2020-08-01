package Chat.client.view.profile;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import Chat.client.view.commonchat.CommonChatViewModel;
import Chat.client.view.login.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProfileController implements ViewController
{

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField age;

    @FXML
    private TextField profileName;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private TextField eMailAddress;


    private ProfileViewModel profileViewModel;
    private ViewHandler vh;

    @Override public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.vh=vh;
        profileViewModel=vmf.getProfileViewModel();
        username.textProperty().bindBidirectional(profileViewModel.usernameProperty());
        password.textProperty().bindBidirectional(profileViewModel.passwordProperty());
        firstName.textProperty().bindBidirectional(profileViewModel.firstNameProperty());
        lastName.textProperty().bindBidirectional(profileViewModel.lastNameProperty());
        age.textProperty().bindBidirectional(profileViewModel.ageProperty());
        profileName.textProperty().bindBidirectional(profileViewModel.profileNameProperty());
        PhoneNumber.textProperty().bindBidirectional(profileViewModel.phoneNumberProperty());
        eMailAddress.textProperty().bindBidirectional(profileViewModel.emailProperty());
    }

    @FXML
    void onCancel(ActionEvent event) {
       vh.openCommonChat();
    }

    @FXML
    void onReset(ActionEvent event) {
        profileViewModel.clear();
    }

    @FXML
    void onUpdate(ActionEvent event) {
        profileViewModel.editProfileChecker();
    }
}
