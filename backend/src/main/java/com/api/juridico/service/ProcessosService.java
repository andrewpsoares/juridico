package com.api.juridico.service;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.Pessoa;
import com.api.juridico.domain.model.Processo;
import com.api.juridico.domain.repository.ProcessoRepository;
import com.api.juridico.dto.ProcessoDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ProcessosService {
    @Autowired
    private ProcessoRepository processoRepository;
    private PessoaService pessoaService;

    private ModelMapper modelMapper;

    public ProcessoDto findObj(Processo processo){
        return modelMapper.map(processo, ProcessoDto.class);
    }

//    public List<ProcessoDto> findAll(){
//        List<Processo> processos = processoRepository.findAll();
//        return ObjectMapperConfig.mapAll(processos, ProcessoDto.class);
//    }

    @Transactional(readOnly = true)
    public Page<ProcessoDto> findAll(Pageable pageable){
        Page<Processo> processos = processoRepository.findAll(pageable);
        return processos.map(ProcessoDto::new);
    }

    @Transactional(readOnly = true)
    public ProcessoDto findById(Long id) {
        Processo processo = processoRepository.findById(id).get();
        return ObjectMapperConfig.map(processo, ProcessoDto.class);
    }

    @Transactional
    public ProcessoDto insert(ProcessoDto processoDto){
        Processo processo = ObjectMapperConfig.map(processoDto, Processo.class);
        Pessoa autor = pessoaService.findByCpfCnpj(processo.getAutor());
        pessoaService.save(autor);
        processoRepository.save(processo);
        return ObjectMapperConfig.map(processo, ProcessoDto.class);
    }

    public ProcessoDto edit(ProcessoDto processoDto){
        return insert(processoDto);
    }

    @Transactional
    public boolean delete(Long objId){
        if(processoRepository.existsById(objId)){
            processoRepository.deleteById(objId);
            return true;
        }
        return false;
    }
}
