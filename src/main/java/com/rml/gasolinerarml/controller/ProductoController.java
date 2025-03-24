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
@RestController
@RequestMapping({"/api"})
@CrossOrigin(
    origins = {"*"}
)
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    public ProductoController() {
    }

import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.service.IProductoService;

    @GetMapping({"/productos/traer"})
    public List<Producto> getProductos() {
        return this.productoService.getProductos();
    }

    @GetMapping({"/productos/traer/{id}"})
    public Producto getProducto(@PathVariable Long id) {
        return this.productoService.findProducto(id);
    }

    @PostMapping({"/productos/crear"})
    public String saveProducto(@RequestBody Producto producto) {
        this.productoService.saveProducto(producto);
        return "El producto fue creado correctamente";
    }

    @DeleteMapping({"/productos/borrar/{id}"})
    public String deleteProducto(@PathVariable Long id) {
        this.productoService.deleteProducto(id);
        return "El producto fue eliminado correctamente";
    }

    @PutMapping({"/productos/editar/{idOriginal}"})
    public Producto editProducto(@PathVariable Long idOriginal, @RequestParam(required = false,name = "nombre") String nuevoNombre, @RequestParam(required = false,name = "descripcion") String nuevaDescripcion, @RequestParam(required = false,name = "tipo") String nuevoTipo) {
        this.productoService.editProducto(idOriginal, nuevoNombre, nuevaDescripcion, nuevoTipo);
        return this.productoService.findProducto(idOriginal);
    }

    @PutMapping({"/productos/editar"})
    public Producto editProducto(@RequestBody Producto producto) {
        this.productoService.editProducto(producto.getIdProducto(), producto.getNombre(), producto.getDescripcion(), producto.getTipo());
        return this.productoService.findProducto(producto.getIdProducto());
    }
}
