
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
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        vacante.setDescripcion("programador de java con experiencia en spring boot ");
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
    
    
    @GetMapping("/index")
    public String mostrarIndex(Authentication auth){
         String username = auth.getName();
         System.out.println("Nombre del usuario: "+ username);
         for(GrantedAuthority rol: auth.getAuthorities()){
           System.out.println("ROL: "+ rol.getAuthority() );
         }
         return "redirect:/";
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
        
  // los dos ultimo metodos tienen que ver con buscar
    @GetMapping("/search")
    public String buscar(@ModelAttribute("search") vacante vacante,Model model) {
        
        //para hacer que no busque comparando el codigo 
        ExampleMatcher matcheer = ExampleMatcher.matching().
                // where descripcion like '%?%'
                withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
        
        
        //para hacacer busquedas
        Example<vacante> example = Example.of(vacante, matcheer);
        List<vacante> lista = serviceVacante.buscarByExample(example);
        model.addAttribute("vacantes", lista);
        return "home";
    }
    
    // InitBinder para string si los detecta vacios en el data Binding los settea a null
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true)); 
    }

@ModelAttribute
public void setGenerico(Model model){
vacante vacanteSearch = new vacante();
vacanteSearch.reset();
model.addAttribute("vacantes",serviceVacante.budcarTodas());
model.addAttribute("categorias", serviceCategoria.buscarTodas());
model.addAttribute("search", vacanteSearch);


}
    
        
}
