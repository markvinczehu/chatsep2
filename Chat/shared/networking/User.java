package Chat.shared.networking;

import java.io.Serializable;

public class User implements Serializable
{
    private String username;
    private String password;
    private String status;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        status = "Online";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus()
    {
        return status;
    }

    public String toUserList()
    {
        return username + " (" + status + ")";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Boolean status)
    {
        if(status)
            this.status = "Online";
        else
            this.status = "Busy";
    }
}
