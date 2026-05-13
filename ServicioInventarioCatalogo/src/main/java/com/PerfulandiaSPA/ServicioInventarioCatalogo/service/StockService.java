package com.PerfulandiaSPA.ServicioInventarioCatalogo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Producto;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.repository.StockRepository;

public class StockService {
    @Autowired
    StockRepository stockRepository;

    public List<Producto> buscarProductos(String busqueda){
        
    }

    public boolean verificarStock(Long productoId){

    }

    public void ajustarStock(Long productoId, int nuevaCantidad){
        
    }

    public EstadoRespuesta autorizarReabastecimiento(Long pedidoId){
        
    }
}
