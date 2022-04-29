package com.api.juridico.domain.repository;

import com.api.juridico.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    public Optional<Pessoa> findByCpfCnpj(String pCpfCnpj);
}
