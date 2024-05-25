
package com.oferta.trabajo.Repository;


import com.oferta.trabajo.model.vacante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacantesRepository extends JpaRepository<vacante, Integer> {
    
        List<vacante> findByestatus(String  estatus);
        
        
        List<vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
        
        // para buscar entre un rango que se ingresa por para metro
        List<vacante> findBySalarioBetweenOrderBySalarioDesc(double s1, double s2);
        
        List<vacante> findBySalarioInOrderBySalarioDesc(double [] salario);
        
 
    

        
        
    
}
