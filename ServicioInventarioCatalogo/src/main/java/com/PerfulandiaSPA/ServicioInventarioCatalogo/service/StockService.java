package com.PerfulandiaSPA.ServicioInventarioCatalogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.EstadoStock;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Producto;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Stock;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.repository.StockRepository;

@Service
@Transactional
public class StockService {
    @Autowired
    StockRepository stockRepository;

    public Stock verificarStock(Long productoId){
        Stock producto = stockRepository.findById(productoId).orElse(null);
        if (producto.getCantidadDisponible() == 0){
            producto.setEstado(EstadoStock.AGOTADO);
        }
        else if (producto.getCantidadDisponible() >= 1 && producto.getCantidadDisponible() <= 10){
            producto.setEstado(EstadoStock.BAJA);
        }
        else {
            producto.setEstado(EstadoStock.DISPONIBLE);
        }
        return producto;
    }

    public Stock ajustarStock(Long productoId, int nuevaCantidad){
        Stock buscar = stockRepository.findById(productoId).orElse(null);
        if (buscar != null){
            buscar.setCantidadDisponible(nuevaCantidad);
            stockRepository.save(buscar);
            buscar = verificarStock(buscar.getId());
            return buscar;
        }
        return buscar;
    }

    public EstadoRespuesta autorizarReabastecimiento(Long pedidoId){
        return null;
    }
}
