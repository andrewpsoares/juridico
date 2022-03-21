package com.api.juridico.controller;

import com.api.juridico.dto.ProcessoDto;
import com.api.juridico.service.ProcessosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/processos")
public class ProcessoController {
    @Autowired
    private ProcessosService processosService;

//    @GetMapping
//    public List<ProcessoDto> findAll(){
//        return processosService.findAll();
//    }

    @GetMapping
    public Page<ProcessoDto> findAll(Pageable pageable){
        return processosService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessoDto> findById(@PathVariable Long id) {
        ProcessoDto processoDto = processosService.findById(id);
        if (processoDto != null) {
            return ResponseEntity.ok(processoDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessoDto insert(@Valid @RequestBody ProcessoDto processoDto){
        return processosService.insert(processoDto);
    }

    @PutMapping("/{id}")
    public ProcessoDto edit(@Valid @RequestBody ProcessoDto processoDto){
        return processosService.edit(processoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!processosService.delete(id)){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
