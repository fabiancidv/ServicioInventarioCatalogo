package com.PerfulandiaSPA.ServicioInventarioCatalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.EstadoStock;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Producto;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Stock;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.repository.ProductoRepository;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.repository.StockRepository;

@Service
@Transactional
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    StockRepository stockRepository;

    public Producto agregarProducto(Producto producto){
        Producto nuevoProducto = productoRepository.save(producto);

        Stock nuevoStock = new Stock();
        nuevoStock.setProductoId(nuevoProducto.getId());
        nuevoStock.setCantidadDisponible(0);
        nuevoStock.setEstado(EstadoStock.AGOTADO);
        stockRepository.save(nuevoStock);

        return nuevoProducto;
    }

    public List<Producto> buscarProductos(String busqueda){
        return productoRepository.findByNombreContainingIgnoreCase(busqueda);
    }

    public Producto actualizarProducto(Long id, Producto productoActualizado){
        Producto p = productoRepository.findById(id).orElse(null);
        if (p!=null) {
            p.setNombre(productoActualizado.getNombre());
            p.setPrecio(productoActualizado.getPrecio());
            p.setCategoria(productoActualizado.getCategoria());
            p.setDescripcion(productoActualizado.getDescripcion());
        }
        return p;
    }

    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }
}
