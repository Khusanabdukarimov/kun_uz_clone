package com.example.kunuz_clone.repository;

import com.example.kunuz_clone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p from Post p Where p.category.id = :category")
    List<Post> getByCategory(@Param("category") Integer id);

    @Query("select p from Post p where p.region.id = :region")
    List<Post> getByRegion(@Param("region") Integer region);

    List<Post> findByTitle(String name);

    @Transactional
    @Modifying
    @Query("update Post set viewCount = viewCount + 1 where id = :id")
    int setCount(@Param("id") Integer id);


}
