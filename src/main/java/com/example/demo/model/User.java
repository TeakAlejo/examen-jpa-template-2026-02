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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String role;

    @Column(nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Classroom> ownedRepositories;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<PullRequest> taughtRepositories;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<PullRequest> authoredPullRequests;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<PullRequest> reviewedPullRequests;

    @JsonIgnore
    @OneToMany(mappedBy = "commits", cascade = CascadeType.ALL)
    private List<Commit> commits;

}
