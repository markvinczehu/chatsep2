package Chat.client.view.commonchat;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import Chat.shared.transferobjects.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CommonChatController implements ViewController
{
  @FXML private TextField messageField;
  @FXML private TextArea commonChatArea;
  @FXML private ListView<String> activeUsersList;

  private CommonChatViewModel commonChatViewModel;
  private ViewHandler viewHandler;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler = vh;
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
    //activeUsersList.accessibleTextProperty().bindBidirectional(commonChatViewModel.activeUsersList());
    //activeUsersList.getItems().add("asd");
  }

  public void onSendButton(ActionEvent actionEvent)
  {
    commonChatViewModel.sendMessage();
    messageField.clear();
  }
}