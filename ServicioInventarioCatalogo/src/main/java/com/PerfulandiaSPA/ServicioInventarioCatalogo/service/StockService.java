package com.PerfulandiaSPA.ServicioInventarioCatalogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Producto;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.repository.StockRepository;

public class StockService {
    @Autowired
    StockRepository stockRepository;

    public boolean verificarStock(Long productoId){
        
    }

    public void ajustarStock(Long productoId, int nuevaCantidad){
        
    }

    public EstadoRespuesta autorizarReabastecimiento(Long pedidoId){
        
    }
}
