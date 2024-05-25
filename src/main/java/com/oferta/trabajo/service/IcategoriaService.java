
package com.oferta.trabajo.service;

import com.oferta.trabajo.model.categorias;
import java.util.List;


public interface IcategoriaService {
    
   void guardar (categorias categorias);
   List<categorias> buscarTodas();
   categorias buscarPorId (Integer id);
   void eliminar(Integer id);

    
           
    
    
}
