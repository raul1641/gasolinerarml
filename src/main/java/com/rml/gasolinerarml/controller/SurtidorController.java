/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.controller;

/**
 *
 * @author raul
 */


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
public class SurtidorController {
    @Autowired
    private ISurtidorService surtidorService;

    public SurtidorController() {
    }


import com.rml.gasolinerarml.model.Surtidor;
import com.rml.gasolinerarml.service.ISurtidorService;
    @GetMapping({"/surtidores/traer"})
    public List<Surtidor> getSurtidores() {
        return this.surtidorService.getSurtidores();
    }

    @GetMapping({"/surtidores/traer/{id}"})
    public Surtidor getSurtidor(@PathVariable Long id) {
        return this.surtidorService.findSurtidor(id);
    }

    @PostMapping({"/surtidores/crear"})
    public String saveSurtidor(@RequestBody Surtidor surtidor) {
        this.surtidorService.saveSurtidor(surtidor);
        return "El surtidor fue creado correctamente";
    }

    @DeleteMapping({"/surtidores/borrar/{id}"})
    public String deleteSurtidor(@PathVariable Long id) {
        this.surtidorService.deleteSurtidor(id);
        return "El surtidor fue eliminado correctamente";
    }

    @PutMapping({"/surtidores/editar/{idOriginal}"})
    public Surtidor editSurtidor(@PathVariable Long idOriginal, @RequestParam(required = false,name = "codigo") String nuevoCodigo, @RequestParam(required = false,name = "fechaInstalacion") String nuevaFechaInstalacion, @RequestParam(required = false,name = "activo") Boolean nuevoActivo) {
        LocalDate fechaInstalacionDate = nuevaFechaInstalacion != null ? LocalDate.parse(nuevaFechaInstalacion) : null;
        this.surtidorService.editSurtidor(idOriginal, nuevoCodigo, fechaInstalacionDate, nuevoActivo != null ? nuevoActivo : false);
        return this.surtidorService.findSurtidor(idOriginal);
    }

    @PutMapping({"/surtidores/editar"})
    public Surtidor editSurtidor(@RequestBody Surtidor surtidor) {
        this.surtidorService.editSurtidor(surtidor.getIdSurtidor(), surtidor.getCodigo(), surtidor.getFechaInstalacion(), surtidor.isActivo());
        return this.surtidorService.findSurtidor(surtidor.getIdSurtidor());
    }
}
