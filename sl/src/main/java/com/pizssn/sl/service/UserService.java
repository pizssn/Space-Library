package com.pizssn.sl.service;

import com.pizssn.sl.dao.UserDAO;
import com.pizssn.sl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = userDAO.findByUsername(username);
        return null!=user;
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }
}
