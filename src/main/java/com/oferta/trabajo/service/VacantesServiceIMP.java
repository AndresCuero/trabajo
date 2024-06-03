
package com.oferta.trabajo.service;

import com.oferta.trabajo.model.vacante;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacantesServiceIMP implements  IvacantesService {
    
    private List<vacante> lista = null;
    
    public VacantesServiceIMP(){
    
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista =  new LinkedList<vacante> ();
          
          try {
              
              vacante vacante1 = new vacante();
              
                  vacante1.setId(1);
                  vacante1.setNombre("Ingeniero en sistema");
                  vacante1.setDescripcion("experiencia en sistema ");
                  vacante1.setFecha(sdf.parse("11-04-2024"));
                  vacante1.setSalario(999.0);
                  vacante1.setDestacada(1);
                  vacante1.setImagen("empresa1.png");
                  
                  
             vacante vacante2 = new vacante();
              
                  vacante2.setId(2);
                  vacante2.setNombre("programador en java");
                  vacante2.setDescripcion(" experiencia en spring boot ");
                  vacante2.setFecha(sdf.parse("11-04-2024"));
                  vacante2.setSalario(999.0);
                  vacante2.setDestacada(0);
                  vacante2.setImagen("empresa2.png");
                  
                  
            vacante vacante3 = new vacante();
              
                  vacante3.setId(3);
                  vacante3.setNombre("programador en java");
                  vacante3.setDescripcion("experiencia en spring boot ");
                  vacante3.setFecha(sdf.parse("11-04-2024"));
                  vacante3.setSalario(999.0);
                  vacante3.setDestacada(1);
                  vacante3.setImagen("empresa3.png");
                  
                  
             vacante vacante4 = new vacante();
              
                  vacante4.setId(4);
                  vacante4.setNombre("programador en java");
                  vacante4.setDescripcion("experiencia en spring boot ");
                  vacante4.setFecha(sdf.parse("11-04-2024"));
                  vacante4.setSalario(999.0);
                  vacante4.setDestacada(0);
                  
                  
             vacante vacante5 = new vacante();
              
                  vacante5.setId(5);
                  vacante5.setNombre("programador en java");
                  vacante5.setDescripcion("experiencia en spring boot ");
                  vacante5.setFecha(sdf.parse("11-04-2024"));
                  vacante5.setSalario(999.0);
                  vacante5.setDestacada(1);
                  
                  
             vacante vacante6 = new vacante();
              
                  vacante6.setId(6);
                  vacante6.setNombre("programador en java");
                  vacante6.setDescripcion("experiencia en spring boot ");
                  vacante6.setFecha(sdf.parse("11-04-2024"));
                  vacante6.setSalario(999.0);
                  vacante6.setDestacada(0);
                  
                  lista.add(vacante1);
                  lista.add(vacante2);
                  lista.add(vacante3);
                  lista.add(vacante4);
                  lista.add(vacante5);
                  lista.add(vacante6);
                 
                  
                 
              
              
          } catch (Exception e) {
              
              System.out.println("error "+e);
          }
          
      
      
      }
    
    

    @Override
    public List<vacante> budcarTodas() {
       return lista;
    }

    @Override
    public vacante buscarPorId(Integer idvacnte) {
        for(vacante v: lista){
            if(v.getId()== idvacnte)
                return v;
            
        }
        return null;
    }

    @Override
    public void guardar(vacante vacante) {
        lista.add(vacante);
    }

    

    @Override
    public List<vacante> buscarDestacada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer idVacante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<vacante> buscarByExample(Example<vacante> example) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<vacante> buscarTodas(Pageable page) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
