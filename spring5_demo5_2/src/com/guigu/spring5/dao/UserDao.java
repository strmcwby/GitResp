package com.guigu.spring5.dao;

import com.guigu.spring5.entity.User;

import java.util.List;


public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(String id);

    int selectCount();

    User findInfo(String id);

    List<User> findAlls();

    void batchAdds(List<Object[]> batchArgs);
}
