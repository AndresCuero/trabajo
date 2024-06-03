
package com.oferta.trabajo.service;

import com.oferta.trabajo.Repository.UsuarioRepository;
import com.oferta.trabajo.model.usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cuero
 */
@Service
public class usuarioIMP implements IusuarioService  {
    
    @Autowired
    private UsuarioRepository repoUsuario;

    @Override
    public void guardar(usuarios usuarios) {
       repoUsuario.save(usuarios);
    }

    @Override
    public void eliminar(Integer id) {
      repoUsuario.findById(id);
    }

    @Override
    public List<usuarios> buscarTodas() {
        return repoUsuario.findAll();
    }

    @Override
    public usuarios buscarPorUsername(String username){ 
        return repoUsuario.findByUsername(username);
    }
    
    
}
