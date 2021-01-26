package com.springexample.onetomany.relationshipexample.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    public Post(String title, String description, List<Comment> comments) {
        this.title = title;
        this.description = description;
        this.comments = comments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private List<Comment> comments;

}
