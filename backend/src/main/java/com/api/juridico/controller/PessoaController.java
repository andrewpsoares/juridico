package com.api.juridico.controller;

import com.api.juridico.dto.PessoaDto;
import com.api.juridico.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<PessoaDto> findBycpfCnpj(@RequestParam String cpfCnpj){
        Optional<PessoaDto> pessoaDto = pessoaService.findByCpfCnpj(cpfCnpj);
        if (pessoaDto.isPresent()) {
            return ResponseEntity.of(pessoaDto);
        }
        return ResponseEntity.notFound().build();
//        return pessoaService.findByCpfCnpj(cpfCnpj) teste
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
    }
}
