package com.example.kunuz_clone.service;

import com.example.kunuz_clone.entity.Category;
import com.example.kunuz_clone.exception.Exception;
import com.example.kunuz_clone.exception.MyException;
import com.example.kunuz_clone.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public Category get(Integer id) {
        return check(id);
    }

    public Category update(Category c, Integer id) {
        Category category = get(id);
        category.setId(id);
        category.setName(c.getName());
        categoryRepository.save(category);
        return category;
    }

    public boolean delete(Integer id) {
        Category category = get(id);
        categoryRepository.delete(category);
        return true;
    }

    public Category check(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);

        if(optional.isEmpty()) {
            throw new MyException("category not found");
        }

        return optional.get();
    }

}
