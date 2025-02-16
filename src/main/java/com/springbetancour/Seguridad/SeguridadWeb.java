package com.springbetancour.Seguridad;

import com.springbetancour.Entidad.Usuario;
import com.springbetancour.Repositorio.UsuarioRepositorio;
import com.springbetancour.Servicios.UsuarioServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadWeb {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index", "/register", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/dashboard", "/propiedades/**", "/reservas/**", "/propietarios/**").authenticated() // Proteger todas las páginas privadas
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true) // Redirigir al dashboard si el login es exitoso
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // Redirigir al login tras cerrar sesión
                        .invalidateHttpSession(true) // Invalidar la sesión
                        .deleteCookies("JSESSIONID") // Eliminar cookies de autenticación
                        .permitAll()
                );

        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService(UsuarioRepositorio usuarioRepositorio) {
        return email -> {
            Usuario usuario = usuarioRepositorio.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

            return User.withUsername(usuario.getEmail())
                    .password(usuario.getPassword())
                    .roles("USER")
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
