package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.DadosAprovacaoAdocao;
import br.com.alura.adopet.api.dto.DadosReprovacaoAdocao;
import br.com.alura.adopet.api.dto.DadosSolicitacaoAdocao;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.service.AdocaoService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid DadosSolicitacaoAdocao dto) {
        try {
            this.adocaoService.solicitar(dto);
            return ResponseEntity.ok("Adoção solicitada com sucesso!");
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid DadosAprovacaoAdocao dto) {
    	this.adocaoService.aprovar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid DadosReprovacaoAdocao dto) {
    	this.adocaoService.reprovar(dto);
        return ResponseEntity.ok().build();
    }

}