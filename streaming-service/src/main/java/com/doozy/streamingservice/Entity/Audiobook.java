package com.doozy.streamingservice.Entity;

import jakarta.persistence.*;

import java.util.UUID;

public class Audiobook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID abid;
    private String audioPath;
    private String audioName;

    @OneToOne(targetEntity = Book.class)
    private Book book;
}
