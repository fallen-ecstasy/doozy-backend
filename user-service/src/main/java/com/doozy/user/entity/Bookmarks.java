package com.doozy.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookmarks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid;
    private int page;
    @ManyToOne(targetEntity = Book.class)
    private int bookId;
    @ManyToOne(targetEntity = User.class)
    private String uid;
}
