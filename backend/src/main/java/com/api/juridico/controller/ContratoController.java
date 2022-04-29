package com.api.juridico.controller;

import com.api.juridico.dto.ContratoDto;
import com.api.juridico.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public Page<ContratoDto> findAll(Pageable pageable){
        return contratoService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDto> findById(@PathVariable Long id) {
        ContratoDto contratoDto = contratoService.findById(id);
        if (contratoDto != null) {
            return ResponseEntity.ok(contratoDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContratoDto insert(@Valid @RequestBody ContratoDto contratoDto){
        return contratoService.insert(contratoDto);
    }

    @PutMapping("/{id}")
    public ContratoDto edit(@Valid @RequestBody ContratoDto contratoDto){
        return contratoService.edit(contratoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!contratoService.delete(id)){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
