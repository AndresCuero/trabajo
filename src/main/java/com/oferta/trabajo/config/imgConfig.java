
package com.oferta.trabajo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class imgConfig implements WebMvcConfigurer {
    
    @Value("${trabajoapp.ruta.imagen}")
    private String rutaImagen;
 
    public void addResourceHandlers(ResourceHandlerRegistry  registry) {
        //registry.addResourceHandler("/logos/**").addResourceLocations("file:C:/empleos/img-vacantes/");
        registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImagen); 
    }
    
}
