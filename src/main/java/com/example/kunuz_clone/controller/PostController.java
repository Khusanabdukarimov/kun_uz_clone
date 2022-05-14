package com.example.kunuz_clone.controller;

import com.example.kunuz_clone.entity.Post;
import com.example.kunuz_clone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Post post) {
        Post ans = postService.create(post);
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        Post ans = postService.get(id);
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/getByCategory/{category}")
    public ResponseEntity<?> getByCategory(@PathVariable("category") Integer  category) {
        List<Post> ans = postService.getBycategory(category);
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/getByRegion/{region}")
    public ResponseEntity<?> getByRegion(@PathVariable("region") Integer region) {
        List<Post> ans = postService.getRegions(region);
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/getByLastPost/{offset}/{page}/{field}")
    public ResponseEntity getLastPosts(@PathVariable("offset") Integer offset,
                                       @PathVariable("page") Integer page,
                                       @PathVariable("field") String field) {
        Page<Post> posts = postService.findPostLast(offset, page, field);
        return ResponseEntity.ok(posts);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Post post) {
        Post ans = postService.update(id, post);
        return ResponseEntity.ok(ans);
    }

    @PutMapping("/set/{num}")
    public ResponseEntity<?> setCoutn(@PathVariable("num") Integer id) {
         int ans = postService.increament(id);
        return ResponseEntity.ok(postService.get(id));
    }

    @GetMapping("/findBytitle/{title}")
    public ResponseEntity<?> getTitle(@PathVariable("title") String name) {
        List<Post> ans = postService.getbytitle(name);
        return ResponseEntity.ok(ans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean ans = postService.detretion(id);
        return ResponseEntity.ok(ans);
    }

}
