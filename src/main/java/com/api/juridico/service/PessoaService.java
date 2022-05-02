package com.api.juridico.service;

import com.api.juridico.domain.model.Pessoa;
import com.api.juridico.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findByCpfCnpj(Pessoa objPessoa){
        Pessoa pessoa = pessoaRepository.findByCpfCnpj(objPessoa.getCpfCnpj());
        if (pessoa != null) {
            objPessoa.setId(pessoa.getId());
        }
        return objPessoa;
    }

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
}
