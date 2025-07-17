package com.example.bcd.service;

import com.example.bcd.repository.DadosSaudeRepository;
import com.example.bcd.model.Acampamento;
import com.example.bcd.model.DadosSaude;
import com.example.bcd.model.Pessoa;
import com.example.bcd.model.Responsavel;
import com.example.bcd.model.TipoSanguineo;
import com.example.bcd.repository.AcampamentoRepository;
import com.example.bcd.repository.PessoaRepository;
import com.example.bcd.repository.ResponsavelRepository;
import com.example.bcd.repository.TipoSanguineoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaManagementService {

    private final PessoaRepository pessoaRepository;
    private final TipoSanguineoRepository tipoSanguineoRepository;
    private final ResponsavelRepository responsavelRepository;
    private final DadosSaudeRepository dadosSaudeRepository;
    private final AcampamentoRepository acampamentoRepository;

    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> findPessoaById(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> findAllPessoas() {
        return pessoaRepository.findAll();
    }

    public void deletePessoaById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public TipoSanguineo saveTipoSanguineo(TipoSanguineo tipoSanguineo) {
        return tipoSanguineoRepository.save(tipoSanguineo);
    }

    public Optional<TipoSanguineo> findTipoSanguineoById(Long id) {
        return tipoSanguineoRepository.findById(id);
    }

    public List<TipoSanguineo> findAllTiposSanguineos() {
        return tipoSanguineoRepository.findAll();
    }

    public void deleteTipoSanguineoById(Long id) {
        tipoSanguineoRepository.deleteById(id);
    }

    public Responsavel saveResponsavel(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public Optional<Responsavel> findResponsavelById(Long id) {
        return responsavelRepository.findById(id);
    }

    public List<Responsavel> findAllResponsaveis() {
        return responsavelRepository.findAll();
    }

    public void deleteResponsavelById(Long id) {
        responsavelRepository.deleteById(id);
    }

    public DadosSaude saveDadosSaude(DadosSaude dadosSaude) {
        return dadosSaudeRepository.save(dadosSaude);
    }

    public Optional<DadosSaude> findDadosSaudeById(Long id) {
        return dadosSaudeRepository.findById(id);
    }

    public List<DadosSaude> findAllDadosSaude() {
        return dadosSaudeRepository.findAll();
    }

    public void deleteDadosSaudeById(Long id) {
        dadosSaudeRepository.deleteById(id);
    }

    public Acampamento saveAcampamento(Acampamento acampamento) {
        return acampamentoRepository.save(acampamento);
    }

    public Optional<Acampamento> findAcampamentoById(Long id) {
        return acampamentoRepository.findById(id);
    }

    public List<Acampamento> findAllAcampamentos() {
        return acampamentoRepository.findAll();
    }

    public void deleteAcampamentoById(Long id) {
        acampamentoRepository.deleteById(id);
    }
}