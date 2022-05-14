package com.example.kunuz_clone.service;

import com.example.kunuz_clone.entity.UserType;
import com.example.kunuz_clone.exception.MyException;
import com.example.kunuz_clone.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    public UserType create(UserType userType) {
        userType.setStatus(true);
        userType.setCreate_at(LocalDateTime.now());
        userTypeRepository.save(userType);
        return userType;
    }

    public UserType get(Integer id) {
        Optional<UserType> optional = userTypeRepository.findById(id);
        if(optional.isEmpty()) {
            throw new MyException("user type Not found");
        }
        return optional.get();
    }

    public UserType update(Integer id, UserType userType) {
        UserType old = get(id);
        old.setName(userType.getName());
        old.setUpdate_at(LocalDateTime.now());
        userTypeRepository.save(old);
        return old;
    }

    public boolean delete(Integer id) {
        UserType userType = get(id);
        userTypeRepository.delete(userType);
        return true;
    }
}
