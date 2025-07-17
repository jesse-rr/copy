package com.example.bcd.controller;

import com.example.bcd.model.Acampamento;
import com.example.bcd.model.DadosSaude;
import com.example.bcd.model.Pessoa;
import com.example.bcd.model.Responsavel;
import com.example.bcd.model.TipoSanguineo;
import com.example.bcd.service.PessoaManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PessoaManagementController {

    private final PessoaManagementService pessoaManagementService;

    @GetMapping("/pessoas")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        return ResponseEntity.ok(pessoaManagementService.findAllPessoas());
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        return pessoaManagementService.findPessoaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/pessoas")
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        Pessoa savedPessoa = pessoaManagementService.savePessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPessoa);
    }

    @PutMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaManagementService.findPessoaById(id)
                .map(existingPessoa -> {
                    pessoa.setIdPessoa(id);
                    return ResponseEntity.ok(pessoaManagementService.savePessoa(pessoa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        if (pessoaManagementService.findPessoaById(id).isPresent()) {
            pessoaManagementService.deletePessoaById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- TipoSanguineo -------
    @GetMapping("/tipos-sanguineos")
    public ResponseEntity<List<TipoSanguineo>> getAllTiposSanguineos() {
        return ResponseEntity.ok(pessoaManagementService.findAllTiposSanguineos());
    }

    @GetMapping("/tipos-sanguineos/{id}")
    public ResponseEntity<TipoSanguineo> getTipoSanguineoById(@PathVariable Long id) {
        return pessoaManagementService.findTipoSanguineoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tipos-sanguineos")
    public ResponseEntity<TipoSanguineo> createTipoSanguineo(@RequestBody TipoSanguineo tipoSanguineo) {
        TipoSanguineo savedTipoSanguineo = pessoaManagementService.saveTipoSanguineo(tipoSanguineo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoSanguineo);
    }

    @PutMapping("/tipos-sanguineos/{id}")
    public ResponseEntity<TipoSanguineo> updateTipoSanguineo(@PathVariable Long id, @RequestBody TipoSanguineo tipoSanguineo) {
        return pessoaManagementService.findTipoSanguineoById(id)
                .map(existingTipoSanguineo -> {
                    tipoSanguineo.setIdTipoSanguineo(id);
                    return ResponseEntity.ok(pessoaManagementService.saveTipoSanguineo(tipoSanguineo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/tipos-sanguineos/{id}")
    public ResponseEntity<Void> deleteTipoSanguineo(@PathVariable Long id) {
        if (pessoaManagementService.findTipoSanguineoById(id).isPresent()) {
            pessoaManagementService.deleteTipoSanguineoById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- Responsavel -------
    @GetMapping("/responsaveis")
    public ResponseEntity<List<Responsavel>> getAllResponsaveis() {
        return ResponseEntity.ok(pessoaManagementService.findAllResponsaveis());
    }

    @GetMapping("/responsaveis/{id}")
    public ResponseEntity<Responsavel> getResponsavelById(@PathVariable Long id) {
        return pessoaManagementService.findResponsavelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/responsaveis")
    public ResponseEntity<Responsavel> createResponsavel(@RequestBody Responsavel responsavel) {
        Responsavel savedResponsavel = pessoaManagementService.saveResponsavel(responsavel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResponsavel);
    }

    @PutMapping("/responsaveis/{id}")
    public ResponseEntity<Responsavel> updateResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        return pessoaManagementService.findResponsavelById(id)
                .map(existingResponsavel -> {
                    responsavel.setIdResponsavel(id);
                    return ResponseEntity.ok(pessoaManagementService.saveResponsavel(responsavel));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/responsaveis/{id}")
    public ResponseEntity<Void> deleteResponsavel(@PathVariable Long id) {
        if (pessoaManagementService.findResponsavelById(id).isPresent()) {
            pessoaManagementService.deleteResponsavelById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- DadosSaude -------
    @GetMapping("/dados-saude")
    public ResponseEntity<List<DadosSaude>> getAllDadosSaude() {
        return ResponseEntity.ok(pessoaManagementService.findAllDadosSaude());
    }

    @GetMapping("/dados-saude/{id}")
    public ResponseEntity<DadosSaude> getDadosSaudeById(@PathVariable Long id) {
        return pessoaManagementService.findDadosSaudeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/dados-saude")
    public ResponseEntity<DadosSaude> createDadosSaude(@RequestBody DadosSaude dadosSaude) {
        DadosSaude savedDadosSaude = pessoaManagementService.saveDadosSaude(dadosSaude);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDadosSaude);
    }

    @PutMapping("/dados-saude/{id}")
    public ResponseEntity<DadosSaude> updateDadosSaude(@PathVariable Long id, @RequestBody DadosSaude dadosSaude) {
        return pessoaManagementService.findDadosSaudeById(id)
                .map(existingDadosSaude -> {
                    dadosSaude.setIdDadosSaude(id);
                    return ResponseEntity.ok(pessoaManagementService.saveDadosSaude(dadosSaude));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/dados-saude/{id}")
    public ResponseEntity<Void> deleteDadosSaude(@PathVariable Long id) {
        if (pessoaManagementService.findDadosSaudeById(id).isPresent()) {
            pessoaManagementService.deleteDadosSaudeById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- Acampamento -------
    @GetMapping("/acampamentos")
    public ResponseEntity<List<Acampamento>> getAllAcampamentos() {
        return ResponseEntity.ok(pessoaManagementService.findAllAcampamentos());
    }

    @GetMapping("/acampamentos/{id}")
    public ResponseEntity<Acampamento> getAcampamentoById(@PathVariable Long id) {
        return pessoaManagementService.findAcampamentoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/acampamentos")
    public ResponseEntity<Acampamento> createAcampamento(@RequestBody Acampamento acampamento) {
        Acampamento savedAcampamento = pessoaManagementService.saveAcampamento(acampamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAcampamento);
    }

    @PutMapping("/acampamentos/{id}")
    public ResponseEntity<Acampamento> updateAcampamento(@PathVariable Long id, @RequestBody Acampamento acampamento) {
        return pessoaManagementService.findAcampamentoById(id)
                .map(existingAcampamento -> {
                    acampamento.setIdAcampamento(id);
                    return ResponseEntity.ok(pessoaManagementService.saveAcampamento(acampamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/acampamentos/{id}")
    public ResponseEntity<Void> deleteAcampamento(@PathVariable Long id) {
        if (pessoaManagementService.findAcampamentoById(id).isPresent()) {
            pessoaManagementService.deleteAcampamentoById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
