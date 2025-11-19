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

import br.univille.fabsoft_backend.entity.UserComum;
import br.univille.fabsoft_backend.service.UsercomumService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/userscomum")
public class UsercomumController {

    @Autowired
    private UsercomumService service;

    @GetMapping
    public ResponseEntity<List<UserComum>> getUsercomum(){
        
        var listaUserComum = service.getAll();

        return new ResponseEntity<List<UserComum>>(listaUserComum,
            HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserComum> save(@Valid @RequestBody UserComum usercomum, BindingResult result){
        if(usercomum == null){
            return ResponseEntity.badRequest().build();
        }
        if (result.hasErrors()) {
            HttpHeaders headers = new HttpHeaders();
            String errorMessages = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(" "));
            headers.add("Erro", errorMessages);
            return new ResponseEntity<UserComum>(usercomum,headers,HttpStatus.BAD_REQUEST);
        }
        if(usercomum.getMatricula() == 0){
            usercomum = service.save(usercomum);
            return new ResponseEntity<UserComum>(usercomum,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserComum> 
        update(@RequestBody UserComum usercomum,
            @PathVariable long id){

        if(id <= 0 || usercomum == null){
            return ResponseEntity.badRequest().build();
        }

        try {
            usercomum = service.update(id, usercomum);
            return new ResponseEntity<UserComum>(usercomum,
                    HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<UserComum> 
        update(@PathVariable long id){

        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        try {
            var usercomum = service.delete(id);
            return new ResponseEntity<UserComum>(usercomum,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }

}
