package com.doozy.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    private String fName;
    private String lName;
    private String email;

    @OneToMany(targetEntity = Bookmarks.class)
    private List<Bookmarks> bookmarks;

    @OneToMany(targetEntity = Book.class)
    private List<Book> booksRead;

    @OneToMany(targetEntity = Book.class)
    private List<Book> booksLiked;

    @OneToMany
    private List<Playlist> playlistList;

}
