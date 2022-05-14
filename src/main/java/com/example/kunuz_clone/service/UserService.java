package com.example.kunuz_clone.service;

import com.example.kunuz_clone.entity.User;
import com.example.kunuz_clone.exception.MyException;
import com.example.kunuz_clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        user.setStatus(true);
        userRepository.save(user);
        return user;
    }

    public User get(Integer id) {
      return check(id);
    }


    public User update(Integer id, User u) {
        User user = get(id);
        user.setUserTypeId(u.getUserTypeId());
        user.setUserType(u.getUserType());
        user.setStatus(u.getStatus());
        user.setContact(u.getContact());
        user.setSurname(u.getSurname());
        user.setName(u.getName());
        user.setUserType(u.getUserType());
        user.setPassword(u.getPassword());
        userRepository.save(user);
        return user;
    }

    public boolean delete(Integer id) {
        User u = get(id);
        userRepository.delete(u);
        return true;
    }

    public User check(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isEmpty()) {
            throw new MyException("user not found");
        }
        return optional.get();
    }
}
