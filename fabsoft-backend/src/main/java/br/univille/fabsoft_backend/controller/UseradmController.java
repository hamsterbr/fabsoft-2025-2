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

import br.univille.fabsoft_backend.entity.UserAdm;
import br.univille.fabsoft_backend.service.UseradmService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usersadm")
public class UseradmController {

    @Autowired
    private UseradmService service;

    @GetMapping
    public ResponseEntity<List<UserAdm>> getUseradm(){
        
        var listaUserAdm = service.getAll();

        return new ResponseEntity<List<UserAdm>>(listaUserAdm,
            HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserAdm> save(@Valid @RequestBody UserAdm useradm, BindingResult result){
        if(useradm == null){
            return ResponseEntity.badRequest().build();
        }
        if (result.hasErrors()) {
            HttpHeaders headers = new HttpHeaders();
            String errorMessages = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(" "));
            headers.add("Erro", errorMessages);
            return new ResponseEntity<UserAdm>(useradm,headers,HttpStatus.BAD_REQUEST);
        }
        if(useradm.getMatricula() == 0){
            useradm = service.save(useradm);
            return new ResponseEntity<UserAdm>(useradm,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAdm> 
        update(@RequestBody UserAdm useradm,
            @PathVariable long id){

        if(id <= 0 || useradm == null){
            return ResponseEntity.badRequest().build();
        }

        try {
            useradm = service.update(id, useradm);
            return new ResponseEntity<UserAdm>(useradm,
                    HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<UserAdm> 
        update(@PathVariable long id){

        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        try {
            var useradm = service.delete(id);
            return new ResponseEntity<UserAdm>(useradm,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }

}
