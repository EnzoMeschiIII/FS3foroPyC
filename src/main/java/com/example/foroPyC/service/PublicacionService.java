package com.example.foroPyC.service;

import com.example.foroPyC.model.Publicacion;
import com.example.foroPyC.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    public List<Publicacion> obtenerTodasPublicaciones() {
        return publicacionRepository.findAll();
    }

    public Optional<Publicacion> obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id);
    }

    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public Publicacion actualizarPublicacion(Long id, Publicacion publicacion) {
        if (publicacionRepository.existsById(id)) {
            // Obtener la publicación existente
            Publicacion publicacionExistente = publicacionRepository.findById(id).orElse(null);
    
            if (publicacionExistente != null) {
                // Crear una nueva instancia de Publicacion con el Builder
                Publicacion nuevaPublicacion = Publicacion.builder()
                        .id(publicacionExistente.getId())  // Mantener el mismo ID
                        .titulo(publicacion.getTitulo())  // Actualizar el título
                        .contenido(publicacion.getContenido())  // Actualizar contenido
                        .fechaPublicacion(publicacion.getFechaPublicacion())  // Actualizar fecha
                        .categoria(publicacion.getCategoria())  // Actualizar categoría
                        .idUsuario(publicacion.getIdUsuario())  // Actualizar idUsuario
                        .build();
    
                // Guarda la publicación actualizada
                return publicacionRepository.save(nuevaPublicacion);
            }
        }
        return null;
    }
    
    

    public boolean eliminarPublicacion(Long id) {
        if (publicacionRepository.existsById(id)) {
            publicacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
