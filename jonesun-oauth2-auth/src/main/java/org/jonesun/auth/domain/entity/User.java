package org.jonesun.auth.domain.entity;


import java.util.List;

/**
 * @author jone.sun
 * 2021/4/12 13:03
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;

    public static User.UserBuilder builder() {
        return new User.UserBuilder();
    }

    public User.UserBuilder toBuilder() {
        return (new User.UserBuilder()).id(this.id).username(this.username).password(this.password).status(this.status).roles(this.roles);
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getStatus() {
        return this.status;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", status=" + this.getStatus() + ", roles=" + this.getRoles() + ")";
    }

    public User(Long id, String username, String password, Integer status, List<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public User() {
    }

    public static class UserBuilder {
        private Long id;
        private String username;
        private String password;
        private Integer status;
        private List<String> roles;

        UserBuilder() {
        }

        public User.UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public User.UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public User.UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User.UserBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public User.UserBuilder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            return new User(this.id, this.username, this.password, this.status, this.roles);
        }

        @Override
        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", username=" + this.username + ", password=" + this.password + ", status=" + this.status + ", roles=" + this.roles + ")";
        }
    }

}
