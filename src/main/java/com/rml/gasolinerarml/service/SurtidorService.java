/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.service;

/**
 *
 * @author raul
 */
import com.rml.gasolinerarml.model.Surtidor;
import com.rml.gasolinerarml.repository.ISurtidorRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurtidorService implements ISurtidorService {
   @Autowired
   private ISurtidorRepository repoSurtidor;

   public SurtidorService() {
   }

   public List<Surtidor> getSurtidores() {
      List<Surtidor> listaSurtidores = this.repoSurtidor.findAll();
      return listaSurtidores;
   }

   public void saveSurtidor(Surtidor surtidor) {
      this.repoSurtidor.save(surtidor);
   }

   public void deleteSurtidor(Long idSurtidor) {
      this.repoSurtidor.deleteById(idSurtidor);
   }

   public Surtidor findSurtidor(Long idSurtidor) {
      return (Surtidor)this.repoSurtidor.findById(idSurtidor).orElse((Object)null);
   }

   public void editSurtidor(Long idOriginal, String nuevoCodigo, LocalDate nuevaFechaInstalacion, boolean nuevoActivo) {
      Surtidor surtidor = this.findSurtidor(idOriginal);
      surtidor.setCodigo(nuevoCodigo);
      surtidor.setFechaInstalacion(nuevaFechaInstalacion);
      surtidor.setActivo(nuevoActivo);
      this.saveSurtidor(surtidor);
   }
}
