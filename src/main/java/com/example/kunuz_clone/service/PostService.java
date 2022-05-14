package com.example.kunuz_clone.service;

import com.example.kunuz_clone.entity.Category;
import com.example.kunuz_clone.entity.Post;
import com.example.kunuz_clone.entity.Region;
import com.example.kunuz_clone.entity.User;
import com.example.kunuz_clone.enums.PostStatus;
import com.example.kunuz_clone.exception.MyException;
import com.example.kunuz_clone.repository.PostRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    public PostService(PostRepository postRepository,
                       RegionService regionService,
                       CategoryService categoryService,
                       UserService userService) {
        this.postRepository = postRepository;
        this.regionService = regionService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    private final PostRepository postRepository;
    private final RegionService regionService;
    private final CategoryService categoryService;
    private final UserService userService;

    public Post create(Post p) {

        // TODO region id;
        Region region = regionService.check(p.getRegionId());

        // todo category id
        Category category = categoryService.check(p.getCategoryId());

        // TODO user id
        User user = userService.check(p.getUserId());
        p.setCreate_at(LocalDateTime.now());
        p.setToken(UUID.randomUUID().toString());
        p.setStatus(true);
        p.setPostStatus(PostStatus.CREATED);
        p.setViewCount(0);
        postRepository.save(p);
        return p;
    }

    public Post get(Integer id) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            throw new MyException("Post not found");
        }
        Post p = optional.get();
        postRepository.save(p);
        return optional.get();
    }

    public Post update(Integer id, Post post) {
        Post p = get(id);
        p.setCategory(post.getCategory());
        p.setCategoryId(post.getCategoryId());
        p.setContext(post.getContext());
        p.setRegion(p.getRegion());
        p.setCreate_at(LocalDateTime.now());
        p.setPublished_at(post.getPublished_at());
        postRepository.save(p);
        return p;
    }

    public boolean detretion(Integer id) {
        Post p = get(id);
        postRepository.delete(p);
        return true;
    }


   public List<Post> getBycategory(Integer category) {
        List<Post> posts = postRepository.getByCategory(category);
        if(posts.isEmpty()) {
            throw new MyException("there are no post in this category");
        }
        return posts;
   }

    public List<Post> getRegions(Integer region) {
        List<Post> posts = postRepository.getByRegion(region);
        if(posts.isEmpty()) {
            throw new MyException("there are no post in this region");
        }
        return posts;
    }

    public List<Post> findPostsWithSort(String id) {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, id));
    }

    public Page<Post> findPostLast(int offset, int pageSize, String id) {

        Page<Post> posts = postRepository.findAll(PageRequest.of(offset, pageSize)  .withSort(Sort.Direction.DESC, id));
        return posts;
    }

    public List<Post> getbytitle(String name) {
        return postRepository.findByTitle(name);
    }

    public int increament(Integer id) {

        return postRepository.setCount(id);
    }


}
