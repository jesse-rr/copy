package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "responsaveis")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsavel;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 45)
    private String telefone;
    @Column(nullable = false)
    private String email;


    @ManyToOne
    private Pessoa pessoa;
}
