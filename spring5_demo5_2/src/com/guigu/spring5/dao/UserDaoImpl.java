package com.guigu.spring5.dao;

import com.guigu.spring5.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    //IMPORT JDBC
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
        String sql = "insert into t_user values(?,?,?)";
        //Variable parameters, call methods are implemented, or directly input in Update
        Object[] args = {user.getUserId(), user.getUsername(), user.getPassword()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update t_user set username=?,ustatus=? where user_id=?";
        Object[] args = {user.getUsername(), user.getPassword(), user.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void deleteUser(String id) {
        String sql = "delete from t_user  where user_id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_user";
        int count = jdbcTemplate.queryForObject(sql, Integer.class); //第二个参数为返回类型
        return count;
    }

    //query object
    @Override
    public User findInfo(String id) {
        String sql = "select * from t_user where user_id=?";
        User book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return book;
    }

    //query set
    @Override
    public List<User> findAlls() {
        String sql = "select * from t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    //batch operations
    public void batchAdds(List<Object[]> batchArgs) {
        String sql = "insert into t_user values(?,?,?)";
        int[] list = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(list));
    }
}
