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
import com.rml.gasolinerarml.model.Tanque;

public interface ITanqueService {
   List<Tanque> getTanques();

   void saveTanque(Tanque tanque);

   void deleteTanque(Long idTanque);

   Tanque findTanque(Long idTanque);

   void editTanque(Long idOriginal, String nuevoCodigo, Integer nuevaCapacidadMaxima, Integer nuevoNivelActual, Producto nuevoProducto);
}