package com.api.juridico.service;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.Contrato;
import com.api.juridico.domain.model.Pessoa;
import com.api.juridico.domain.model.Processo;
import com.api.juridico.domain.repository.ContratoRepository;
import com.api.juridico.dto.ContratoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    private PessoaService pessoaService;

    @Transactional(readOnly = true)
    public Page<ContratoDto> findAll(Pageable pageable){
        Page<Contrato> contratos = contratoRepository.findAll(pageable);
        return contratos.map(ContratoDto::new);
    }

    @Transactional(readOnly = true)
    public ContratoDto findById(Long id) {
        Contrato contrato = contratoRepository.findById(id).get();
        return ObjectMapperConfig.map(contrato, ContratoDto.class);
    }

    @Transactional
    public ContratoDto insert(ContratoDto contratoDto){
        Contrato contrato = ObjectMapperConfig.map(contratoDto, Contrato.class);
        Pessoa empContratada  = pessoaService.findByCpfCnpj(contrato.getEmpContratada());
        Pessoa empContratante = pessoaService.findByCpfCnpj(contrato.getEmpContratante());
        pessoaService.save(empContratada);
        pessoaService.save(empContratante);
        contratoRepository.save(contrato);
        return ObjectMapperConfig.map(contrato, ContratoDto.class);
    }

    public ContratoDto edit(ContratoDto contratoDto){
        return insert(contratoDto);
    }

    public Contrato findProcesso(Long id){
        return contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processo não existe"));
    }

    @Transactional
    public boolean delete(Long objId){
        if(contratoRepository.existsById(objId)){
            contratoRepository.deleteById(objId);
            return true;
        }
        return false;
    }
}
