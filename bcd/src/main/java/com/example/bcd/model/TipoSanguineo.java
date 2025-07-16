package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity(name = "tipos_sanguineos")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoSanguineo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoSanguineo;

    @Column(nullable = false, length = 45)
    private String tipo;


    @OneToMany(mappedBy = "tipoSanguineo")
    private List<Pessoa> pessoas;
}
