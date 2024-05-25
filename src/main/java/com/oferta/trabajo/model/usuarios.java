
package com.oferta.trabajo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name="usuarios")
public class usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
   // @NotEmpty(message = "El correo electrónico no puede estar vacío")
    private String email;
    //@NotEmpty(message = "El correo electrónico no puede estar vacío")
    private String username;
    private String password;
    private int estatus;
    private Date fechaRegistro;
    //@ aqui va un bing para que no tome en cuenta la linea siguiente
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="usuarioperfil",
            joinColumns= @JoinColumn(name="idUsuario"),
            inverseJoinColumns = @ JoinColumn(name="idPerfil")
    
    
    )
    private List<Perfiles> perfil;
    
    public void agregar(Perfiles tempPerfil){
       if(perfil == null){
         perfil = new LinkedList<Perfiles>();
       }
       perfil.add(tempPerfil);
    }

    public usuarios() {
    }

    public usuarios(Integer id, String nombre, String email, String username, String password, int estatus, Date fechaRegistro, List<Perfiles> perfil) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.username = username;
        this.password = password;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Perfiles> getPerfil() {
        return perfil;
    }

    public void setPerfil(List<Perfiles> perfil) {
        this.perfil = perfil;
    }

    
   

    
    
}






