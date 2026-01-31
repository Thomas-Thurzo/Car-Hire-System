package com.thurzo_thomas.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDao {
    private static final User[] users;

    static {
        users = new User[]{
                new User("Thomas", "Action"),
                new User("John", "Smith"),
                new User("Peter", "Foo"),
                new User("James", "Bar"),
                new User("Susan", "Wheeler"),
        };
    }

    public static User[] getUsers() {
        return users;
    }
}
