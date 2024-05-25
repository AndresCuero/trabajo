
package com.oferta.trabajo.Repository;


import com.oferta.trabajo.model.categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// es para extender un re positorio de base de datos, la implementacion esta en la clase principal del proyecto
//public interface CategoriaRepository extends CrudRepository<categoria, Integer> {

@Repository
public interface CategoriaRepository extends JpaRepository<categorias, Integer> {
    
    
    
    
}
