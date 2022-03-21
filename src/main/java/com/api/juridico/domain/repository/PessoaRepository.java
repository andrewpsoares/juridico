package com.api.juridico.domain.repository;

import com.api.juridico.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    public Pessoa findByCpfCnpj(String pCpfCnpj);
}
