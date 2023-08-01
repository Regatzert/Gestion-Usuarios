package com.CRUDAngular.CRUDAngular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.CRUDAngular.CRUDAngular.documentos.Usuarios;

public interface UsuarioRepository extends MongoRepository<Usuarios, Integer>{
    
}
