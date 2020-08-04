package Chat.client.core;

import Chat.client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ViewHandler
{
  private Scene loginScene;
  private Scene commonChatScene;
  private Stage stage;
  private Scene registrationScene;
  private Scene profileScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    stage = new Stage();
    openLogin();
  }

  public void openLogin()
  {
    if(loginScene == null){
      try {
        Parent root = loadFXML("../view/login/Login.fxml");
        stage.setTitle("Login");
        loginScene = new Scene(root);
      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(loginScene);
    stage.show();
  }

  public void openRegistrationView()
  {
    if(registrationScene == null){
      try {
        Parent root = loadFXML("../view/registration/Registration.fxml");
        stage.setTitle("Registration");
        registrationScene = new Scene(root);
      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(registrationScene);
    stage.show();
  }

  public void openCommonChat()
  {
    if(commonChatScene == null){
      try {
        Parent root = loadFXML("../view/commonchat/CommonChat.fxml");
        stage.setTitle("CommonChat");
        commonChatScene = new Scene(root);
      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(commonChatScene);
    stage.show();
  }

  public void openProfile()
  {
    if(profileScene == null){
      try {
        Parent root = loadFXML("../view/profile/Profile.fxml");
        stage.setTitle("Profile");
        profileScene = new Scene(root);
      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(profileScene);
    stage.show();
  }

  private Parent loadFXML(String path) throws IOException, SQLException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this,viewModelFactory);
    return root;
  }
}
