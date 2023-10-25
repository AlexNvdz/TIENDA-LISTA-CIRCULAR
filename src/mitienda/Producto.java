/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitienda;

import java.util.Date;
import javax.swing.JOptionPane;

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
}
