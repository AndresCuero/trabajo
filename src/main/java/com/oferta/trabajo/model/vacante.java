
package com.oferta.trabajo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Date;

   @Entity
   @Table(name="vacantes")
public class vacante {
    
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Double salario;
    private Integer destacado;
    private String imagen="no-image.png";
    private String estatus;
    private String detalles;
    //@Transient
    @OneToOne
    @JoinColumn(name="idCategoria")
    private categorias categorias;
    
    public void reset(){
    this.imagen=null;}
 

    // get
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Double getSalario() {
        return salario;
    }
    
       public Integer getDestacada() {
        return destacado;
    }

    public String getImagen() {
        return imagen;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getDetalles() {
        return detalles;
    }

    public categorias getCategorias() {
        return categorias;
    }
    
    
    
    
       
       

    // set
    public void setId(Integer id) {

        this.id = id;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descricion) {
        this.descripcion = descricion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setDestacada(Integer destacada) {
        this.destacado = destacada;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public void setCategorias(categorias categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Vacante{" + "id=" + id + ", nombre=" + nombre + ", descricion=" + descripcion + ", fecha=" + fecha + ", salario=" + salario + ", destacada=" + destacado + ", imagen=" + imagen + ", estatus=" + estatus + ", detalles=" + detalles + ", categorias=" + categorias + '}';
    }
    
    
    
}
