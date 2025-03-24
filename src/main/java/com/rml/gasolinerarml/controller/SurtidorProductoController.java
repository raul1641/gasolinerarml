/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.controller;

/**
 *
 * @author raul
 */

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
public class SurtidorProductoController {
    @Autowired
    private ISurtidorProductoService surtidorProductoService;
    @Autowired
    private ISurtidorService surtidorService;
    @Autowired
    private IProductoService productoService;

    public SurtidorProductoController() {
    }


import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.model.Surtidor;
import com.rml.gasolinerarml.model.SurtidorProducto;
import com.rml.gasolinerarml.service.IProductoService;
import com.rml.gasolinerarml.service.ISurtidorProductoService;
import com.rml.gasolinerarml.service.ISurtidorService;
    @GetMapping({"/surtidor-productos/traer"})
    public List<SurtidorProducto> getSurtidorProductos() {
        return this.surtidorProductoService.getSurtidorProductos();
    }

    @GetMapping({"/surtidor-productos/traer/{id}"})
    public SurtidorProducto getSurtidorProducto(@PathVariable Long id) {
        return this.surtidorProductoService.findSurtidorProducto(id);
    }

    @PostMapping({"/surtidor-productos/crear"})
    public String saveSurtidorProducto(@RequestBody SurtidorProducto surtidorProducto) {
        this.surtidorProductoService.saveSurtidorProducto(surtidorProducto);
        return "La relación surtidor-producto fue creada correctamente";
    }

    @DeleteMapping({"/surtidor-productos/borrar/{id}"})
    public String deleteSurtidorProducto(@PathVariable Long id) {
        this.surtidorProductoService.deleteSurtidorProducto(id);
        return "La relación surtidor-producto fue eliminada correctamente";
    }

    @PutMapping({"/surtidor-productos/editar/{idOriginal}"})
    public SurtidorProducto editSurtidorProducto(@PathVariable Long idOriginal, @RequestParam(required = false,name = "idSurtidor") Long idSurtidor, @RequestParam(required = false,name = "idProducto") Long idProducto) {
        Surtidor surtidor = null;
        if (idSurtidor != null) {
            surtidor = this.surtidorService.findSurtidor(idSurtidor);
        }

        Producto producto = null;
        if (idProducto != null) {
            producto = this.productoService.findProducto(idProducto);
        }

        this.surtidorProductoService.editSurtidorProducto(idOriginal, surtidor, producto);
        return this.surtidorProductoService.findSurtidorProducto(idOriginal);
    }

    @PutMapping({"/surtidor-productos/editar"})
    public SurtidorProducto editSurtidorProducto(@RequestBody SurtidorProducto surtidorProducto) {
        this.surtidorProductoService.editSurtidorProducto(surtidorProducto.getIdSurtidorProducto(), surtidorProducto.getSurtidor(), surtidorProducto.getProducto());
        return this.surtidorProductoService.findSurtidorProducto(surtidorProducto.getIdSurtidorProducto());
    }
}
