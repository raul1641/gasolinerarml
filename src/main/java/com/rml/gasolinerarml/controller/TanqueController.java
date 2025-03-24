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
public class TanqueController {
    @Autowired
    private ITanqueService tanqueService;
    @Autowired
    private IProductoService productoService;


import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.model.Tanque;
import com.rml.gasolinerarml.service.IProductoService;
import com.rml.gasolinerarml.service.ITanqueService;
    public TanqueController() {
    }

    @GetMapping({"/tanques/traer"})
    public List<Tanque> getTanques() {
        return this.tanqueService.getTanques();
    }

    @GetMapping({"/tanques/traer/{id}"})
    public Tanque getTanque(@PathVariable Long id) {
        return this.tanqueService.findTanque(id);
    }

    @PostMapping({"/tanques/crear"})
    public String saveTanque(@RequestBody Tanque tanque) {
        this.tanqueService.saveTanque(tanque);
        return "El tanque fue creado correctamente";
    }

    @DeleteMapping({"/tanques/borrar/{id}"})
    public String deleteTanque(@PathVariable Long id) {
        this.tanqueService.deleteTanque(id);
        return "El tanque fue eliminado correctamente";
    }

    @PutMapping({"/tanques/editar/{idOriginal}"})
    public Tanque editTanque(@PathVariable Long idOriginal, @RequestParam(required = false,name = "codigo") String nuevoCodigo, @RequestParam(required = false,name = "capacidadMaxima") Integer nuevaCapacidadMaxima, @RequestParam(required = false,name = "nivelActual") Integer nuevoNivelActual, @RequestParam(required = false,name = "idProducto") Long idProducto) {
        Producto producto = null;
        if (idProducto != null) {
            producto = this.productoService.findProducto(idProducto);
        }

        Tanque t = this.tanqueService.findTanque(idOriginal);
        if (nuevoCodigo == null) {
            nuevoCodigo = t.getCodigo();
        }

        if (nuevaCapacidadMaxima == null) {
            nuevaCapacidadMaxima = t.getCapacidadMaxima();
        }

        if (nuevoNivelActual == null) {
            nuevoNivelActual = t.getNivelActual();
        }

        if (producto == null) {
            producto = t.getProducto();
        }

        this.tanqueService.editTanque(idOriginal, nuevoCodigo, nuevaCapacidadMaxima, nuevoNivelActual, producto);
        return this.tanqueService.findTanque(idOriginal);
    }

    @PutMapping({"/tanques/editar"})
    public Tanque editTanque(@RequestBody Tanque tanque) {
        this.tanqueService.editTanque(tanque.getIdTanque(), tanque.getCodigo(), tanque.getCapacidadMaxima(), tanque.getNivelActual(), tanque.getProducto());
        return this.tanqueService.findTanque(tanque.getIdTanque());
    }
}
