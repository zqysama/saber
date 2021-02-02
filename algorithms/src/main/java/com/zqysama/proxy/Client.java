package com.zqysama.proxy;

import org.apache.catalina.User;

public class Client {
    public static void main(String[] args) {
        LogHandler logHandler = new LogHandler();
        UserManager userManager = (UserManager) logHandler.newProxyInstance(new UserManagerImpl());
        userManager.findUser("zhangsan");
    }
}
