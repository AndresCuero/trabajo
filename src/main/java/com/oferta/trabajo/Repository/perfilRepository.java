
package com.oferta.trabajo.Repository;


import com.oferta.trabajo.model.Perfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface perfilRepository extends JpaRepository<Perfiles, Integer>  {
    
}
