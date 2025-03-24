/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.rml.gasolinerarml.service;

/**
 *
 * @author raul
 */
import java.util.List;

import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.model.Surtidor;
import com.rml.gasolinerarml.model.SurtidorProducto;

public interface ISurtidorProductoService {
   List<SurtidorProducto> getSurtidorProductos();

   void saveSurtidorProducto(SurtidorProducto surtidorProducto);

   void deleteSurtidorProducto(Long idSurtidorProducto);

   SurtidorProducto findSurtidorProducto(Long idSurtidorProducto);

   void editSurtidorProducto(Long idOriginal, Surtidor nuevoSurtidor, Producto nuevoProducto);
}
