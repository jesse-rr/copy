package com.example.bcd.service;

import com.example.bcd.model.Especialidade;
import com.example.bcd.model.Insignia;
import com.example.bcd.model.Pessoa;
import com.example.bcd.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final PessoaRepository pessoaRepository;

    public Pessoa getDadosBiograficosJovem(Long idPessoa) {
        return pessoaRepository.findById(idPessoa).orElse(null);
    }

    public List<Pessoa> getJovensComEspecialidade(String nomeEspecialidade) {
        return pessoaRepository.findAll().stream()
                .filter(p -> p.getDesafioEspecialidadeFeitas().stream()
                        .anyMatch(def -> def.getEspecialidade().getNome().equalsIgnoreCase(nomeEspecialidade)))
                .collect(Collectors.toList());
    }

    public String getEspecialidadesEInsigniasDeJovem(Long idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElse(null);
        if (pessoa != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Especialidades de ").append(pessoa.getNome()).append(":\n");
            pessoa.getDesafioEspecialidadeFeitas().forEach(def ->
                    sb.append("- ").append(def.getEspecialidade().getNome()).append(" (Descrição: ").append(def.getDescricao()).append(")\n")
            );

            sb.append("\nInsígnias de Interesse Especial de ").append(pessoa.getNome()).append(":\n");
            pessoa.getDesafioInsigniaFeitas().forEach(dif ->
                    sb.append("- ").append(dif.getInsignia().getNome()).append("\n")
            );
            return sb.toString();
        } else {
            return "Jovem não encontrado.";
        }
    }

    public String getRequisitosCumpridosParaEspecialidade(Long idPessoa, String nomeEspecialidade) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElse(null);
        if (pessoa != null) {
            return pessoa.getDesafioEspecialidadeFeitas().stream()
                    .filter(def -> def.getEspecialidade().getNome().equalsIgnoreCase(nomeEspecialidade))
                    .map(def -> "Descrição da Conquista: " + def.getDescricao())
                    .collect(Collectors.joining("\n"));
        }
        return "Jovem ou Especialidade não encontrada.";
    }

    public List<Pessoa> getJovensAptosCruzeiroDoSul() {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> {
                    boolean hasLoboCacador = pessoa.getDesafioDistintivoFeitas().stream()
                            .anyMatch(ddf -> ddf.getDistintivo().getNome().equalsIgnoreCase("Lobo Caçador") && ddf.getDataFim() != null);

                    boolean hasAtLeastOneInsignia = pessoa.getDesafioInsigniaFeitas() != null && !pessoa.getDesafioInsigniaFeitas().isEmpty();

                    long distinctAreasCount = pessoa.getDesafioEspecialidadeFeitas().stream()
                            .map(def -> def.getEspecialidade().getAreaDeConhecimento().getNome())
                            .distinct()
                            .count();

                    long specialtiesCount = pessoa.getDesafioEspecialidadeFeitas().size();

                    return hasLoboCacador && hasAtLeastOneInsignia && specialtiesCount >= 5 && distinctAreasCount >= 3;
                })
                .collect(Collectors.toList());
    }
}