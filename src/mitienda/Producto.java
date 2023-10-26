/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitienda;

import java.util.Date;
import java.util.Objects;


/**
 *
 * @author Alex Nvdz
 */
public class Producto {

    String idProducto;
    String nomProducto;
    Date fechaLote;
     Date fechaVence;
    float precioU;

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

    public Date getFechaLote() {
        return fechaLote;
    }

    public void setFechaLote(Date fechaLote) {
        this.fechaLote = fechaLote;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public float getPrecioU() {
        return precioU;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }
   
    
    Producto(){
        idProducto=nomProducto="";
        fechaLote = fechaVence= null;
        precioU = -1;
    }
    public Producto(String id, String nom, Date fechaL, Date fechaV, float costo) {
        idProducto = id;
        nomProducto = nom;
        fechaLote = fechaL;
        fechaVence = fechaV;
        precioU = costo;
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
        return Objects.equals(idProducto, other.idProducto) && Objects.equals(nomProducto, other.nomProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nomProducto);
    }
}

