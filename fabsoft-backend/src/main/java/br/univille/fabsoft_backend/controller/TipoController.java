
package br.univille.fabsoft_backend.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fabsoft_backend.entity.Tipo;
import br.univille.fabsoft_backend.service.TipoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tipos")
public class TipoController {

    @Autowired
    private TipoService service;

    
    @GetMapping
    public ResponseEntity<List<Tipo>> getSolicitacoes(){
        
        var listaTipos = service.getAll();

        return new ResponseEntity<List<Tipo>>(listaTipos,
            HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tipo> save(@Valid @RequestBody Tipo tipo, BindingResult result){
        if(tipo == null){
            return ResponseEntity.badRequest().build();
        }
        if (result.hasErrors()) {
            HttpHeaders headers = new HttpHeaders();
            String errorMessages = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(" "));
            headers.add("Erro", errorMessages);
            return new ResponseEntity<Tipo>(tipo,headers,HttpStatus.BAD_REQUEST);
        }
        if(tipo.getId() == 0){
            tipo = service.save(tipo);
            return new ResponseEntity<Tipo>(tipo,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> 
        update(@RequestBody Tipo tipo,
            @PathVariable long id){

        if(id <= 0 || tipo == null){
            return ResponseEntity.badRequest().build();
        }

        try {
            tipo = service.update(id, tipo);
            return new ResponseEntity<Tipo>(tipo,
                    HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tipo> 
        update(@PathVariable long id){

        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        try {
            var tipo = service.delete(id);
            return new ResponseEntity<Tipo>(tipo,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }

}
