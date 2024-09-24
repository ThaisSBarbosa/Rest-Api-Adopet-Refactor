package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.DadosSolicitacaoAdocao;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@Component
public class ValidacaoTutorComLimiteDeAdocoes implements ValidacaoSolicitacaoAdocao {

	@Autowired
	private AdocaoRepository adocaoRepository;

	public void validar(DadosSolicitacaoAdocao dto) {
		Long qtdAdocoesTutor = adocaoRepository.countByTutorId(dto.idTutor());

		if (qtdAdocoesTutor == 5) {
			throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
		}
	}

}
