package com.api.juridico.controller;

import com.api.juridico.dto.ContratoDto;
import com.api.juridico.dto.ProcessoDto;
import com.api.juridico.service.ContratoService;
import com.api.juridico.service.ProcessoService;
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

//    @GetMapping
//    public List<ProcessoDto> findAll(){
//        return processosService.findAll();
//    }

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

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ProcessoDto insert(@Valid @RequestBody ProcessoDto processoDto){
//        return contratoService.insert(processoDto);
//    }

//    @PutMapping("/{id}")
//    public ProcessoDto edit(@Valid @RequestBody ProcessoDto processoDto){
//        return processosService.edit(processoDto);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (!processosService.delete(id)){
//            return ResponseEntity.notFound().build();
//        }else{
//            return ResponseEntity.noContent().build();
//        }
//    }
}
