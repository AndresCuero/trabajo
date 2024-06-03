
package com.oferta.trabajo.service;

import com.oferta.trabajo.model.categorias;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IcategoriaService {
    
   void guardar (categorias categorias);
   
   List<categorias> buscarTodas();
   
   categorias buscarPorId (Integer id);
   
   void eliminar(Integer id);
   
   Page<categorias> buscarTodas(Pageable page);
   

    
           
    
    
}
