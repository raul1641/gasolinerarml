/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.model;

/**
 *
 * @author raul
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "tanques"
)
public class Tanque {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long idTanque;
    @Column(
        nullable = true,
        unique = true
    )
    private String codigo;
    @Column(
        name = "capacidad_maxima",
        nullable = false
    )
    private Integer capacidadMaxima;
    @Column(
        name = "nivel_actual",
        nullable = false
    )
    private Integer nivelActual;
    @ManyToOne
    @JoinColumn(
        name = "id_producto",
        nullable = false
    )
    private Producto producto;

    public Long getIdTanque() {
        return this.idTanque;
    }

    public void setIdTanque(Long idTanque) {
        this.idTanque = idTanque;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCapacidadMaxima() {
        return this.capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Integer getNivelActual() {
        return this.nivelActual;
    }

    public void setNivelActual(Integer nivelActual) {
        this.nivelActual = nivelActual;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Tanque)) {
            return false;
        } else {
            Tanque other = (Tanque)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$idTanque = this.getIdTanque();
                    Object other$idTanque = other.getIdTanque();
                    if (this$idTanque == null) {
                        if (other$idTanque == null) {
                            break label71;
                        }
                    } else if (this$idTanque.equals(other$idTanque)) {
                        break label71;
                    }

                    return false;
                }

                Object this$capacidadMaxima = this.getCapacidadMaxima();
                Object other$capacidadMaxima = other.getCapacidadMaxima();
                if (this$capacidadMaxima == null) {
                    if (other$capacidadMaxima != null) {
                        return false;
                    }
                } else if (!this$capacidadMaxima.equals(other$capacidadMaxima)) {
                    return false;
                }

                label57: {
                    Object this$nivelActual = this.getNivelActual();
                    Object other$nivelActual = other.getNivelActual();
                    if (this$nivelActual == null) {
                        if (other$nivelActual == null) {
                            break label57;
                        }
                    } else if (this$nivelActual.equals(other$nivelActual)) {
                        break label57;
                    }

                    return false;
                }

                Object this$codigo = this.getCodigo();
                Object other$codigo = other.getCodigo();
                if (this$codigo == null) {
                    if (other$codigo != null) {
                        return false;
                    }
                } else if (!this$codigo.equals(other$codigo)) {
                    return false;
                }

                Object this$producto = this.getProducto();
                Object other$producto = other.getProducto();
                if (this$producto == null) {
                    if (other$producto == null) {
                        return true;
                    }
                } else if (this$producto.equals(other$producto)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Tanque;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $idTanque = this.getIdTanque();
        result = result * 59 + ($idTanque == null ? 43 : $idTanque.hashCode());
        Object $capacidadMaxima = this.getCapacidadMaxima();
        result = result * 59 + ($capacidadMaxima == null ? 43 : $capacidadMaxima.hashCode());
        Object $nivelActual = this.getNivelActual();
        result = result * 59 + ($nivelActual == null ? 43 : $nivelActual.hashCode());
        Object $codigo = this.getCodigo();
        result = result * 59 + ($codigo == null ? 43 : $codigo.hashCode());
        Object $producto = this.getProducto();
        result = result * 59 + ($producto == null ? 43 : $producto.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getIdTanque();
        return "Tanque(idTanque=" + var10000 + ", codigo=" + this.getCodigo() + ", capacidadMaxima=" + this.getCapacidadMaxima() + ", nivelActual=" + this.getNivelActual() + ", producto=" + String.valueOf(this.getProducto()) + ")";
    }

    public Tanque() {
    }

    public Tanque(final Long idTanque, final String codigo, final Integer capacidadMaxima, final Integer nivelActual, final Producto producto) {
        this.idTanque = idTanque;
        this.codigo = codigo;
        this.capacidadMaxima = capacidadMaxima;
        this.nivelActual = nivelActual;
        this.producto = producto;
    }
}
