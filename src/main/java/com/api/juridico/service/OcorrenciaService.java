package com.api.juridico.service;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.Ocorrencia;
import com.api.juridico.domain.model.Processo;
import com.api.juridico.domain.repository.ProcessoRepository;
import com.api.juridico.dto.OcorrenciaDto;
import com.api.juridico.dto.ProcessoDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OcorrenciaService {

    private ProcessoService processoService;

    @Autowired()
    private ProcessoRepository processoRepository;

    @Transactional(readOnly = true)
    public List<OcorrenciaDto> findAll(Long idProcesso){
        Optional<Processo> processo = processoRepository.findById(idProcesso);
        if (processo.isPresent()) {
            List<Ocorrencia> ocorrencia = processo.get().getOcorrecias();
            return ObjectMapperConfig.mapAll(ocorrencia, OcorrenciaDto.class);
        }else{
            return new ArrayList<>();
        }
    }

    @Transactional
    public OcorrenciaDto insert(Long idProcesso, String descricao){
         Processo processo = processoService.findProcesso(idProcesso);
        if (processo != null) {
            Ocorrencia ocorrencia = processo.insertOcorrencia(descricao);
            return ObjectMapperConfig.map(ocorrencia, OcorrenciaDto.class);
        }else{
            return null;
        }
    }
}
