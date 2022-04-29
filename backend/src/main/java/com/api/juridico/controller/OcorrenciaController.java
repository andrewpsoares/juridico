package com.api.juridico.controller;

import com.api.juridico.dto.OcorrenciaDto;
import com.api.juridico.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/processos/{idProcesso}/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @GetMapping
    public List<OcorrenciaDto> findAll(@PathVariable Long idProcesso){
        return ocorrenciaService.findAll(idProcesso);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDto insert(@PathVariable Long idProcesso,
                                @Valid @RequestBody OcorrenciaDto ocorrenciaDto){
        return ocorrenciaService.insert(idProcesso, ocorrenciaDto.getDescricao());
    }
}
