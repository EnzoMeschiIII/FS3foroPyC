package com.example.foroPyC.DTO;

// DTO solo con los campos necesarios de la entidad Usuario
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String email;

    // Constructor
    public UsuarioDTO(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
