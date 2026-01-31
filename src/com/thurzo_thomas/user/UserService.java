package com.thurzo_thomas.user;

import java.util.UUID;

public class UserService {

    public User getUserById(UUID id){
        for(User user : UserDao.getUsers()){
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
