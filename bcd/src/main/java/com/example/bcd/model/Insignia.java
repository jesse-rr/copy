package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "insignias")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Insignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInsignia;

    @Column(nullable = false)
    private String nome;
}