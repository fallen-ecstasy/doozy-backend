package com.doozy.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bid;
    private String bookName;
    private String authorName;
    private int pageCount;
    private double runningTime;
}
