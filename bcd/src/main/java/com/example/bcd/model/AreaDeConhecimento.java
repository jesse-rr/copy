package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity(name = "areas_de_conhecimentos")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaDeConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAreaDeConhecimento;

    @Column(nullable = false)
    private String nome;


    @OneToMany
    private List<Especialidade> especialidades;
}
