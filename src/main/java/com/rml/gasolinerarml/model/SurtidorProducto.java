/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.model;

/**
 *
 * @author raul
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "surtidor_producto"
)
public class SurtidorProducto {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long idSurtidorProducto;
    @ManyToOne
    @JoinColumn(
        name = "id_surtidor",
        nullable = false
    )
    private Surtidor surtidor;
    @ManyToOne
    @JoinColumn(
        name = "id_producto",
        nullable = false
    )
    private Producto producto;

    public Long getIdSurtidorProducto() {
        return this.idSurtidorProducto;
    }

    public void setIdSurtidorProducto(Long idSurtidorProducto) {
        this.idSurtidorProducto = idSurtidorProducto;
    }

    public Surtidor getSurtidor() {
        return this.surtidor;
    }

    public void setSurtidor(Surtidor surtidor) {
        this.surtidor = surtidor;
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
        } else if (!(o instanceof SurtidorProducto)) {
            return false;
        } else {
            SurtidorProducto other = (SurtidorProducto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$idSurtidorProducto = this.getIdSurtidorProducto();
                    Object other$idSurtidorProducto = other.getIdSurtidorProducto();
                    if (this$idSurtidorProducto == null) {
                        if (other$idSurtidorProducto == null) {
                            break label47;
                        }
                    } else if (this$idSurtidorProducto.equals(other$idSurtidorProducto)) {
                        break label47;
                    }

                    return false;
                }

                Object this$surtidor = this.getSurtidor();
                Object other$surtidor = other.getSurtidor();
                if (this$surtidor == null) {
                    if (other$surtidor != null) {
                        return false;
                    }
                } else if (!this$surtidor.equals(other$surtidor)) {
                    return false;
                }

                Object this$producto = this.getProducto();
                Object other$producto = other.getProducto();
                if (this$producto == null) {
                    if (other$producto != null) {
                        return false;
                    }
                } else if (!this$producto.equals(other$producto)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SurtidorProducto;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $idSurtidorProducto = this.getIdSurtidorProducto();
        result = result * 59 + ($idSurtidorProducto == null ? 43 : $idSurtidorProducto.hashCode());
        Object $surtidor = this.getSurtidor();
        result = result * 59 + ($surtidor == null ? 43 : $surtidor.hashCode());
        Object $producto = this.getProducto();
        result = result * 59 + ($producto == null ? 43 : $producto.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getIdSurtidorProducto();
        return "SurtidorProducto(idSurtidorProducto=" + var10000 + ", surtidor=" + String.valueOf(this.getSurtidor()) + ", producto=" + String.valueOf(this.getProducto()) + ")";
    }

    public SurtidorProducto() {
    }

    public SurtidorProducto(final Long idSurtidorProducto, final Surtidor surtidor, final Producto producto) {
        this.idSurtidorProducto = idSurtidorProducto;
        this.surtidor = surtidor;
        this.producto = producto;
    }
}
