package com.challenge.forohub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Topic> topics;
    @OneToMany(mappedBy = "author")
    private List<Answer> answers;
    @ManyToMany
    private List<Profile> profiles;
}
