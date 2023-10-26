/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitienda;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Nvdz
 */
public class PStack {
    
     Stack<Producto> pilaP;

    PStack() {
        pilaP = new Stack();
    }

    public void setPushProducto(Producto producto) {
        if (!pilaP.contains(producto)) {
            pilaP.push(producto);
            JOptionPane.showMessageDialog(null, "Elemento registrado!");
        } else {
            JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado!");
        }
    }
    
    public void mostrarProductos(){
        for (Producto producto : pilaP) {
            String info="La información del Producto es: \n";
            info += "IdTiquete: "+ producto.getIdProducto()+"\n";
            info += "Ciudad destino: "+ producto.getNomProducto() +"\n";
            info += "Precio tiquete: " + producto.getFechaLote()+ "\n";
            info += "Precio tiquete: " + producto.getFechaVence()+ "\n";
            info += "Precio tiquete: " + producto.getPrecioU()+ "\n";
            JOptionPane.showMessageDialog(null, info);
        }
    }


    public double getPromedio() {
        float suma = 0;
        for (Producto producto : pilaP) {
            // Supongamos que los objetos Producto tienen un atributo llamado "valor"
            // que es un número que deseas sumar
            double valorProducto = producto.precioU;  // Obtén el valor del Producto
            suma += valorProducto;  // Acumula el valor en la suma
        }
        return suma / pilaP.size();
    }

    
 }




