package com.PerfulandiaSPA.ServicioInventarioCatalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.request.ReabastecimientoRequest;

@Repository
public interface ReabastecimientoRepository extends JpaRepository<ReabastecimientoRequest,Long>{
    
}
