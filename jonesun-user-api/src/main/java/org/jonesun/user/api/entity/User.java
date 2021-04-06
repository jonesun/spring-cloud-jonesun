package org.jonesun.user.api.entity;

import java.time.LocalDateTime;

/**
 * 用户实体
 *
 * @author jone.sun
 * 2021/4/1 16:33
 */
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private LocalDateTime createTime;

    public User() {
    }


    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.createTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

}
