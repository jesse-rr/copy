package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "especialidades")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidade;

    @Column(nullable = false)
    private String nome;


    @ManyToOne
    private AreaDeConhecimento areaDeConhecimento;
}
