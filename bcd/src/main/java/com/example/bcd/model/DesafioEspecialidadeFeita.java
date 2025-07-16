package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity(name = "desafios_especialidades_feitas")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class DesafioEspecialidadeFeita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesafioEspecialidadeFeita;

    @Column(nullable = false)
    private LocalDateTime data;
    @Column(nullable = false)
    private String descricao;


    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Especialidade especialidade;

}
