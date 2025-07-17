package com.example.bcd.controller;

import com.example.bcd.model.Pessoa;
import com.example.bcd.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final RelatorioService relatorioService;

    @GetMapping("/jovem/{idPessoa}")
    public ResponseEntity<Pessoa> getDadosBiograficosJovem(@PathVariable Long idPessoa) {
        Pessoa pessoa = relatorioService.getDadosBiograficosJovem(idPessoa);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/jovens-com-especialidade")
    public ResponseEntity<List<Pessoa>> getJovensComEspecialidade(@RequestParam String nomeEspecialidade) {
        List<Pessoa> jovens = relatorioService.getJovensComEspecialidade(nomeEspecialidade);
        if (!jovens.isEmpty()) {
            return ResponseEntity.ok(jovens);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/especialidades-insignias-jovem/{idPessoa}")
    public ResponseEntity<String> getEspecialidadesEInsigniasDeJovem(@PathVariable Long idPessoa) {
        String report = relatorioService.getEspecialidadesEInsigniasDeJovem(idPessoa);
        if (!report.equals("Jovem não encontrado.")) {
            return ResponseEntity.ok(report);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/requisitos-cumpridos-especialidade/{idPessoa}")
    public ResponseEntity<String> getRequisitosCumpridosParaEspecialidade(
            @PathVariable Long idPessoa,
            @RequestParam String nomeEspecialidade) {
        String report = relatorioService.getRequisitosCumpridosParaEspecialidade(idPessoa, nomeEspecialidade);
        if (!report.equals("Jovem ou Especialidade não encontrada.")) {
            return ResponseEntity.ok(report);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/jovens-aptos-cruzeiro-do-sul")
    public ResponseEntity<List<Pessoa>> getJovensAptosCruzeiroDoSul() {
        List<Pessoa> jovens = relatorioService.getJovensAptosCruzeiroDoSul();
        if (!jovens.isEmpty()) {
            return ResponseEntity.ok(jovens);
        }
        return ResponseEntity.noContent().build();
    }
}
