package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table
@Entity(name = "pessoas")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private LocalDateTime dataNascimento;
    @Column(nullable = false, length = 45)
    private String telefone;
    @Column(nullable = false)
    private String email;

    @ManyToOne
    private TipoSanguineo tipoSanguineo;

    @OneToMany(mappedBy = "pessoa")
    private List<Responsavel> responsaveis;

    @OneToMany(mappedBy = "pessoa")
    private List<DadosSaude> dadosSaudes;

    @OneToMany(mappedBy = "pessoa")
    private List<DesafioEspecialidadeFeita> desafioEspecialidadeFeitas;

    @OneToMany(mappedBy = "pessoa")
    private List<DesafioInsigniaFeita> desafioInsigniaFeitas;

    @OneToMany(mappedBy = "pessoa")
    private List<DesafioDistintivoFeita> desafioDistintivoFeitas;

    @ManyToMany
    @JoinTable(
            name = "pessoas_acampamentos",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idAcampamento")
    )
    private List<Acampamento> acampamentos;
}