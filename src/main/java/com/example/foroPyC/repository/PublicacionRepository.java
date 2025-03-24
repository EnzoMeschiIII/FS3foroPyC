package com.example.foroPyC.repository;

import com.example.foroPyC.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    // Agregar consultas personalizadas si las necesitas
    // Ejemplo: List<Publicacion> findByUsuario(Usuario usuario);
}
