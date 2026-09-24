package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue
    private Long id;

    @GeneratedValue
    private String name;

    @GeneratedValue
    private String course_code;

    @GeneratedValue
    private String semester;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Classroom> authoredPullRequests;
}
