/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.rml.gasolinerarml.service;

/**
 *
 * @author raul
 */
import java.time.LocalDate;
import java.util.List;

import com.rml.gasolinerarml.model.Surtidor;

public interface ISurtidorService {
   List<Surtidor> getSurtidores();

   void saveSurtidor(Surtidor surtidor);

   void deleteSurtidor(Long idSurtidor);

   Surtidor findSurtidor(Long idSurtidor);

   void editSurtidor(Long idOriginal, String nuevoCodigo, LocalDate nuevaFechaInstalacion, boolean nuevoActivo);
}
