/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.rml.gasolinerarml.service;

/**
 *
 * @author raul
 */
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.rml.gasolinerarml.model.Precio;
import com.rml.gasolinerarml.model.Producto;

public interface IPrecioService {
   List<Precio> getPrecios();

   void savePrecio(Precio precio);

   void deletePrecio(Long idPrecio);

   Precio findPrecio(Long idPrecio);

   void editPrecio(Long idOriginal, Producto nuevoProducto, LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, BigDecimal nuevoPrecioPorLitro);
}