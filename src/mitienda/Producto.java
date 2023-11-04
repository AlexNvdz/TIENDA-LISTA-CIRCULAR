/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitienda;

import java.time.LocalDate;
import java.util.Objects;


/**
 *
 * @author Alex Nvdz
 */
public class Producto {
    
   String idProducto;
   String nomProducto;
   LocalDate fechaLote;
   LocalDate fechaVence;
   float precioU;

    public Producto(String idProducto, String nomProducto, LocalDate fechaLote, LocalDate fechaVence, float precioU) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.fechaLote = fechaLote;
        this.fechaVence = fechaVence;
        this.precioU = precioU;
    }
  

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public LocalDate getFechaLote() {
        return fechaLote;
    }

    public void setFechaLote(LocalDate fechaLote) {
        this.fechaLote = fechaLote;
    }

    public LocalDate getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(LocalDate fechaVence) {
        this.fechaVence = fechaVence;
    }

    public float getPrecioU() {
        return precioU;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }
   
    
      @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Producto other = (Producto) obj;
        return idProducto.equals(other.idProducto) || nomProducto.equals(other.nomProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nomProducto);
    }  
}
//FINALIZACION

