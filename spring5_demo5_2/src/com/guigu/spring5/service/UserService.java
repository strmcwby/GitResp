package com.guigu.spring5.service;

import com.guigu.spring5.dao.UserDao;
import com.guigu.spring5.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//Transactions Management
@Transactional(readOnly = false, timeout = -1, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class UserService {
    @Autowired
    private UserDao userDao;

    //Add function
    public void addUsers(User user) {
        userDao.addUser(user);
    }

    public void updateUsers(User user) {
        userDao.updateUser(user);
    }

    public void deleteUsers(String id) {
        userDao.deleteUser(id);
    }

    public int selectCounts() {
        return userDao.selectCount();
    }

    //return object
    public User findOne(String id) {
        return userDao.findInfo(id);
    }

    //query list
    public List<User> findAll() {
        return userDao.findAlls();
    }

    //batch operation
    public void batchAdd(List<Object[]> batchArgs) {
        userDao.batchAdds(batchArgs);
    }
}
