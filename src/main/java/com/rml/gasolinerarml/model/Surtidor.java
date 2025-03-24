/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rml.gasolinerarml.model;

/**
 *
 * @author raul
 */
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "surtidores"
)
public class Surtidor {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long idSurtidor;
    @Column(
        nullable = false,
        unique = true
    )
    private String codigo;
    @Column(
        name = "fecha_instalacion"
    )
    private LocalDate fechaInstalacion;
    private boolean activo;
    @OneToMany(
        mappedBy = "surtidor",
        cascade = {CascadeType.ALL}
    )
    private List<SurtidorProducto> surtidorProductos = new ArrayList();
    @OneToMany(
        mappedBy = "surtidor",
        cascade = {CascadeType.ALL}
    )
    private List<Suministro> suministros = new ArrayList();

    public Long getIdSurtidor() {
        return this.idSurtidor;
    }

    public void setIdSurtidor(Long idSurtidor) {
        this.idSurtidor = idSurtidor;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaInstalacion() {
        return this.fechaInstalacion;
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<SurtidorProducto> getSurtidorProductos() {
        return this.surtidorProductos;
    }

    public void setSurtidorProductos(List<SurtidorProducto> surtidorProductos) {
        this.surtidorProductos = surtidorProductos;
    }

    public List<Suministro> getSuministros() {
        return this.suministros;
    }

    public void setSuministros(List<Suministro> suministros) {
        this.suministros = suministros;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Surtidor)) {
            return false;
        } else {
            Surtidor other = (Surtidor)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isActivo() != other.isActivo()) {
                return false;
            } else {
                label73: {
                    Object this$idSurtidor = this.getIdSurtidor();
                    Object other$idSurtidor = other.getIdSurtidor();
                    if (this$idSurtidor == null) {
                        if (other$idSurtidor == null) {
                            break label73;
                        }
                    } else if (this$idSurtidor.equals(other$idSurtidor)) {
                        break label73;
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

                label59: {
                    Object this$fechaInstalacion = this.getFechaInstalacion();
                    Object other$fechaInstalacion = other.getFechaInstalacion();
                    if (this$fechaInstalacion == null) {
                        if (other$fechaInstalacion == null) {
                            break label59;
                        }
                    } else if (this$fechaInstalacion.equals(other$fechaInstalacion)) {
                        break label59;
                    }

                    return false;
                }

                Object this$surtidorProductos = this.getSurtidorProductos();
                Object other$surtidorProductos = other.getSurtidorProductos();
                if (this$surtidorProductos == null) {
                    if (other$surtidorProductos != null) {
                        return false;
                    }
                } else if (!this$surtidorProductos.equals(other$surtidorProductos)) {
                    return false;
                }

                Object this$suministros = this.getSuministros();
                Object other$suministros = other.getSuministros();
                if (this$suministros == null) {
                    if (other$suministros != null) {
                        return false;
                    }
                } else if (!this$suministros.equals(other$suministros)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Surtidor;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        result = result * 59 + (this.isActivo() ? 79 : 97);
        Object $idSurtidor = this.getIdSurtidor();
        result = result * 59 + ($idSurtidor == null ? 43 : $idSurtidor.hashCode());
        Object $codigo = this.getCodigo();
        result = result * 59 + ($codigo == null ? 43 : $codigo.hashCode());
        Object $fechaInstalacion = this.getFechaInstalacion();
        result = result * 59 + ($fechaInstalacion == null ? 43 : $fechaInstalacion.hashCode());
        Object $surtidorProductos = this.getSurtidorProductos();
        result = result * 59 + ($surtidorProductos == null ? 43 : $surtidorProductos.hashCode());
        Object $suministros = this.getSuministros();
        result = result * 59 + ($suministros == null ? 43 : $suministros.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getIdSurtidor();
        return "Surtidor(idSurtidor=" + var10000 + ", codigo=" + this.getCodigo() + ", fechaInstalacion=" + String.valueOf(this.getFechaInstalacion()) + ", activo=" + this.isActivo() + ", surtidorProductos=" + String.valueOf(this.getSurtidorProductos()) + ", suministros=" + String.valueOf(this.getSuministros()) + ")";
    }

    public Surtidor() {
    }

    public Surtidor(final Long idSurtidor, final String codigo, final LocalDate fechaInstalacion, final boolean activo, final List<SurtidorProducto> surtidorProductos, final List<Suministro> suministros) {
        this.idSurtidor = idSurtidor;
        this.codigo = codigo;
        this.fechaInstalacion = fechaInstalacion;
        this.activo = activo;
        this.surtidorProductos = surtidorProductos;
        this.suministros = suministros;
    }
}