package com.example.kunuz_clone.entity;

import com.example.kunuz_clone.enums.PostStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("posts"))
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String context;

    @Column(unique = true)
    private String token;

    private Integer viewCount;

    private LocalDateTime create_at;

    private LocalDateTime published_at;

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = ("user_id"), updatable = false, insertable = false)
    private User user;

    @Column(name = ("user_id"))
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = ("category_id"), updatable = false, insertable = false)
    private Category category;

    @Column(name = ("category_id"))
    private Integer categoryId;


    @ManyToOne
    @JoinColumn(name = "region_id", updatable = false, insertable = false)
    private Region region;

    @Column(name = "region_id")
    private Integer regionId;
}
