package com.guigu.spring5.test;

import com.guigu.spring5.entity.User;
import com.guigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestUser {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setUserId("0");
        user.setUsername("admin");
        user.setPassword("1234");

//crud operations
        //userService.addUsers(user);
        //userService.deleteUsers("1");
        //bookService.updateUsers(user);

        //int count= bookService.selectCounts();
        //System.out.println(bookService.selectCounts());

        //user = bookService.findOne("2");
        //System.out.println(user);

        List<User> allUser = userService.findAll();
        System.out.println(allUser);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"1", "minhao", "1111"};
        Object[] o2 = {"2", "tarek", "2222"};
        Object[] o3 = {"3", "zhanan", "3333"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        // userService.batchAdd(batchArgs);
    }

    //Lambda format
    @Test
    public void testGenericApplicationContext() {
        // 1.creat object of GenericApplicationContext
        GenericApplicationContext context = new GenericApplicationContext();
        // 2.use context's function to register the object
        context.refresh();
        context.registerBean("user1", User.class, () -> new User());
        // context.registerBean(User1.class,()-> new User1());
        // 3. get registered object in Spring
        User user = (User) context.getBean("user1");
        // User1 user = (User1)context.getBean("com.guigu.spring5.test.User1");
        System.out.println(user);
    }
}
