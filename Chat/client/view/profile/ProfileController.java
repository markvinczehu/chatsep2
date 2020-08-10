package Chat.client.view.profile;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
    private TextField PhoneNumber;

    @FXML
    private TextField eMailAddress;

    @FXML
    private Label errorLabel;

    @FXML
    private ChoiceBox<String> statusChoice;

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
        PhoneNumber.textProperty().bindBidirectional(profileViewModel.phoneNumberProperty());
        eMailAddress.textProperty().bindBidirectional(profileViewModel.emailProperty());
        errorLabel.textProperty().bindBidirectional(profileViewModel.errorProperty());
        profileViewModel.getProfileInfo();
    }

    @FXML
    void onCancel(ActionEvent event) {
       vh.openCommonChat();
    }


    @FXML
    void onUpdate(ActionEvent event) {
        if (profileViewModel.editProfileChecker())
        {
           profileViewModel.errorProperty().set("Changes saved");
        }
    }
}
