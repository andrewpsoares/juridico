package com.api.juridico.service;

import com.api.juridico.config.ModelMapperConfig;
import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.Pessoa;
import com.api.juridico.domain.repository.PessoaRepository;
import com.api.juridico.dto.PessoaDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    private ModelMapper modelMapper;

    public Pessoa findByCpfCnpj(Pessoa objPessoa){
//        Pessoa pessoa = pessoaRepository.findByCpfCnpj(objPessoa.getCpfCnpj());
//        if (pessoa != null) {
//            objPessoa.setId(pessoa.getId());
//        }
        return objPessoa;
    }

    @Transactional(readOnly = true)
    public Optional<PessoaDto> findByCpfCnpj(String cpfCnpj){
        Optional<Pessoa> pessoa =  pessoaRepository.findByCpfCnpj(cpfCnpj);
        return pessoa.map(value -> modelMapper.map(value, PessoaDto.class));
    }

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
}
