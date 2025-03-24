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
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(
    name = "productos"
)
public class Producto {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long idProducto;
    @Column(
        nullable = false
    )
    private String nombre;
    private String descripcion;
    private String tipo;
    @JsonIgnore
    @OneToMany(
        mappedBy = "producto",
        cascade = {CascadeType.ALL}
    )
    private List<Precio> precios = new ArrayList();
    @JsonIgnore
    @OneToMany(
        mappedBy = "producto",
        cascade = {CascadeType.ALL}
    )
    private List<SurtidorProducto> surtidorProductos = new ArrayList();
    @JsonIgnore
    @OneToMany(
        mappedBy = "producto",
        cascade = {CascadeType.ALL}
    )
    private List<Suministro> suministros = new ArrayList();
    @JsonIgnore
    @OneToMany(
        mappedBy = "producto",
        cascade = {CascadeType.ALL}
    )
    private List<Tanque> tanques = new ArrayList();

    public Long getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Precio> getPrecios() {
        return this.precios;
    }

    public void setPrecios(List<Precio> precios) {
        this.precios = precios;
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

    public List<Tanque> getTanques() {
        return this.tanques;
    }

    public void setTanques(List<Tanque> tanques) {
        this.tanques = tanques;
    }

    public Producto() {
    }

    public Producto(final Long idProducto, final String nombre, final String descripcion, final String tipo, final List<Precio> precios, final List<SurtidorProducto> surtidorProductos, final List<Suministro> suministros, final List<Tanque> tanques) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precios = precios;
        this.surtidorProductos = surtidorProductos;
        this.suministros = suministros;
        this.tanques = tanques;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Producto)) {
            return false;
        } else {
            Producto other = (Producto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107: {
                    Object this$idProducto = this.getIdProducto();
                    Object other$idProducto = other.getIdProducto();
                    if (this$idProducto == null) {
                        if (other$idProducto == null) {
                            break label107;
                        }
                    } else if (this$idProducto.equals(other$idProducto)) {
                        break label107;
                    }

                    return false;
                }

                Object this$nombre = this.getNombre();
                Object other$nombre = other.getNombre();
                if (this$nombre == null) {
                    if (other$nombre != null) {
                        return false;
                    }
                } else if (!this$nombre.equals(other$nombre)) {
                    return false;
                }

                Object this$descripcion = this.getDescripcion();
                Object other$descripcion = other.getDescripcion();
                if (this$descripcion == null) {
                    if (other$descripcion != null) {
                        return false;
                    }
                } else if (!this$descripcion.equals(other$descripcion)) {
                    return false;
                }

                label86: {
                    Object this$tipo = this.getTipo();
                    Object other$tipo = other.getTipo();
                    if (this$tipo == null) {
                        if (other$tipo == null) {
                            break label86;
                        }
                    } else if (this$tipo.equals(other$tipo)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$precios = this.getPrecios();
                    Object other$precios = other.getPrecios();
                    if (this$precios == null) {
                        if (other$precios == null) {
                            break label79;
                        }
                    } else if (this$precios.equals(other$precios)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$surtidorProductos = this.getSurtidorProductos();
                    Object other$surtidorProductos = other.getSurtidorProductos();
                    if (this$surtidorProductos == null) {
                        if (other$surtidorProductos == null) {
                            break label72;
                        }
                    } else if (this$surtidorProductos.equals(other$surtidorProductos)) {
                        break label72;
                    }

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

                Object this$tanques = this.getTanques();
                Object other$tanques = other.getTanques();
                if (this$tanques == null) {
                    if (other$tanques != null) {
                        return false;
                    }
                } else if (!this$tanques.equals(other$tanques)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Producto;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $idProducto = this.getIdProducto();
        result = result * 59 + ($idProducto == null ? 43 : $idProducto.hashCode());
        Object $nombre = this.getNombre();
        result = result * 59 + ($nombre == null ? 43 : $nombre.hashCode());
        Object $descripcion = this.getDescripcion();
        result = result * 59 + ($descripcion == null ? 43 : $descripcion.hashCode());
        Object $tipo = this.getTipo();
        result = result * 59 + ($tipo == null ? 43 : $tipo.hashCode());
        Object $precios = this.getPrecios();
        result = result * 59 + ($precios == null ? 43 : $precios.hashCode());
        Object $surtidorProductos = this.getSurtidorProductos();
        result = result * 59 + ($surtidorProductos == null ? 43 : $surtidorProductos.hashCode());
        Object $suministros = this.getSuministros();
        result = result * 59 + ($suministros == null ? 43 : $suministros.hashCode());
        Object $tanques = this.getTanques();
        result = result * 59 + ($tanques == null ? 43 : $tanques.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getIdProducto();
        return "Producto(idProducto=" + var10000 + ", nombre=" + this.getNombre() + ", descripcion=" + this.getDescripcion() + ", tipo=" + this.getTipo() + ", precios=" + String.valueOf(this.getPrecios()) + ", surtidorProductos=" + String.valueOf(this.getSurtidorProductos()) + ", suministros=" + String.valueOf(this.getSuministros()) + ", tanques=" + String.valueOf(this.getTanques()) + ")";
    }
}
