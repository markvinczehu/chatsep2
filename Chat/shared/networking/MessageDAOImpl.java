package Chat.shared.networking;

import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.User;

import java.sql.*;
import java.util.Date;

public class MessageDAOImpl implements MessageDAO {

    private static MessageDAOImpl instance;
    private Date date;
    private User username;

    private MessageDAOImpl() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    private java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql//localhost:5432/user_info?currentSchema", "postgres", "293150");
    }

    public static synchronized MessageDAOImpl getInstance() throws SQLException {
        if(instance == null) {
            instance = new MessageDAOImpl();
        }
        return instance;
    }

    @Override
    public Message message(Message message, String username) throws SQLException {

        Timestamp ts = new Timestamp(date.getTime());
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO privateUserMessage(fromUser, toUser, body, createDate) VALUES (?, ?, ?, ?);");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, message.getMsg());
                preparedStatement.setTimestamp(4, ts);
                preparedStatement.executeUpdate();
                return new Message(message.getMsg(), username);
        }
    }
}
