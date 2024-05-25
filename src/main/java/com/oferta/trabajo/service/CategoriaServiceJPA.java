/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oferta.trabajo.service;

import com.oferta.trabajo.Repository.CategoriaRepository;
import com.oferta.trabajo.model.categorias;
import com.oferta.trabajo.service.IcategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("CategoriaServiceJPA") 
public class CategoriaServiceJPA implements IcategoriaService{
    
    @Autowired
    private CategoriaRepository categoriaRepo;
    

    @Override
    public void guardar(categorias categoria) {
        categoriaRepo.save(categoria);   
    }
    
    @Override
    public List<categorias> buscarTodas() {
        return categoriaRepo.findAll();     
    }

    @Override
    public categorias buscarPorId(Integer idCategoria) {
     Optional<categorias> optional = categoriaRepo.findById(idCategoria);
     if(optional.isEmpty())
         return optional.get();
     return null; 
    }

    @Override
    public void eliminar(Integer idCategoria) {
        categoriaRepo.deleteById(idCategoria);
    }
    
     public List<categorias> buscarrTodas() {
        return categoriaRepo.findAll();     
    }
    
}
