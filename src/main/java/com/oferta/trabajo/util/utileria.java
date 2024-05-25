package com.oferta.trabajo.util;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;


public class utileria {

    

        public static String guardarArchivo(MultipartFile multiPart, String ruta) {
// Obtenemos el nombre original del archivo.
            String nombreOriginal = multiPart.getOriginalFilename();
        nombreOriginal = nombreOriginal.replace(" ", "-"); 
       String nombreFinal = numerosRandom(8) + nombreOriginal;

           

            try {
// Formamos el nombre del archivo para guardarlo en el disco duro.
                File imageFile = new File(ruta + nombreFinal);
                System.out.println("Archivo: " + imageFile.getAbsolutePath());
//Guardamos fisicamente el archivo en HD.
                multiPart.transferTo(imageFile);
                return nombreOriginal;
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
                return null;
            }
        }
        
        static String numerosRandom(int count){
        
            String carateres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
            
            StringBuilder bulider = new StringBuilder();
            
            while(count-- != 0){
                int charater = (int)(Math.random()*carateres.length());
                bulider.append(carateres.charAt(charater));
            }
            return bulider.toString();
        }
    }


