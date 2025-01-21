package com.challenge.forohub.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private String creationDate;
    private String status;
    @ManyToOne
    private Course course;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "topic")
    private List<Answer> answers;
}
