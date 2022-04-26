package com.api.juridico.controller;

import com.api.juridico.dto.ContratoArquivoDto;
import com.api.juridico.dto.OcorrenciaDto;
import com.api.juridico.service.ContratoArquivoService;
import com.api.juridico.service.ContratoService;
import com.api.juridico.service.OcorrenciaService;
import com.sun.source.tree.TryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contratos/{idContrato}/arquivos")
public class ContratoArquivoController {

    @Autowired
    private ContratoArquivoService contratoArquivoService;

    @GetMapping
    public List<ContratoArquivoDto> findAll(@PathVariable Long idContrato){
        return contratoArquivoService.findAll(idContrato);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> insert(@PathVariable Long idContrato,
                                         @RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            contratoArquivoService.insert(idContrato, file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
            //return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
}
