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
    Producto sig;

    public Producto(String id, String nom, String fechaL, String fechaV, float costo) {
        idProducto = id;
        nomProducto = nom;
        fechaLote = fechaL;
        fechaVence = fechaV;
        precioU = costo;
        sig = null;
    }

  
    public void getMostrarNodo() {
        String info = "La informacion del nodo es: \n";
        info += "ID Producto: " + idProducto + "\n";
        info += "Nombre Producto: " + nomProducto + "\n";
        info += "Fecha Lote: " + fechaLote + "\n";
        info += "Fecha Vencimiento: " + fechaVence + "\n";
        info += "Precio Unitario: " + precioU + "\n";
        JOptionPane.showMessageDialog(null, info);
    }
}
