package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "dados_saude")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDadosSaude;

    @Column(nullable = false)
    private String tipoProblema;
    @Column(nullable = false)
    private String descricao;


    @ManyToOne
    private Pessoa pessoa;
}
