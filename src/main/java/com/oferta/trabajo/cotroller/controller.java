
package com.oferta.trabajo.cotroller;

import com.oferta.trabajo.model.Perfiles;
import com.oferta.trabajo.model.usuarios;
import com.oferta.trabajo.model.vacante;
import com.oferta.trabajo.service.IcategoriaService;
import com.oferta.trabajo.service.IusuarioService;
import com.oferta.trabajo.service.IvacantesService;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class controller {
    
    @Autowired
    @Qualifier("vacanteServiceJPA")
    private IvacantesService serviceVacante;
    
    @Autowired
    private IcategoriaService serviceCategoria;
    
    @Autowired
    private IusuarioService usuarioService;
    
    
    
     @GetMapping("/tabla")
      public String mostraTabla(Model model){
          
          List<vacante> lista = serviceVacante.budcarTodas();
          model.addAttribute("vacantes", lista);
          
          return "tabla";
          
      }
    
       
    @GetMapping("/detalle")
    public String mostrarModelo(Model model){
        
        vacante vacante = new vacante();
        vacante.setNombre("programador en java");
        vacante.setDescricion("programador de java con experiencia en spring boot ");
        vacante.setFecha(new Date());
        vacante.setSalario(999.0);
        
        model.addAttribute("empleoss", vacante);
        
        return "detalle";
    
     
    }
    
        @GetMapping("/listado")
    public String mostrarListado(Model model){
        
        List<String> lista = new LinkedList<String>();
        lista.add("Auxiliar contable");
        lista.add("Ingeniero de sistema");
        lista.add("vendedor");
        lista.add("Arquiteto");
        
      model.addAttribute("empleos", lista);
        
        return "listado";
        
    }
    
     @GetMapping("/")
    public String mostraHome(Model model){
        
         List<vacante> lista = serviceVacante.buscarDestacada();
          model.addAttribute("vacantes", lista);
      
     

        return "home";
        
    }
    
     @GetMapping("/r")
public String registrarse(Model model, usuarios usuario) {
     model.addAttribute("usuario", new usuarios());
    return "formRegistro";
}
	
	@PostMapping("/signup")
	public String guardarRegistro(usuarios usuario, RedirectAttributes attributes) {
		usuario.setEstatus(1); 
		usuario.setFechaRegistro(new Date());
		
		Perfiles perfil = new Perfiles();
		perfil.setId(3); // Perfil USUARIO

		
		usuarioService.guardar(usuario);
				
		attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");
		
		return "redirect:/usuario/index";
	}
    @GetMapping("/search")
    public String buscar(@ModelAttribute("search") vacante vacante) {
        System.out.println("el objecto bacante :" + vacante);
        return "home";

    }

@ModelAttribute
public void setGenerico(Model model){
vacante vacanteSearch = new vacante();
model.addAttribute("vacantes",serviceVacante.budcarTodas());
model.addAttribute("categorias", serviceCategoria.buscarTodas());
model.addAttribute("search", vacanteSearch);


}
    
        
}
