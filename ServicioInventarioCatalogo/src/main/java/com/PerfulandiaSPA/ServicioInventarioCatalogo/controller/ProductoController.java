package com.PerfulandiaSPA.ServicioInventarioCatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Producto;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    ResponseEntity<?> postProducto(@Valid @RequestBody Producto producto){
        return ResponseEntity.ok(producto);
    }

    @PutMapping("{id}")
    ResponseEntity<?> putProducto(@Valid @RequestBody Producto producto, @PathVariable Long id){
        producto = productoService.actualizarProducto(id, producto);
        if (producto!=null)
            return ResponseEntity.ok(producto);
        return ResponseEntity.badRequest().body("No se han ingresado datos de forma correcta");
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.ok("Producto borrado");
    }
}
