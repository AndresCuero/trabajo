
package com.oferta.trabajo.escurity;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {
    
    @Bean
    public UserDetailsManager usersCustom(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select username,password,estatus from Usuarios u where username=?");
        users.setAuthoritiesByUsernameQuery("select u.username,p.perfil from UsuarioPerfil up "
                + "inner join Usuarios u on u.id = up.idUsuario "
                + "inner join Perfiles p on p.id = up.idPerfil "
                + "where u.username=?");
        return users;
    }
    
     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                // Los recursos estáticos no requieren autenticación
                .requestMatchers("/bootstrap/**", "/images/**", "/tinymce/**", "/logos/**").permitAll()
                // Las vistas públicas no requieren autenticación
                .requestMatchers("/", "/signup", "/search", "/vacantes/view/**", "/r").permitAll()
                // Asignar permisos a URLs por ROLES
                .requestMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR","ADMINIDTRADOR")
                .requestMatchers("/categorias/**").hasAnyAuthority("ADMINIDTRADOR","SUPERVISOR")
                .requestMatchers("/usuario/**").hasAnyAuthority("ADMINIDTRADOR","SUPERVISOR")
                // Todas las demás URLs de la Aplicación requieren autenticación
                .anyRequest().authenticated()
                )
                .formLogin(login -> login
                // El formulario de Login no requiere autenticacion
                .permitAll()
                );
        return http.build();
    }


    
}
