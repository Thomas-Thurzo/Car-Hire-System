package com.thurzo_thomas.user;

import java.util.UUID;

public class UserService {

    UserDao userDao = new UserDao();

    public User getUserById(UUID id){
        for(User user : userDao.getUsers()){
            if(user.getUserId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public boolean isValidUUID(String id) {
        if (id == null) {
            return false;
        }

        try {
            UUID.fromString(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
