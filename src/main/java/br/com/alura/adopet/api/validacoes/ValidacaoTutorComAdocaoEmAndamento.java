package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.DadosSolicitacaoAdocao;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao{

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(DadosSolicitacaoAdocao dto) {
		boolean tutorTemAdocaoEmAndamento = adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(),
				StatusAdocao.AGUARDANDO_AVALIACAO);

		if (tutorTemAdocaoEmAndamento) {
			throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
		}
    }

}
