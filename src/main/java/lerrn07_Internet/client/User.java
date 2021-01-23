package lerrn07_Internet.client;

import java.io.Serializable;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 21:38
 * @Description: TODO
 */
public class User implements Serializable {


    private static final long serialVersionUID = 1590020726742801370L;
    private String username;
    private String password;

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
