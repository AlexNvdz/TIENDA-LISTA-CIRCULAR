/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitienda;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex Nvdz
 */
public class Producto {

    String idProducto;
    String nomProducto;
    String fechaLote;
    String fechaVence;
    float precioU;
    
    Producto(){
        idProducto=nomProducto=fechaLote=fechaVence="";
        precioU = -1;
    }
    public Producto(String id, String nom, String fechaL, String fechaV, float costo) {
        idProducto = id;
        nomProducto = nom;
        fechaLote = fechaL;
        fechaVence = fechaV;
        precioU = costo;
    }
}
