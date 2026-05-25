package com.PerfulandiaSPA.ServicioInventarioCatalogo.request;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.service.EstadoRespuesta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reabastecimiento_request")
public class ReabastecimientoRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_stock", nullable = false)
    private Long stockId;

    @Column(nullable = false)
    private int cantidad;

    @Enumerated(EnumType.STRING)
    private EstadoRespuesta respuesta;
}
