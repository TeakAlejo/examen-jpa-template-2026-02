package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commits")
public class Commit {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "commit_hash", nullable = false, unique = true)
    private String commitHash;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String lines_added;

    @Column(nullable = false)
    private String lines_deleted;

    @Column(nullable = false)
    private Timestamp commit_date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repository_id", nullable = false)
    private Repository repository;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User users;
}
