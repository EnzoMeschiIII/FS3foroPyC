package com.example.foroPyC.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Publicaciones")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacion")
    private Long id;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "contenido", nullable = false, columnDefinition = "CLOB")
    private String contenido;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDateTime fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private Categoria categoria;

    // Aquí ya no usas Usuario directamente, sino UsuarioDTO
    private Long idUsuario;

    // Constructor privado para el Builder
    private Publicacion(Builder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.contenido = builder.contenido;
        this.fechaPublicacion = builder.fechaPublicacion;
        this.categoria = builder.categoria;
        this.idUsuario = builder.idUsuario;
    }

    // Método estático para iniciar la construcción
    public static Builder builder() {
        return new Builder();
    }

    // Clase estática Builder
    public static class Builder {
        private Long id;
        private String titulo;
        private String contenido;
        private LocalDateTime fechaPublicacion;
        private Categoria categoria;
        private Long idUsuario;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder contenido(String contenido) {
            this.contenido = contenido;
            return this;
        }

        public Builder fechaPublicacion(LocalDateTime fechaPublicacion) {
            this.fechaPublicacion = fechaPublicacion;
            return this;
        }

        public Builder categoria(Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder idUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Publicacion build() {
            return new Publicacion(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
}
