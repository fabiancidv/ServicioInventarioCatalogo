package com.PerfulandiaSPA.ServicioInventarioCatalogo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Producto;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.repository.ProductoRepository;

public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public Producto agregarProducto(Producto nuevoProducto){
        return productoRepository.save(nuevoProducto);
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
