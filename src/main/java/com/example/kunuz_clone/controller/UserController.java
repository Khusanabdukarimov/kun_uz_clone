package com.example.kunuz_clone.controller;

import com.example.kunuz_clone.entity.User;
import com.example.kunuz_clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        User result = userService.create(user);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")

    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        User ans = userService.get(id);
        return ResponseEntity.ok(ans);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody User u) {
        User ans = userService.update(id, u);
        return ResponseEntity.ok(ans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean is = userService.delete(id);
        return ResponseEntity.ok(is);
    }

}
