package com.PerfulandiaSPA.ServicioInventarioCatalogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "No puede ingresar un producto sin nombre")
    @Size(min = 2, max = 1000, message = "Debe poner un nombre de entre 2 a 1000 caracteres")
    @Column(nullable = false)
    private String nombre;

    @Min(value = 0, message = "El valor no puede ser menor a cero")
    @Column(nullable = false)
    private double precio;

    @NotBlank(message = "No puede ingresar un producto sin categoria")
    @Size(min = 2, max = 100, message = "Debe poner una categoria de entre 2 a 1000 caracteres")
    @Column(nullable = false)
    private String categoria;

    @NotBlank(message = "No puede ingresar un producto sin descripcion")
    @Size(min = 2, max = 10000, message = "Debe ingresar una descripcion de entre 2 a 10.000 caracteres")
    @Column(nullable = false)
    private String descripcion;
}