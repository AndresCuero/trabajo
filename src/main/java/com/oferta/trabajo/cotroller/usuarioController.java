
package com.oferta.trabajo.cotroller;

import com.oferta.trabajo.model.Perfiles;
import com.oferta.trabajo.model.usuarios;
import com.oferta.trabajo.service.IusuarioService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author cuero
 */

@Controller
@RequestMapping("/usuario")
public class usuarioController {
    
    @Autowired
    private IusuarioService usuarioService;
    
   @GetMapping("/index")
	public String mostrarIndex(Model model) {
    	List<usuarios> lista = usuarioService.buscarTodas();
    	model.addAttribute("usuarios", lista);
		return "listUsuarios";
	}
        
        @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		    	
		// Eliminamos el usuario
    	         usuarioService.eliminar(idUsuario);			
		attributes.addFlashAttribute("msg", "El usuario fue eliminado!.");
		return "redirect:/usuarios/index";
	}
        


    
}
