package com.thurzo_thomas.user;

import java.util.UUID;

public class UserArrayDataAccessService implements UserDao{

    private static final User[] users;

    static {
        users = new User[]{
                new User(UUID.randomUUID(), "Thomas", "Action"),
                new User(UUID.randomUUID(),"John", "Smith"),
                new User(UUID.randomUUID(),"Peter", "Foo"),
                new User(UUID.randomUUID(),"James", "Bar"),
                new User(UUID.randomUUID(),"Susan", "Wheeler"),
        };
    }

    @Override
    public User[] getUsers(){
        return users;
    }

}
