/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.rml.gasolinerarml.repository;

/**
 *
 * @author raul
 */
import com.rml.gasolinerarml.model.SurtidorProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurtidorProductoRepository extends JpaRepository<SurtidorProducto, Long> {
}
