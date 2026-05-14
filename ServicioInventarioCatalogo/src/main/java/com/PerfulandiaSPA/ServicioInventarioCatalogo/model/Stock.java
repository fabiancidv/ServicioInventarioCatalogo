package com.PerfulandiaSPA.ServicioInventarioCatalogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "producto_id", nullable = false)
    private Long productoId;

    @Min(value = 0, message = "La cantidad disponible no puede ser menor a cero")
    @Column(name = "cantidad_disponible", nullable = false)
    private int cantidadDisponible;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoStock estado;
}