package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity(name = "acampamentos")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acampamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcampamento;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime data;
}