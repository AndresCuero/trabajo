
package com.oferta.trabajo.service.db;

import com.oferta.trabajo.Repository.VacantesRepository;
import com.oferta.trabajo.model.vacante;
import com.oferta.trabajo.service.IvacantesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service("vacanteServiceJPA")
public class vacanteServiceJPA implements IvacantesService {
    
@Autowired
private VacantesRepository vacantesRepo;

    @Override
    public List<vacante> budcarTodas() {
        return vacantesRepo.findAll();
        
    }

    @Override
    public vacante buscarPorId(Integer idvacante) {
        Optional<vacante> optional = vacantesRepo.findById(idvacante);
        if(optional.isPresent()){
           return optional.get(); 
        }
        return null;
    }

    @Override
    public void guardar(vacante vacante) {
        vacantesRepo.save(vacante);
    }

  

    @Override
    public List<vacante> buscarDestacada() {
        return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
        
    }

    @Override
    public void eliminar(Integer idVacante) {
        vacantesRepo.deleteById(idVacante);
    }

    @Override
    public List<vacante> buscarByExample(Example<vacante> example) {
       return vacantesRepo.findAll(example);
    }

    @Override
    public Page<vacante> buscarTodas(Pageable page) {
      return vacantesRepo.findAll(page);
    }
    
    
    
}
