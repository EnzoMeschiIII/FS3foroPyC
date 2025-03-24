package com.example.foroPyC.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    // Constructor privado para el Builder
    private Categoria(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
    }

    // Método estático para iniciar la construcción
    public static Builder builder() {
        return new Builder();
    }

    // Clase estática Builder
    public static class Builder {
        private Long id;
        private String nombre;
        private String descripcion;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Categoria build() {
            return new Categoria(this);
        }
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
