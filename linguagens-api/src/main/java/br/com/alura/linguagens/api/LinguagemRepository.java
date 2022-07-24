package br.com.alura.linguagens.api;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    Optional<Linguagem> getById(String id);
}
