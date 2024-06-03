/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oferta.trabajo.service;

import com.oferta.trabajo.model.usuarios;
import java.util.List;

/**
 *
 * @author cuero
 */
public interface IusuarioService {
    
    void guardar (usuarios usuarios);
    
    void eliminar (Integer id);
    
    List<usuarios> buscarTodas();
    
    usuarios buscarPorUsername(String username);
    
}
