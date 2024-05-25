
package com.oferta.trabajo.service;

import com.oferta.trabajo.model.vacante;
import java.util.List;

public interface IvacantesService {
    
    List<vacante> budcarTodas();
    
    vacante buscarPorId(Integer idvacante);
    
    void guardar(vacante vacante);
     
    List<vacante> buscarDestacada();
    
    void eliminar(Integer idVacante);
    
    
    
    
    
    
    
}
