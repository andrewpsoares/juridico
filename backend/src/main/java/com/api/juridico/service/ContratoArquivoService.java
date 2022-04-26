package com.api.juridico.service;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.Contrato;
import com.api.juridico.domain.model.ContratoArquivo;
import com.api.juridico.domain.model.Ocorrencia;
import com.api.juridico.domain.model.Processo;
import com.api.juridico.domain.repository.ContratoRepository;
import com.api.juridico.domain.repository.ProcessoRepository;
import com.api.juridico.dto.ContratoArquivoDto;
import com.api.juridico.dto.OcorrenciaDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContratoArquivoService {

    private ContratoService contratoService;

    @Autowired
    private ContratoRepository contratoRepository;

    @Transactional(readOnly = true)
    public List<ContratoArquivoDto> findAll(Long idContrato){
        Optional<Contrato> contrato = contratoRepository.findById(idContrato);
        if (contrato.isPresent()) {
            List<ContratoArquivo> contratoArquivo = contrato.get().getArquivos();
            return ObjectMapperConfig.mapAll(contratoArquivo, ContratoArquivoDto.class);
        }else{
            return new ArrayList<>();
        }
    }

    @Transactional
    public void insert(Long idContrato, MultipartFile file){
        try{
            Contrato contrato = contratoService.findProcesso(idContrato);
            if (contrato != null) {
                contrato.insertFile(idContrato, file);
                //Files.copy(contrato.getArquivos(), "d:");
            }
        } catch (Exception e){
            throw new RuntimeException("Erro ao salvar o arquivo. Error: " + e.getMessage());
        }
    }
}
