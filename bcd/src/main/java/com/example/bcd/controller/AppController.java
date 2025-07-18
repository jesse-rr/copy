package com.example.bcd.controller;

import com.example.bcd.model.Pessoa;
import com.example.bcd.service.PessoaManagementService;
import com.example.bcd.service.ProgressionManagementService;
import com.example.bcd.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class AppController {

    private final PessoaManagementService pessoaManagementService;
    private final ProgressionManagementService progressionManagementService;
    private final RelatorioService relatorioService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("pessoas", pessoaManagementService.findAllPessoas());
        model.addAttribute("especialidades", progressionManagementService.findAllEspecialidades());
        model.addAttribute("insignias", progressionManagementService.findAllInsignias());
        List<Pessoa> aptosCruzeiroDoSul = relatorioService.getJovensAptosCruzeiroDoSul();
        model.addAttribute("aptosCruzeiroDoSul", aptosCruzeiroDoSul);
        return "dashboard";
    }

    @GetMapping("/api/jovem/{id}")
    @ResponseBody
    public ResponseEntity<Pessoa> getJovemById(@PathVariable Long id) {
        return pessoaManagementService.findPessoaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}