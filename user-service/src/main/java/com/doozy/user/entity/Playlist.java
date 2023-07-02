package com.doozy.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID playlistId;
    private String playlistName;

    @ManyToMany(targetEntity = Book.class)
    private List<Book> playlistBooks;
}
