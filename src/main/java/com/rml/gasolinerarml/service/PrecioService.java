/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.service;

/**
 *
 * @author raul
 */
import com.rml.gasolinerarml.model.Precio;
import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.repository.IPrecioRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecioService implements IPrecioService {
   @Autowired
   private IPrecioRepository repoPrecio;

   public PrecioService() {
   }

   public List<Precio> getPrecios() {
      List<Precio> listaPrecios = this.repoPrecio.findAll();
      return listaPrecios;
   }

   public void savePrecio(Precio precio) {
      this.repoPrecio.save(precio);
   }

   public void deletePrecio(Long idPrecio) {
      this.repoPrecio.deleteById(idPrecio);
   }

   public Precio findPrecio(Long idPrecio) {
      return (Precio)this.repoPrecio.findById(idPrecio).orElse((Object)null);
   }

   public void editPrecio(Long idOriginal, Producto nuevoProducto, LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, BigDecimal nuevoPrecioPorLitro) {
      Precio precio = this.findPrecio(idOriginal);
      precio.setProducto(nuevoProducto);
      precio.setFechaInicio(nuevaFechaInicio);
      precio.setFechaFin(nuevaFechaFin);
      precio.setPrecioPorLitro(nuevoPrecioPorLitro);
      this.savePrecio(precio);
   }
}