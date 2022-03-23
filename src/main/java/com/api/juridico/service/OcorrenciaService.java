package com.api.juridico.service;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.Ocorrencia;
import com.api.juridico.domain.model.Processo;
import com.api.juridico.dto.OcorrenciaDto;
import com.api.juridico.dto.ProcessoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class OcorrenciaService {

    private ProcessoService processoService;

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
