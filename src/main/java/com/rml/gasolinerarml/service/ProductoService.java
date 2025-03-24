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
import com.rml.gasolinerarml.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
   @Autowired
   private IProductoRepository repoProducto;

   public ProductoService() {
   }

   public List<Producto> getProductos() {
      List<Producto> listaProductos = this.repoProducto.findAll();
      return listaProductos;
   }

   public void saveProducto(Producto producto) {
      this.repoProducto.save(producto);
   }

   public void deleteProducto(Long idProducto) {
      this.repoProducto.deleteById(idProducto);
   }

   public Producto findProducto(Long idProducto) {
      return (Producto)this.repoProducto.findById(idProducto).orElse((Object)null);
   }

   public void editProducto(Long idOriginal, String nuevoNombre, String nuevaDescripcion, String nuevoTipo) {
      Producto producto = this.findProducto(idOriginal);
      producto.setNombre(nuevoNombre);
      producto.setDescripcion(nuevaDescripcion);
      producto.setTipo(nuevoTipo);
      this.saveProducto(producto);
   }
}
