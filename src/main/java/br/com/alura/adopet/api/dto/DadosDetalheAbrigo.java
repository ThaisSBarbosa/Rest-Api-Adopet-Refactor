package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Abrigo;
import jakarta.validation.constraints.NotBlank;

public record DadosDetalheAbrigo(Long id, @NotBlank String nome) {

    public DadosDetalheAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }

}
