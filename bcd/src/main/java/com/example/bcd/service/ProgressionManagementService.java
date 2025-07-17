package com.example.bcd.service;

import com.example.bcd.model.AreaDeConhecimento;
import com.example.bcd.model.DesafioDistintivoFeita;
import com.example.bcd.model.DesafioEspecialidadeFeita;
import com.example.bcd.model.DesafioInsigniaFeita;
import com.example.bcd.model.Distintivo;
import com.example.bcd.model.Especialidade;
import com.example.bcd.model.Insignia;
import com.example.bcd.repository.AreaDeConhecimentoRepository;
import com.example.bcd.repository.DesafioDistintivoFeitaRepository;
import com.example.bcd.repository.DesafioEspecialidadeFeitaRepository;
import com.example.bcd.repository.DesafioInsigniaFeitaRepository;
import com.example.bcd.repository.DistintivoRepository;
import com.example.bcd.repository.EspecialidadeRepository;
import com.example.bcd.repository.InsigniaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgressionManagementService {

    private final EspecialidadeRepository especialidadeRepository;
    private final AreaDeConhecimentoRepository areaDeConhecimentoRepository;
    private final InsigniaRepository insigniaRepository;
    private final DistintivoRepository distintivoRepository;
    private final DesafioEspecialidadeFeitaRepository desafioEspecialidadeFeitaRepository;
    private final DesafioInsigniaFeitaRepository desafioInsigniaFeitaRepository;
    private final DesafioDistintivoFeitaRepository desafioDistintivoFeitaRepository;

    public Especialidade saveEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public Optional<Especialidade> findEspecialidadeById(Long id) {
        return especialidadeRepository.findById(id);
    }

    public List<Especialidade> findAllEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public void deleteEspecialidadeById(Long id) {
        especialidadeRepository.deleteById(id);
    }

    public AreaDeConhecimento saveAreaDeConhecimento(AreaDeConhecimento areaDeConhecimento) {
        return areaDeConhecimentoRepository.save(areaDeConhecimento);
    }

    public Optional<AreaDeConhecimento> findAreaDeConhecimentoById(Long id) {
        return areaDeConhecimentoRepository.findById(id);
    }

    public List<AreaDeConhecimento> findAllAreasDeConhecimento() {
        return areaDeConhecimentoRepository.findAll();
    }

    public void deleteAreaDeConhecimentoById(Long id) {
        areaDeConhecimentoRepository.deleteById(id);
    }

    public Insignia saveInsignia(Insignia insignia) {
        return insigniaRepository.save(insignia);
    }

    public Optional<Insignia> findInsigniaById(Long id) {
        return insigniaRepository.findById(id);
    }

    public List<Insignia> findAllInsignias() {
        return insigniaRepository.findAll();
    }

    public void deleteInsigniaById(Long id) {
        insigniaRepository.deleteById(id);
    }

    public Distintivo saveDistintivo(Distintivo distintivo) {
        return distintivoRepository.save(distintivo);
    }

    public Optional<Distintivo> findDistintivoById(Long id) {
        return distintivoRepository.findById(id);
    }

    public List<Distintivo> findAllDistintivos() {
        return distintivoRepository.findAll();
    }

    public void deleteDistintivoById(Long id) {
        distintivoRepository.deleteById(id);
    }

    public DesafioEspecialidadeFeita saveDesafioEspecialidadeFeita(DesafioEspecialidadeFeita desafioEspecialidadeFeita) {
        return desafioEspecialidadeFeitaRepository.save(desafioEspecialidadeFeita);
    }

    public Optional<DesafioEspecialidadeFeita> findDesafioEspecialidadeFeitaById(Long id) {
        return desafioEspecialidadeFeitaRepository.findById(id);
    }

    public List<DesafioEspecialidadeFeita> findAllDesafiosEspecialidadeFeita() {
        return desafioEspecialidadeFeitaRepository.findAll();
    }

    public void deleteDesafioEspecialidadeFeitaById(Long id) {
        desafioEspecialidadeFeitaRepository.deleteById(id);
    }

    public DesafioInsigniaFeita saveDesafioInsigniaFeita(DesafioInsigniaFeita desafioInsigniaFeita) {
        return desafioInsigniaFeitaRepository.save(desafioInsigniaFeita);
    }

    public Optional<DesafioInsigniaFeita> findDesafioInsigniaFeitaById(Long id) {
        return desafioInsigniaFeitaRepository.findById(id);
    }

    public List<DesafioInsigniaFeita> findAllDesafiosInsigniaFeita() {
        return desafioInsigniaFeitaRepository.findAll();
    }

    public void deleteDesafioInsigniaFeitaById(Long id) {
        desafioInsigniaFeitaRepository.deleteById(id);
    }

    public DesafioDistintivoFeita saveDesafioDistintivoFeita(DesafioDistintivoFeita desafioDistintivoFeita) {
        return desafioDistintivoFeitaRepository.save(desafioDistintivoFeita);
    }

    public Optional<DesafioDistintivoFeita> findDesafioDistintivoFeitaById(Long id) {
        return desafioDistintivoFeitaRepository.findById(id);
    }

    public List<DesafioDistintivoFeita> findAllDesafiosDistintivoFeita() {
        return desafioDistintivoFeitaRepository.findAll();
    }

    public void deleteDesafioDistintivoFeitaById(Long id) {
        desafioDistintivoFeitaRepository.deleteById(id);
    }
}