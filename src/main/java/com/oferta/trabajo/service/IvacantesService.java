
package com.oferta.trabajo.service;

import com.oferta.trabajo.model.vacante;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IvacantesService {
    
    List<vacante> budcarTodas();
    
    vacante buscarPorId(Integer idvacante);
    
    void guardar(vacante vacante);
     
    List<vacante> buscarDestacada();
    
    void eliminar(Integer idVacante);
    
    List<vacante> buscarByExample(Example<vacante> example);
    
   Page<vacante> buscarTodas(Pageable page);
    
    
    
    
    
    
    
}
