
package com.oferta.trabajo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name=("Perfiles"))
public class Perfiles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    private int id;
    private String perfil;
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Perfiles{" + "id=" + id + ", perfil=" + perfil + '}';
    }
    
    
    
}
