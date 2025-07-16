package com.example.bcd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity(name = "desafios_insignias_feitas")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class DesafioInsigniaFeita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesafioInsigniaFeita;

    @Column(nullable = false)
    private LocalDateTime data;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Insignia insignia;
}