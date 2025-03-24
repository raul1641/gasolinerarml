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
import com.rml.gasolinerarml.model.Surtidor;
import com.rml.gasolinerarml.model.SurtidorProducto;
import com.rml.gasolinerarml.repository.ISurtidorProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurtidorProductoService implements ISurtidorProductoService {
   @Autowired
   private ISurtidorProductoRepository repoSurtidorProducto;

   public SurtidorProductoService() {
   }

   public List<SurtidorProducto> getSurtidorProductos() {
      List<SurtidorProducto> listaSurtidorProductos = this.repoSurtidorProducto.findAll();
      return listaSurtidorProductos;
   }

   public void saveSurtidorProducto(SurtidorProducto surtidorProducto) {
      this.repoSurtidorProducto.save(surtidorProducto);
   }

   public void deleteSurtidorProducto(Long idSurtidorProducto) {
      this.repoSurtidorProducto.deleteById(idSurtidorProducto);
   }

   public SurtidorProducto findSurtidorProducto(Long idSurtidorProducto) {
      return (SurtidorProducto)this.repoSurtidorProducto.findById(idSurtidorProducto).orElse((Object)null);
   }

   public void editSurtidorProducto(Long idOriginal, Surtidor nuevoSurtidor, Producto nuevoProducto) {
      SurtidorProducto surtidorProducto = this.findSurtidorProducto(idOriginal);
      surtidorProducto.setSurtidor(nuevoSurtidor);
      surtidorProducto.setProducto(nuevoProducto);
      this.saveSurtidorProducto(surtidorProducto);
   }
}
