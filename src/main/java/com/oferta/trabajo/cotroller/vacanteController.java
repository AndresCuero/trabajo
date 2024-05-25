package com.oferta.trabajo.cotroller;

import com.oferta.trabajo.model.vacante;
import com.oferta.trabajo.service.IcategoriaService;
import com.oferta.trabajo.service.IvacantesService;
import com.oferta.trabajo.util.utileria;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vacantes")
public class vacanteController {
    
    @Value("${trabajoapp.ruta.imagen}")
    private String ruta;

    @Autowired
    @Qualifier("vacanteServiceJPA")
    private IvacantesService serviceVacante;

    @Autowired
    @Qualifier("CategoriaServiceJPA")
    private IcategoriaService serviceCategoria;

    
    @GetMapping("/index")
    public String otenerVacante(Model model) {
        List<vacante> lista = serviceVacante.budcarTodas();
        model.addAttribute("vacante", lista);
        return "vacantes/listVacantes";
    }

    @GetMapping("/create")
    public String crear(vacante vacante, Model model) {
        model.addAttribute("categorias", serviceCategoria.buscarTodas());
        return "vacantes/formVacante";
    }

    @PostMapping("/save")
    public String gurdar(vacante vacante, BindingResult result, RedirectAttributes attributes, 
            @RequestParam("archivoImagen") MultipartFile multiPart) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("ocurrio un error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }

        if (!multiPart.isEmpty()) {
            //String ruta = "/empleos/img-vacantes/"; // Linux/MAC
           // String ruta = "c:/empleos/img-vacantes/"; // Windows
            String nombreImagen = utileria.guardarArchivo(multiPart, ruta);
            if (nombreImagen != null) { // La imagen si se subio
            // Procesamos la variable nombreImagen
                vacante.setImagen(nombreImagen);
            }
        }

        serviceVacante.guardar(vacante);
        attributes.addFlashAttribute("msj", "Registro Guardado");
        System.out.println(" vacancates " + vacante);
        return "redirect:/vacantes/index";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idvacante, Model model, RedirectAttributes attributes) {
        System.out.println("borra vacante de id: " + idvacante);
        serviceVacante.eliminar(idvacante);
         attributes.addFlashAttribute("msj", "Registro eliminado");
        return "redirect:/vacantes/index";
    }
    
     @GetMapping("/editar/{id}")
    public String editar (@PathVariable("id") int idVacante, Model model, RedirectAttributes attribute){
     vacante vacante = serviceVacante.buscarPorId(idVacante);
     model.addAttribute("vacante", vacante);
     //model.addAttribute("categorias", serviceVacante.budcarTodas());  comunes
     attribute.addFlashAttribute("msj","registro atualizado");
     return "vacantes/formVacante";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idvacante, Model model) {

        vacante vacante = serviceVacante.buscarPorId(idvacante);
        System.out.println("vacante" + vacante);
        model.addAttribute("vacante", vacante);
        return "detalle";

        //para enviar un input de tipo date y poder ricibir sin problema ese valor tipo date en el contraller
    }

    @InitBinder
    public void initaBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    // para agregar modelos que son muy comunes y siempre se necesita para no repetir codigo
    @ModelAttribute
    public void setGenericos (Model model){
       model.addAttribute("categorias", serviceVacante.budcarTodas());
    }

}
