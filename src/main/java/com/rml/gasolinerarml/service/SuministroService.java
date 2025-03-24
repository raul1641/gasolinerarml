/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.service;

/**
 *
 * @author raul
 */
import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.Suministro;
import com.rml.gasolinerarml.model.Surtidor;
import com.rml.gasolinerarml.repository.ISuministroRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuministroService implements ISuministroService {
   @Autowired
   private ISuministroRepository repoSuministro;

   public SuministroService() {
   }

   public List<Suministro> getSuministros() {
      List<Suministro> listaSuministros = this.repoSuministro.findAll();
      return listaSuministros;
   }

   public void saveSuministro(Suministro suministro) {
      this.repoSuministro.save(suministro);
   }

   public void deleteSuministro(Long idSuministro) {
      this.repoSuministro.deleteById(idSuministro);
   }

   public Suministro findSuministro(Long idSuministro) {
      return (Suministro)this.repoSuministro.findById(idSuministro).orElse((Object)null);
   }

   public void editSuministro(Long idOriginal, Surtidor nuevoSurtidor, Producto nuevoProducto, LocalDateTime nuevaFechaHora, BigDecimal nuevoVolumenLitros, BigDecimal nuevoImporteEuros) {
      Suministro suministro = this.findSuministro(idOriginal);
      suministro.setSurtidor(nuevoSurtidor);
      suministro.setProducto(nuevoProducto);
      suministro.setFechaHora(nuevaFechaHora);
      suministro.setVolumenLitros(nuevoVolumenLitros);
      suministro.setImporteEuros(nuevoImporteEuros);
      this.saveSuministro(suministro);
   }
}
