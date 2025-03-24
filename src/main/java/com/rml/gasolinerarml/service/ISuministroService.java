/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.rml.gasolinerarml.service;

/**
 *
 * @author raul
 */
import com.rml.gasolinerarml.model.Producto;
import com.rml.gasolinerarml.Suministro;
import com.rml.gasolinerarml.model.Surtidor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ISuministroService {
   List<Suministro> getSuministros();

   void saveSuministro(Suministro suministro);

   void deleteSuministro(Long idSuministro);

   Suministro findSuministro(Long idSuministro);

   void editSuministro(Long idOriginal, Surtidor nuevoSurtidor, Producto nuevoProducto, LocalDateTime nuevaFechaHora, BigDecimal nuevoVolumenLitros, BigDecimal nuevoImporteEuros);
}
