package com.example.kunuz_clone.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = ("users"))

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private String password;

    private String contact;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("user_type_id"), insertable = false, updatable = false)
    private UserType userType;

    @Column(name = ("user_type_id"))
    private Integer userTypeId;
}
