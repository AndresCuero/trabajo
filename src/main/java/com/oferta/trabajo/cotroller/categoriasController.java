package com.oferta.trabajo.cotroller;

import com.oferta.trabajo.model.categorias;
import com.oferta.trabajo.service.IcategoriaService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/categorias")
public class categoriasController {
    
    @Autowired
    private IcategoriaService categoriaService;

  @RequestMapping(value="/index", method=RequestMethod.GET)
    public String mostrasIndex(Model model) {
        List<categorias> lista = categoriaService.buscarTodas();
        model.addAttribute("categoria", lista);
        return "categoria/listCategorias";

    }

    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String crear(categorias categoria, Model model) {
        model.addAttribute("categorias", categoria);
        return "categoria/formCategoria";
    }

   @RequestMapping(value="/save", method=RequestMethod.POST)
    public String guardar(categorias categoria, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            System.out.println("Existieron errores");
            return "categorias/formCategoria";
        }

        // Guadamos el objeto categoria en la bd
        categoriaService.guardar(categoria);
        attributes.addFlashAttribute("msj", "Los datos de la categoría fueron guardados!");
        return "redirect:/categorias/index";
    }
    
       @GetMapping("/editar/{id}")
     public String editar(@PathVariable("id") int idCategoria, Model model, RedirectAttributes attribute) {
        categorias categoria = categoriaService.buscarPorId(idCategoria);
        if (categoria != null) {
            model.addAttribute("categorias", categoria);
            attribute.addFlashAttribute("msj", "registro!");
            return "categoria/formCategoria";
        } else {
            attribute.addFlashAttribute("error", "Categoría no encontrada");
            return "categoria/formCategoria";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attribute) {
        categoriaService.eliminar(idCategoria);
        attribute.addFlashAttribute("msj", "Categoria {"+idCategoria+"} eliminada");
        return "redirect:/categorias/index";
    }
    
  
 
    
  
 
    
}
