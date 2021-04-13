package org.jonesun.demoapp;

import java.io.Serializable;

/**
 * @author jone.sun
 * @date 2020-12-25 11:45
 */
public class LoginUser implements Serializable {
    private String username;
    private String password;

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
