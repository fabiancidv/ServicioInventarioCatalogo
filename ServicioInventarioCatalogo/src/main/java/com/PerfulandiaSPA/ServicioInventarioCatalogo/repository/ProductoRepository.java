package com.PerfulandiaSPA.ServicioInventarioCatalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
