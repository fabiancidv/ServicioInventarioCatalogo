package com.PerfulandiaSPA.ServicioInventarioCatalogo.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Producto;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.model.Stock;
import com.PerfulandiaSPA.ServicioInventarioCatalogo.service.StockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("{id}")
    public ResponseEntity<?> getStockId(@PathVariable Long id){
        Stock stockId = stockService.conseguirIdStock(id);
        if (stockId != null) {
            return ResponseEntity.ok(stockId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id no encontrado");
    }

    @GetMapping("verificar/{id}")
    public ResponseEntity<?> getVerificar(@PathVariable Long id){
        Stock producto = stockService.verificarStock(id);
        if (producto != null){
            return ResponseEntity.ok(producto.getEstado());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id no encontrado");
    }

    @PutMapping("{id}/ajustar/{cantidad}")
    public ResponseEntity<?> putAjustarStock(@PathVariable Long id, @PathVariable int cantidad){
        Stock stockActualizado = stockService.ajustarStock(id, cantidad);
        if (stockActualizado != null){
            return ResponseEntity.ok(stockActualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    
}
