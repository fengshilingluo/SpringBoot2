package com.baizhi.test;

import com.baizhi.entity.User;
import org.junit.Test;

public class Testlombok {
    @Test
    public void test1() {
        User user = new User();
        User user1 = new User("1", "小李", "123", 20);
        System.out.println(user1);
    }
}
