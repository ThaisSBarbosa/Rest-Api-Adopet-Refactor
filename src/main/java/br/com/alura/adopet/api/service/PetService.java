package br.com.alura.adopet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.api.dto.DadosCadastroPet;
import br.com.alura.adopet.api.dto.DadosDetalhesPet;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;

@Service
public class PetService {

 @Autowired
 private PetRepository repository;

 public List<DadosDetalhesPet> buscarPetsDisponiveis() {
     return repository
             .findByAdotadoFalse()
             .stream()
             .map(DadosDetalhesPet::new)
             .toList();
 }

 public void cadastrarPet(Abrigo abrigo, DadosCadastroPet dto) {
     repository.save(new Pet(dto, abrigo));
 }
}