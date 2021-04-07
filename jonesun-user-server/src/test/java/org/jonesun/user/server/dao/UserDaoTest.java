package org.jonesun.user.server.dao;

import org.jonesun.user.server.entity.User;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jone.sun
 * 2021/4/1 16:51
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("用户Dao层测试")
@SpringBootTest
class UserDaoTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    UserDao userDao;

    @Autowired
    public UserDaoTest(UserDao userDao){
        this.userDao = userDao;
    }

    //    @Transactional
    @Order(1)
    @DisplayName("增加")
    @Test
    void insert() {
        User user = new User("Jone Sun", 30, "sunjoner7@gmail.com");
        int result = userDao.insert(user);
        assertNotNull(user.getId(), "用户插入失败");
        assertTrue(result > 0, "用户插入失败");
        log.debug(user.toString());
    }

    @Order(2)
    @DisplayName("删除")
    @Test
    void deleteById() {
        int result = userDao.deleteById(5);
        assertTrue(result > 0, "用户删除失败");
    }

    @Order(3)
    @DisplayName("更新")
    @Test
    void updateById() {
        User user = userDao.selectById(1);
        user.setAge(21);
        int result = userDao.updateById(user);
        assertTrue(result > 0, "用户更新失败");
        log.debug(user.toString());
    }

    @Order(4)
    @DisplayName("单个查询")
    @Test
    void selectById() {
        User user = userDao.selectById(1);
        assertEquals(user.getName(), "Jone", "用户名错误");
        log.debug(user.toString());
    }

    @Order(5)
    @DisplayName("列表查询")
    @Test
    void selectList() {
        List<User> list = userDao.selectList();
        assertFalse(list.isEmpty(), "列表为空");
        log.debug(list.toString());
    }
}