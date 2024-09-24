package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.DadosSolicitacaoAdocao;

public interface ValidacaoSolicitacaoAdocao {

    void validar(DadosSolicitacaoAdocao dto);

}