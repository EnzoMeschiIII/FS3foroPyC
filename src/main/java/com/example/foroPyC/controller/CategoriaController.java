package com.example.foroPyC.controller;

import com.example.foroPyC.model.Categoria;
import com.example.foroPyC.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerTodasCategorias() {
        return categoriaService.obtenerTodasCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);
        return categoria.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.crearCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria categoriaActualizada = categoriaService.actualizarCategoria(id, categoria);
        return categoriaActualizada != null ? ResponseEntity.ok(categoriaActualizada) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        boolean eliminado = categoriaService.eliminarCategoria(id);
        return eliminado ? ResponseEntity.noContent().build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
