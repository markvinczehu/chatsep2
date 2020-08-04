package Chat.shared.networking;

import Chat.shared.transferobjects.Message;

import java.sql.SQLException;

public interface MessageDAO {
    Message message (Message message, String username) throws SQLException;
}
