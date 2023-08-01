package com.CRUDAngular.CRUDAngular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CRUDAngular.CRUDAngular.documentos.Usuarios;
import com.CRUDAngular.CRUDAngular.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    List<Usuarios> index(){
        return usuarioRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Usuarios create(@RequestBody Usuarios usuarios){
        return usuarioRepository.save(usuarios);
    }

    @PutMapping("{id}")
    Usuarios update(@PathVariable Integer id, @RequestBody Usuarios usuarios){
        Usuarios usuarioFromDB = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usuarioFromDB.setNombre(usuarios.getNombre());
        usuarioFromDB.setEmail(usuarios.getEmail());

        return usuarioRepository.save(usuarioFromDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable Integer id){
        Usuarios usuarioFromDB = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usuarioRepository.delete(usuarioFromDB);
    }
}
    /* 
    @PostMapping
    public ResponseEntity<?> saveUsuario(@RequestBody Usuarios usuario){
        try {
            Usuarios savepersona = usuarioRepository.save(usuario);
            return new ResponseEntity<Usuarios>(savepersona, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);                                                           
        }
    }

    @GetMapping
    public ResponseEntity<?> listarUsuario(){
        try {
            List<Usuarios> usuarios = usuarioRepository.findAll();
            return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);                                                           
        }
    }

    //@PutMapping("{?}")
    @PutMapping
    public ResponseEntity<?> updateUsuario(@RequestBody Usuarios usuario){
        try {
            Usuarios savepersona = usuarioRepository.save(usuario);
            return new ResponseEntity<Usuarios>(savepersona, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);                                                           
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Integer id){
        try {
            usuarioRepository.deleteById(id);
            return new ResponseEntity<String>("Fue eliminado",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);                                                           
        }
    }
    */

