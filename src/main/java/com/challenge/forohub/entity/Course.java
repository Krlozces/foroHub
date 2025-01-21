package com.challenge.forohub.entity;

import jakarta.persistence.*;

import java.util.List;

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    @OneToMany (mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topic> topics;
}
