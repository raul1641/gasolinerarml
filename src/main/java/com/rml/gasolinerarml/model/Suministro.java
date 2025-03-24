/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.model;

/**
 *
 * @author raul
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "suministros"
)
public class Suministro {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long idSuministro;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(
        name = "id_surtidor",
        nullable = false
    )
    private Surtidor surtidor;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(
        name = "id_producto",
        nullable = false
    )
    private Producto producto;
    @Column(
        name = "fecha_hora",
        nullable = false
    )
    private LocalDateTime fechaHora;
    @Column(
        name = "volumen_litros",
        nullable = false,
        precision = 10,
        scale = 2
    )
    private BigDecimal volumenLitros;
    @Column(
        name = "importe_euros",
        nullable = false,
        precision = 10,
        scale = 2
    )
    private BigDecimal importeEuros;

    public Long getIdSuministro() {
        return this.idSuministro;
    }

    public void setIdSuministro(Long idSuministro) {
        this.idSuministro = idSuministro;
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

    public LocalDateTime getFechaHora() {
        return this.fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getVolumenLitros() {
        return this.volumenLitros;
    }

    public void setVolumenLitros(BigDecimal volumenLitros) {
        this.volumenLitros = volumenLitros;
    }

    public BigDecimal getImporteEuros() {
        return this.importeEuros;
    }

    public void setImporteEuros(BigDecimal importeEuros) {
        this.importeEuros = importeEuros;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Suministro)) {
            return false;
        } else {
            Suministro other = (Suministro)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$idSuministro = this.getIdSuministro();
                Object other$idSuministro = other.getIdSuministro();
                if (this$idSuministro == null) {
                    if (other$idSuministro != null) {
                        return false;
                    }
                } else if (!this$idSuministro.equals(other$idSuministro)) {
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

                label62: {
                    Object this$fechaHora = this.getFechaHora();
                    Object other$fechaHora = other.getFechaHora();
                    if (this$fechaHora == null) {
                        if (other$fechaHora == null) {
                            break label62;
                        }
                    } else if (this$fechaHora.equals(other$fechaHora)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$volumenLitros = this.getVolumenLitros();
                    Object other$volumenLitros = other.getVolumenLitros();
                    if (this$volumenLitros == null) {
                        if (other$volumenLitros == null) {
                            break label55;
                        }
                    } else if (this$volumenLitros.equals(other$volumenLitros)) {
                        break label55;
                    }

                    return false;
                }

                Object this$importeEuros = this.getImporteEuros();
                Object other$importeEuros = other.getImporteEuros();
                if (this$importeEuros == null) {
                    if (other$importeEuros != null) {
                        return false;
                    }
                } else if (!this$importeEuros.equals(other$importeEuros)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Suministro;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $idSuministro = this.getIdSuministro();
        result = result * 59 + ($idSuministro == null ? 43 : $idSuministro.hashCode());
        Object $surtidor = this.getSurtidor();
        result = result * 59 + ($surtidor == null ? 43 : $surtidor.hashCode());
        Object $producto = this.getProducto();
        result = result * 59 + ($producto == null ? 43 : $producto.hashCode());
        Object $fechaHora = this.getFechaHora();
        result = result * 59 + ($fechaHora == null ? 43 : $fechaHora.hashCode());
        Object $volumenLitros = this.getVolumenLitros();
        result = result * 59 + ($volumenLitros == null ? 43 : $volumenLitros.hashCode());
        Object $importeEuros = this.getImporteEuros();
        result = result * 59 + ($importeEuros == null ? 43 : $importeEuros.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getIdSuministro();
        return "Suministro(idSuministro=" + var10000 + ", surtidor=" + String.valueOf(this.getSurtidor()) + ", producto=" + String.valueOf(this.getProducto()) + ", fechaHora=" + String.valueOf(this.getFechaHora()) + ", volumenLitros=" + String.valueOf(this.getVolumenLitros()) + ", importeEuros=" + String.valueOf(this.getImporteEuros()) + ")";
    }

    public Suministro() {
    }

    public Suministro(final Long idSuministro, final Surtidor surtidor, final Producto producto, final LocalDateTime fechaHora, final BigDecimal volumenLitros, final BigDecimal importeEuros) {
        this.idSuministro = idSuministro;
        this.surtidor = surtidor;
        this.producto = producto;
        this.fechaHora = fechaHora;
        this.volumenLitros = volumenLitros;
        this.importeEuros = importeEuros;
    }
}