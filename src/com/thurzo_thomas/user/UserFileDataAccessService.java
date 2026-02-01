package com.thurzo_thomas.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class UserFileDataAccessService implements UserDao{

    private final File userDataFile = new File("src/com/thurzo_thomas/data/userData.txt");

    @Override
    public User[] getUsers() {
        User[] users = new User[4];
        try(Scanner scanner = new Scanner(userDataFile)) {
            int counter = 0;
            while (scanner.hasNext()){
                String[] split = scanner.nextLine().split(",");
                users[counter] = new User(UUID.fromString(split[0]), split[1], split[2]);
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
}
