
package com.oferta.trabajo.Repository;


import com.oferta.trabajo.model.usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<usuarios, Integer>{
    
    usuarios findByUsername(String username);
    
    
}
