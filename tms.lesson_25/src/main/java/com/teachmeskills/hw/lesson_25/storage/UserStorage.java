package com.teachmeskills.hw.lesson_25.storage;

import com.teachmeskills.hw.lesson_25.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    public static final Map<String, User> userDatabase = new HashMap<>();

    static {
        userDatabase.put("user1", new User("user1", "123", "user"));
        userDatabase.put("admin", new User("admin", "123", "admin"));
    }
}
