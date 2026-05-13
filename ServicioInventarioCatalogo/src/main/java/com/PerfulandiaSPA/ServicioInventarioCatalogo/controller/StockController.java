package com.PerfulandiaSPA.ServicioInventarioCatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PerfulandiaSPA.ServicioInventarioCatalogo.service.StockService;

@RestController
@RequestMapping("api/v1/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    
}
