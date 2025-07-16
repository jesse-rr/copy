package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity(name = "desafios_distintivos_feitas")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class DesafioDistintivoFeita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesafioDistintivoFeita;

    @Column(nullable = false)
    private LocalDateTime dataInicio;
    @Column(nullable = false)
    private LocalDateTime dataFim;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Distintivo distintivo;
}