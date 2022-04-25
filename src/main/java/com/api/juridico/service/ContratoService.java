package com.api.juridico.service;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.Contrato;
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

//    private PessoaService pessoaService;
//    private ModelMapper modelMapper;

//    public ProcessoDto findObj(Processo processo){
//        return modelMapper.map(processo, ProcessoDto.class);
//    }

//    public Processo findProcesso(Long id){
//        return processoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Processo não existe"));
//    }

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
//
//    @Transactional
//    public ProcessoDto insert(ProcessoDto processoDto){
//        Processo processo = ObjectMapperConfig.map(processoDto, Processo.class);
//        Pessoa autor = pessoaService.findByCpfCnpj(processo.getAutor());
//        Pessoa reu   = pessoaService.findByCpfCnpj(processo.getReu());
//        pessoaService.save(autor);
//        pessoaService.save(reu);
//        processoRepository.save(processo);
//        return ObjectMapperConfig.map(processo, ProcessoDto.class);
//    }
//
//    public ProcessoDto edit(ProcessoDto processoDto){
//        return insert(processoDto);
//    }
//
//    @Transactional
//    public boolean delete(Long objId){
//        if(processoRepository.existsById(objId)){
//            processoRepository.deleteById(objId);
//            return true;
//        }
//        return false;
//    }
}
