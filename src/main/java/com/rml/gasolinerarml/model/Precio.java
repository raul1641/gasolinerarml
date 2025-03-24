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
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
    name = "precios"
)
public class Precio {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long idPrecio;
    @ManyToOne
    @JoinColumn(
        name = "id_producto",
        nullable = false
    )
    private Producto producto;
    @Column(
        name = "fecha_inicio",
        nullable = false
    )
    private LocalDate fechaInicio;
    @Column(
        name = "fecha_fin"
    )
    private LocalDate fechaFin;
    @Column(
        name = "precio_por_litro",
        nullable = false,
        precision = 10,
        scale = 2
    )
    private BigDecimal precioPorLitro;

    public Long getIdPrecio() {
        return this.idPrecio;
    }

    public void setIdPrecio(Long idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPrecioPorLitro() {
        return this.precioPorLitro;
    }

    public void setPrecioPorLitro(BigDecimal precioPorLitro) {
        this.precioPorLitro = precioPorLitro;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Precio)) {
            return false;
        } else {
            Precio other = (Precio)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$idPrecio = this.getIdPrecio();
                    Object other$idPrecio = other.getIdPrecio();
                    if (this$idPrecio == null) {
                        if (other$idPrecio == null) {
                            break label71;
                        }
                    } else if (this$idPrecio.equals(other$idPrecio)) {
                        break label71;
                    }

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

                label57: {
                    Object this$fechaInicio = this.getFechaInicio();
                    Object other$fechaInicio = other.getFechaInicio();
                    if (this$fechaInicio == null) {
                        if (other$fechaInicio == null) {
                            break label57;
                        }
                    } else if (this$fechaInicio.equals(other$fechaInicio)) {
                        break label57;
                    }

                    return false;
                }

                Object this$fechaFin = this.getFechaFin();
                Object other$fechaFin = other.getFechaFin();
                if (this$fechaFin == null) {
                    if (other$fechaFin != null) {
                        return false;
                    }
                } else if (!this$fechaFin.equals(other$fechaFin)) {
                    return false;
                }

                Object this$precioPorLitro = this.getPrecioPorLitro();
                Object other$precioPorLitro = other.getPrecioPorLitro();
                if (this$precioPorLitro == null) {
                    if (other$precioPorLitro == null) {
                        return true;
                    }
                } else if (this$precioPorLitro.equals(other$precioPorLitro)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Precio;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $idPrecio = this.getIdPrecio();
        result = result * 59 + ($idPrecio == null ? 43 : $idPrecio.hashCode());
        Object $producto = this.getProducto();
        result = result * 59 + ($producto == null ? 43 : $producto.hashCode());
        Object $fechaInicio = this.getFechaInicio();
        result = result * 59 + ($fechaInicio == null ? 43 : $fechaInicio.hashCode());
        Object $fechaFin = this.getFechaFin();
        result = result * 59 + ($fechaFin == null ? 43 : $fechaFin.hashCode());
        Object $precioPorLitro = this.getPrecioPorLitro();
        result = result * 59 + ($precioPorLitro == null ? 43 : $precioPorLitro.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getIdPrecio();
        return "Precio(idPrecio=" + var10000 + ", producto=" + String.valueOf(this.getProducto()) + ", fechaInicio=" + String.valueOf(this.getFechaInicio()) + ", fechaFin=" + String.valueOf(this.getFechaFin()) + ", precioPorLitro=" + String.valueOf(this.getPrecioPorLitro()) + ")";
    }

    public Precio() {
    }

    public Precio(final Long idPrecio, final Producto producto, final LocalDate fechaInicio, final LocalDate fechaFin, final BigDecimal precioPorLitro) {
        this.idPrecio = idPrecio;
        this.producto = producto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPorLitro = precioPorLitro;
    }
}
