package org.jonesun.user.server.service;

import org.jonesun.user.server.dao.UserDao;
import org.jonesun.user.server.entity.User;
import org.jonesun.user.server.entity.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 用户服务
 *
 * @author jone.sun
 * 2021/3/18 9:48
 */
@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean insert(UserForm userForm) {
        User user = new User(userForm.getName(), userForm.getAge(), userForm.getEmail());
        return userDao.insert(user) > 0;
    }

    public boolean deleteById(Serializable id) {
        return false;
    }

    public boolean updateById(User user) {
        return false;
    }

    public User selectById(Serializable id) {
        return null;
    }

    public List<User> selectList() {
        return userDao.selectList();
    }

}
