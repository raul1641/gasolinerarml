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
 import java.time.LocalDateTime;
 import java.time.format.DateTimeFormatter;
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
public class SuministroController {
    @Autowired
    private ISuministroService suministroService;
    @Autowired
    private ISurtidorService surtidorService;
    @Autowired
    private IProductoService productoService;

    public SuministroController() {

import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.model.Suministro;
import com.rml.gasolinerarml.model.Surtidor;
import com.rml.gasolinerarml.service.IProductoService;
import com.rml.gasolinerarml.service.ISuministroService;
import com.rml.gasolinerarml.service.ISurtidorService;
    }

    @GetMapping({"/suministros/traer"})
    public List<Suministro> getSuministros() {
        return this.suministroService.getSuministros();
    }

    @GetMapping({"/suministros/traer/{id}"})
    public Suministro getSuministro(@PathVariable Long id) {
        return this.suministroService.findSuministro(id);
    }

    @PostMapping({"/suministros/crear"})
    public String saveSuministro(@RequestBody Suministro suministro) {
        this.suministroService.saveSuministro(suministro);
        return "El suministro fue creado correctamente";
    }

    @DeleteMapping({"/suministros/borrar/{id}"})
    public String deleteSuministro(@PathVariable Long id) {
        this.suministroService.deleteSuministro(id);
        return "El suministro fue eliminado correctamente";
    }

    @PutMapping({"/suministros/editar/{idOriginal}"})
    public Suministro editSuministro(@PathVariable Long idOriginal, @RequestParam(required = false,name = "idSurtidor") Long idSurtidor, @RequestParam(required = false,name = "idProducto") Long idProducto, @RequestParam(required = false,name = "fechaHora") String fechaHora, @RequestParam(required = false,name = "volumenLitros") BigDecimal volumenLitros, @RequestParam(required = false,name = "importeEuros") BigDecimal importeEuros) {
        Surtidor surtidor = null;
        if (idSurtidor != null) {
            surtidor = this.surtidorService.findSurtidor(idSurtidor);
        }

        Producto producto = null;
        if (idProducto != null) {
            producto = this.productoService.findProducto(idProducto);
        }

        LocalDateTime fechaHoraDateTime = null;
        if (fechaHora != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            fechaHoraDateTime = LocalDateTime.parse(fechaHora, formatter);
        }

        this.suministroService.editSuministro(idOriginal, surtidor, producto, fechaHoraDateTime, volumenLitros, importeEuros);
        return this.suministroService.findSuministro(idOriginal);
    }

    @PutMapping({"/suministros/editar"})
    public Suministro editSuministro(@RequestBody Suministro suministro) {
        this.suministroService.editSuministro(suministro.getIdSuministro(), suministro.getSurtidor(), suministro.getProducto(), suministro.getFechaHora(), suministro.getVolumenLitros(), suministro.getImporteEuros());
        return this.suministroService.findSuministro(suministro.getIdSuministro());
    }
}
