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
  @FXML private ListView activeUsersList;

  private CommonChatViewModel commonChatViewModel;
  private ViewHandler viewHandler;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler = vh;
    commonChatViewModel = vmf.getCommonChatViewModel();
    messageField.textProperty().bindBidirectional(commonChatViewModel.messageField());
    commonChatArea.textProperty().bindBidirectional(commonChatViewModel.chatArea());
    activeUsersList.accessibleTextProperty().bindBidirectional(commonChatViewModel.activeUsersList());
  }

  public void onSendButton(ActionEvent actionEvent)
  {
    Message message = new Message("username", messageField.getText());
    commonChatViewModel.sendMessage(message);
  }
}