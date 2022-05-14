package com.example.kunuz_clone.controller;

import com.example.kunuz_clone.entity.UserType;
import com.example.kunuz_clone.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userType")
public class UserTypeController {
   @Autowired
   private UserTypeService userTypeService;

   @PostMapping
    public ResponseEntity<?> create(@RequestBody UserType userType) {
       UserType ans = userTypeService.create(userType);
       return ResponseEntity.ok(ans);
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> get(@PathVariable("id") Integer id) {
       UserType ans = userTypeService.get(id);
       return ResponseEntity.ok(ans);
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UserType userType) {
       UserType ans = userTypeService.update(id, userType);
       return ResponseEntity.ok(ans);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
       boolean ans = userTypeService.delete(id);
       return ResponseEntity.ok(ans);
   }
}
