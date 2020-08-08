package Chat.client.view.privatechat;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import Chat.client.view.privatechat.PrivatChatViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;

public class PrivateChatController implements ViewController {

    @FXML
    private TextArea privateChatTextArea;

    @FXML
    private TextField privateChatMessageField;

    private PrivatChatViewModel privateChatViewModel;
    private ViewHandler vh;

    @FXML
    void onExitButton(ActionEvent event) {
        vh.openCommonChat();
    }

    @FXML
    void onSendButton(ActionEvent event) {
        if(privateChatMessageField != null)
        {
            privateChatViewModel.sendMessage();
            privateChatMessageField.clear();
        }
    }



    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) throws RemoteException {
        this.vh = vh;
        privateChatViewModel = vmf.getPrivatChatViewModel();
        privateChatMessageField.textProperty().bindBidirectional(privateChatViewModel.messageField());
        privateChatTextArea.setEditable(false);
        privateChatViewModel.chatArea().addListener((obs, old, newValue) ->{
            if(!newValue.equals(""))
            {
                privateChatTextArea.appendText(newValue + "\n");
                privateChatViewModel.chatArea().setValue("");
            }
        });
    }
}
