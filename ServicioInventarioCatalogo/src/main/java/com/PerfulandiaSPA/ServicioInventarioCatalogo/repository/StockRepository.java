package com.PerfulandiaSPA.ServicioInventarioCatalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{
    
}