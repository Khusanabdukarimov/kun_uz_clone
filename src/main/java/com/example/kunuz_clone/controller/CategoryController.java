package com.example.kunuz_clone.controller;

import com.example.kunuz_clone.entity.Category;
import com.example.kunuz_clone.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
   @Autowired
   private CategoryService categoryService;

   @PostMapping

    public ResponseEntity<?> create(@RequestBody Category category) {
       Category ans = categoryService.create(category);

       return ResponseEntity.ok(ans);
   }

   @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") Integer id) {
       Category category = categoryService.get(id);

       return ResponseEntity.ok(category);
   }

   @PutMapping("/{id}")

   public ResponseEntity<?> put(@PathVariable("id") Integer id, @RequestBody Category category) {
      Category category1 = categoryService.update(category, id);
      return ResponseEntity.ok(category1);
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<?> detrition(@PathVariable Integer id) {
      boolean ans = categoryService.delete(id);
      return ResponseEntity.ok(ans);
   }
}
