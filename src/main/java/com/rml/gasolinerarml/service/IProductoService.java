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

public interface IProductoService {
   List<Producto> getProductos();

   void saveProducto(Producto producto);

   void deleteProducto(Long idProducto);

   Producto findProducto(Long idProducto);

   void editProducto(Long idOriginal, String nuevoNombre, String nuevaDescripcion, String nuevoTipo);
}
