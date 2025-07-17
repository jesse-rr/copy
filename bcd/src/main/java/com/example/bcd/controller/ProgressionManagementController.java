package com.example.bcd.controller;

import com.example.bcd.model.AreaDeConhecimento;
import com.example.bcd.model.DesafioDistintivoFeita;
import com.example.bcd.model.DesafioEspecialidadeFeita;
import com.example.bcd.model.DesafioInsigniaFeita;
import com.example.bcd.model.Distintivo;
import com.example.bcd.model.Especialidade;
import com.example.bcd.model.Insignia;
import com.example.bcd.service.ProgressionManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProgressionManagementController {

    private final ProgressionManagementService progressionManagementService;

    // ------- Especialidade -------
    @GetMapping("/especialidades")
    public ResponseEntity<List<Especialidade>> getAllEspecialidades() {
        return ResponseEntity.ok(progressionManagementService.findAllEspecialidades());
    }

    @GetMapping("/especialidades/{id}")
    public ResponseEntity<Especialidade> getEspecialidadeById(@PathVariable Long id) {
        return progressionManagementService.findEspecialidadeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/especialidades")
    public ResponseEntity<Especialidade> createEspecialidade(@RequestBody Especialidade especialidade) {
        Especialidade savedEspecialidade = progressionManagementService.saveEspecialidade(especialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEspecialidade);
    }

    @PutMapping("/especialidades/{id}")
    public ResponseEntity<Especialidade> updateEspecialidade(@PathVariable Long id, @RequestBody Especialidade especialidade) {
        return progressionManagementService.findEspecialidadeById(id)
                .map(existingEspecialidade -> {
                    especialidade.setIdEspecialidade(id);
                    return ResponseEntity.ok(progressionManagementService.saveEspecialidade(especialidade));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/especialidades/{id}")
    public ResponseEntity<Void> deleteEspecialidade(@PathVariable Long id) {
        if (progressionManagementService.findEspecialidadeById(id).isPresent()) {
            progressionManagementService.deleteEspecialidadeById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- AreaDeConhecimento -------
    @GetMapping("/areas-de-conhecimento")
    public ResponseEntity<List<AreaDeConhecimento>> getAllAreasDeConhecimento() {
        return ResponseEntity.ok(progressionManagementService.findAllAreasDeConhecimento());
    }

    @GetMapping("/areas-de-conhecimento/{id}")
    public ResponseEntity<AreaDeConhecimento> getAreaDeConhecimentoById(@PathVariable Long id) {
        return progressionManagementService.findAreaDeConhecimentoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/areas-de-conhecimento")
    public ResponseEntity<AreaDeConhecimento> createAreaDeConhecimento(@RequestBody AreaDeConhecimento areaDeConhecimento) {
        AreaDeConhecimento savedAreaDeConhecimento = progressionManagementService.saveAreaDeConhecimento(areaDeConhecimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAreaDeConhecimento);
    }

    @PutMapping("/areas-de-conhecimento/{id}")
    public ResponseEntity<AreaDeConhecimento> updateAreaDeConhecimento(@PathVariable Long id, @RequestBody AreaDeConhecimento areaDeConhecimento) {
        return progressionManagementService.findAreaDeConhecimentoById(id)
                .map(existingAreaDeConhecimento -> {
                    areaDeConhecimento.setIdAreaDeConhecimento(id);
                    return ResponseEntity.ok(progressionManagementService.saveAreaDeConhecimento(areaDeConhecimento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/areas-de-conhecimento/{id}")
    public ResponseEntity<Void> deleteAreaDeConhecimento(@PathVariable Long id) {
        if (progressionManagementService.findAreaDeConhecimentoById(id).isPresent()) {
            progressionManagementService.deleteAreaDeConhecimentoById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- Insignia -------
    @GetMapping("/insignias")
    public ResponseEntity<List<Insignia>> getAllInsignias() {
        return ResponseEntity.ok(progressionManagementService.findAllInsignias());
    }

    @GetMapping("/insignias/{id}")
    public ResponseEntity<Insignia> getInsigniaById(@PathVariable Long id) {
        return progressionManagementService.findInsigniaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/insignias")
    public ResponseEntity<Insignia> createInsignia(@RequestBody Insignia insignia) {
        Insignia savedInsignia = progressionManagementService.saveInsignia(insignia);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInsignia);
    }

    @PutMapping("/insignias/{id}")
    public ResponseEntity<Insignia> updateInsignia(@PathVariable Long id, @RequestBody Insignia insignia) {
        return progressionManagementService.findInsigniaById(id)
                .map(existingInsignia -> {
                    insignia.setIdInsignia(id);
                    return ResponseEntity.ok(progressionManagementService.saveInsignia(insignia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/insignias/{id}")
    public ResponseEntity<Void> deleteInsignia(@PathVariable Long id) {
        if (progressionManagementService.findInsigniaById(id).isPresent()) {
            progressionManagementService.deleteInsigniaById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- Distintivo -------
    @GetMapping("/distintivos")
    public ResponseEntity<List<Distintivo>> getAllDistintivos() {
        return ResponseEntity.ok(progressionManagementService.findAllDistintivos());
    }

    @GetMapping("/distintivos/{id}")
    public ResponseEntity<Distintivo> getDistintivoById(@PathVariable Long id) {
        return progressionManagementService.findDistintivoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/distintivos")
    public ResponseEntity<Distintivo> createDistintivo(@RequestBody Distintivo distintivo) {
        Distintivo savedDistintivo = progressionManagementService.saveDistintivo(distintivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDistintivo);
    }

    @PutMapping("/distintivos/{id}")
    public ResponseEntity<Distintivo> updateDistintivo(@PathVariable Long id, @RequestBody Distintivo distintivo) {
        return progressionManagementService.findDistintivoById(id)
                .map(existingDistintivo -> {
                    distintivo.setIdDistintivo(id);
                    return ResponseEntity.ok(progressionManagementService.saveDistintivo(distintivo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/distintivos/{id}")
    public ResponseEntity<Void> deleteDistintivo(@PathVariable Long id) {
        if (progressionManagementService.findDistintivoById(id).isPresent()) {
            progressionManagementService.deleteDistintivoById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- DesafioEspecialidadeFeita -------
    @GetMapping("/desafios-especialidade-feita")
    public ResponseEntity<List<DesafioEspecialidadeFeita>> getAllDesafiosEspecialidadeFeita() {
        return ResponseEntity.ok(progressionManagementService.findAllDesafiosEspecialidadeFeita());
    }

    @GetMapping("/desafios-especialidade-feita/{id}")
    public ResponseEntity<DesafioEspecialidadeFeita> getDesafioEspecialidadeFeitaById(@PathVariable Long id) {
        return progressionManagementService.findDesafioEspecialidadeFeitaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/desafios-especialidade-feita")
    public ResponseEntity<DesafioEspecialidadeFeita> createDesafioEspecialidadeFeita(@RequestBody DesafioEspecialidadeFeita desafioEspecialidadeFeita) {
        DesafioEspecialidadeFeita savedDesafioEspecialidadeFeita = progressionManagementService.saveDesafioEspecialidadeFeita(desafioEspecialidadeFeita);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDesafioEspecialidadeFeita);
    }

    @PutMapping("/desafios-especialidade-feita/{id}")
    public ResponseEntity<DesafioEspecialidadeFeita> updateDesafioEspecialidadeFeita(@PathVariable Long id, @RequestBody DesafioEspecialidadeFeita desafioEspecialidadeFeita) {
        return progressionManagementService.findDesafioEspecialidadeFeitaById(id)
                .map(existingDesafioEspecialidadeFeita -> {
                    desafioEspecialidadeFeita.setIdDesafioEspecialidadeFeita(id);
                    return ResponseEntity.ok(progressionManagementService.saveDesafioEspecialidadeFeita(desafioEspecialidadeFeita));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/desafios-especialidade-feita/{id}")
    public ResponseEntity<Void> deleteDesafioEspecialidadeFeita(@PathVariable Long id) {
        if (progressionManagementService.findDesafioEspecialidadeFeitaById(id).isPresent()) {
            progressionManagementService.deleteDesafioEspecialidadeFeitaById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- DesafioInsigniaFeita -------
    @GetMapping("/desafios-insignia-feita")
    public ResponseEntity<List<DesafioInsigniaFeita>> getAllDesafiosInsigniaFeita() {
        return ResponseEntity.ok(progressionManagementService.findAllDesafiosInsigniaFeita());
    }

    @GetMapping("/desafios-insignia-feita/{id}")
    public ResponseEntity<DesafioInsigniaFeita> getDesafioInsigniaFeitaById(@PathVariable Long id) {
        return progressionManagementService.findDesafioInsigniaFeitaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/desafios-insignia-feita")
    public ResponseEntity<DesafioInsigniaFeita> createDesafioInsigniaFeita(@RequestBody DesafioInsigniaFeita desafioInsigniaFeita) {
        DesafioInsigniaFeita savedDesafioInsigniaFeita = progressionManagementService.saveDesafioInsigniaFeita(desafioInsigniaFeita);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDesafioInsigniaFeita);
    }

    @PutMapping("/desafios-insignia-feita/{id}")
    public ResponseEntity<DesafioInsigniaFeita> updateDesafioInsigniaFeita(@PathVariable Long id, @RequestBody DesafioInsigniaFeita desafioInsigniaFeita) {
        return progressionManagementService.findDesafioInsigniaFeitaById(id)
                .map(existingDesafioInsigniaFeita -> {
                    desafioInsigniaFeita.setIdDesafioInsigniaFeita(id);
                    return ResponseEntity.ok(progressionManagementService.saveDesafioInsigniaFeita(desafioInsigniaFeita));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/desafios-insignia-feita/{id}")
    public ResponseEntity<Void> deleteDesafioInsigniaFeita(@PathVariable Long id) {
        if (progressionManagementService.findDesafioInsigniaFeitaById(id).isPresent()) {
            progressionManagementService.deleteDesafioInsigniaFeitaById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ------- DesafioDistintivoFeita -------
    @GetMapping("/desafios-distintivo-feita")
    public ResponseEntity<List<DesafioDistintivoFeita>> getAllDesafiosDistintivoFeita() {
        return ResponseEntity.ok(progressionManagementService.findAllDesafiosDistintivoFeita());
    }

    @GetMapping("/desafios-distintivo-feita/{id}")
    public ResponseEntity<DesafioDistintivoFeita> getDesafioDistintivoFeitaById(@PathVariable Long id) {
        return progressionManagementService.findDesafioDistintivoFeitaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/desafios-distintivo-feita")
    public ResponseEntity<DesafioDistintivoFeita> createDesafioDistintivoFeita(@RequestBody DesafioDistintivoFeita desafioDistintivoFeita) {
        DesafioDistintivoFeita savedDesafioDistintivoFeita = progressionManagementService.saveDesafioDistintivoFeita(desafioDistintivoFeita);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDesafioDistintivoFeita);
    }

    @PutMapping("/desafios-distintivo-feita/{id}")
    public ResponseEntity<DesafioDistintivoFeita> updateDesafioDistintivoFeita(@PathVariable Long id, @RequestBody DesafioDistintivoFeita desafioDistintivoFeita) {
        return progressionManagementService.findDesafioDistintivoFeitaById(id)
                .map(existingDesafioDistintivoFeita -> {
                    desafioDistintivoFeita.setIdDesafioDistintivoFeita(id);
                    return ResponseEntity.ok(progressionManagementService.saveDesafioDistintivoFeita(desafioDistintivoFeita));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/desafios-distintivo-feita/{id}")
    public ResponseEntity<Void> deleteDesafioDistintivoFeita(@PathVariable Long id) {
        if (progressionManagementService.findDesafioDistintivoFeitaById(id).isPresent()) {
            progressionManagementService.deleteDesafioDistintivoFeitaById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
