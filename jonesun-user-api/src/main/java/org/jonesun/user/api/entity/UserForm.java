package org.jonesun.user.api.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户注册用表单对象
 *
 * @author jone.sun
 * 2021/3/18 10:20
 */
public class UserForm {

    @Size(min = 1,max = 10,message = "姓名长度必须为1到10")
    private String name;

    @Range(min = 1,max = 150,message = "年龄必须是必须是1到150")
    private Integer age;

    @NotBlank(message = "邮箱不能为空")
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

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
}
