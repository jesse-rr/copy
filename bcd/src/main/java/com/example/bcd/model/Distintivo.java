package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "distintivos")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Distintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistintivo;

    @Column(nullable = false)
    private String nome;
}