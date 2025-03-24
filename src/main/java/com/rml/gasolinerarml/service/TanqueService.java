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
import com.rml.gasolinerarml.model.Tanque;
import com.rml.gasolinerarml.repository.ITanqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TanqueService implements ITanqueService {
   @Autowired
   private ITanqueRepository repoTanque;

   public TanqueService() {
   }

   public List<Tanque> getTanques() {
      List<Tanque> listaTanques = this.repoTanque.findAll();
      return listaTanques;
   }

   public void saveTanque(Tanque tanque) {
      this.repoTanque.save(tanque);
   }

   public void deleteTanque(Long idTanque) {
      this.repoTanque.deleteById(idTanque);
   }

   public Tanque findTanque(Long idTanque) {
      return (Tanque)this.repoTanque.findById(idTanque).orElse((Object)null);
   }

   public void editTanque(Long idOriginal, String nuevoCodigo, Integer nuevaCapacidadMaxima, Integer nuevoNivelActual, Producto nuevoProducto) {
      Tanque tanque = this.findTanque(idOriginal);
      tanque.setCodigo(nuevoCodigo);
      tanque.setCapacidadMaxima(nuevaCapacidadMaxima);
      tanque.setNivelActual(nuevoNivelActual);
      tanque.setProducto(nuevoProducto);
      this.saveTanque(tanque);
   }
}