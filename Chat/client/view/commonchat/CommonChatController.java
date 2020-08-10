package Chat.client.view.commonchat;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import Chat.client.view.userinfo.UserInfoViewModel;
import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CommonChatController implements ViewController
{
  @FXML private TextField messageField;
  @FXML private TextArea commonChatArea;
  @FXML private ListView<String> activeUsersList;

  private CommonChatViewModel commonChatViewModel;
  private ViewHandler vh;
  private UserInfoViewModel userInfoViewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    commonChatViewModel = vmf.getCommonChatViewModel();
    messageField.textProperty().bindBidirectional(commonChatViewModel.messageField());
    commonChatArea.setEditable(false);
    commonChatViewModel.chatArea().addListener((obs, old, newValue) ->{
      if(!newValue.equals(""))
      {
        commonChatArea.appendText(newValue + "\n");
        commonChatViewModel.chatArea().setValue("");
      }
    });
    commonChatViewModel.getCurrentUser();
    if(!commonChatViewModel.getGuestUser())
    {
      commonChatViewModel.getUserList();
    }
    activeUsersList.setItems(commonChatViewModel.allUsersList());
    activeUsersList.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<String>()
        {
          @Override public void changed(
              ObservableValue<? extends String> observableValue, String oldValue,
              String newValue)
          {
            if (!newValue.equals(""))
            {
              commonChatViewModel.getUserInfo(newValue);
              vh.openUserInfo();
            }
          }
        });

  }

  public void onSendButton(ActionEvent actionEvent)
  {
    if(messageField != null)
    {
      commonChatViewModel.sendMessage();
      messageField.clear();
    }
  }

  public void logOut(ActionEvent actionEvent) { vh.openLogin(); }

  public void onClickUser(ActionEvent actionEvent)
  {

  }

  public void openUpProfile(ActionEvent actionEvent) { vh.openProfile(); }
}