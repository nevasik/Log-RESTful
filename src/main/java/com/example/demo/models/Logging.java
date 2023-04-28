package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Logging")
public class Logging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
