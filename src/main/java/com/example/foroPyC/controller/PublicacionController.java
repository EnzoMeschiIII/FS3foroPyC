package com.example.foroPyC.controller;

import com.example.foroPyC.model.Publicacion;
import com.example.foroPyC.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public List<Publicacion> obtenerTodasPublicaciones() {
        return publicacionService.obtenerTodasPublicaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable Long id) {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        return publicacion.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        Publicacion nuevaPublicacion = publicacionService.crearPublicacion(publicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPublicacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        Publicacion publicacionActualizada = publicacionService.actualizarPublicacion(id, publicacion);
        return publicacionActualizada != null ? ResponseEntity.ok(publicacionActualizada) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        boolean eliminado = publicacionService.eliminarPublicacion(id);
        return eliminado ? ResponseEntity.noContent().build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
