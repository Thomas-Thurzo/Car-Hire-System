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
        saveUserToFile();
    }

    public static void saveUserToFile()  {
        String nl = System.lineSeparator();
        try {
            FileWriter userWriter = new FileWriter("src/com/thurzo_thomas/data/userData.txt");
            for (User user : users){
                userWriter.write(user.getFirstName() + " " + user.getLastName()
                + " " + user.getId() + nl);
            }
            userWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User[] getUsers() {
        File userData = new File("src/com/thurzo_thomas/data/userData.txt");



        return users;
    }
}
