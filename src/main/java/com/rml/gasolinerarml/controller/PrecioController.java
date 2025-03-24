/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.controller;

/**
 *
 * @author raul
 */


 
 import java.math.BigDecimal;
 import java.time.LocalDate;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.DeleteMapping;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping({"/api"})
@CrossOrigin(
    origins = {"*"}
)
public class PrecioController {
    @Autowired
    private IPrecioService precioService;
    @Autowired
    private IProductoService productoService;

    public PrecioController() {
    }

import com.rml.gasolinerarml.model.Precio;
import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.service.IPrecioService;
import com.rml.gasolinerarml.service.IProductoService;

    @GetMapping({"/precios/traer"})
    public List<Precio> getPrecios() {
        return this.precioService.getPrecios();
    }

    @GetMapping({"/precios/traer/{id}"})
    public Precio getPrecio(@PathVariable Long id) {
        return this.precioService.findPrecio(id);
    }

    @PostMapping({"/precios/crear"})
    public String savePrecio(@RequestBody Precio precio) {
        this.precioService.savePrecio(precio);
        return "El precio fue creado correctamente";
    }

    @DeleteMapping({"/precios/borrar/{id}"})
    public String deletePrecio(@PathVariable Long id) {
        this.precioService.deletePrecio(id);
        return "El precio fue eliminado correctamente";
    }

    @PutMapping({"/precios/editar/{idOriginal}"})
    public Precio editPrecio(@PathVariable Long idOriginal, @RequestParam(required = false,name = "idProducto") Long idProducto, @RequestParam(required = false,name = "fechaInicio") String fechaInicio, @RequestParam(required = false,name = "fechaFin") String fechaFin, @RequestParam(required = false,name = "precioPorLitro") BigDecimal precioPorLitro) {
        Precio p = null;
        p = this.precioService.findPrecio(idOriginal);
        Producto producto = null;
        if (idProducto != null) {
            producto = this.productoService.findProducto(idProducto);
        } else {
            producto = p.getProducto();
        }

        LocalDate fechaInicioDate = fechaInicio != null ? LocalDate.parse(fechaInicio) : p.getFechaInicio();
        LocalDate fechaFinDate = fechaFin != null ? LocalDate.parse(fechaFin) : p.getFechaFin();
        this.precioService.editPrecio(idOriginal, producto, fechaInicioDate, fechaFinDate, precioPorLitro);
        return this.precioService.findPrecio(idOriginal);
    }

    @PutMapping({"/precios/editar"})
    public Precio editPrecio(@RequestBody Precio precio) {
        Precio precioOriginal = this.precioService.findPrecio(precio.getIdPrecio());
        this.precioService.editPrecio(precioOriginal.getIdPrecio(), precio.getProducto(), precio.getFechaInicio(), precio.getFechaFin(), precio.getPrecioPorLitro());
        return this.precioService.findPrecio(precio.getIdPrecio());
    }
}
