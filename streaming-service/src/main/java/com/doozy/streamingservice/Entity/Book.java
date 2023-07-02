package com.doozy.streamingservice.Entity;

import jakarta.persistence.*;

import java.util.UUID;

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bid;
    private String bookName;
    private String authorName;
    private int pageCount;
    private double runningTime;
    @OneToOne(targetEntity = Audiobook.class)
    private Audiobook audiobook;
}
