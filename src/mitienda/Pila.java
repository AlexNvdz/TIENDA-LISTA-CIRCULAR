/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitienda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex Nvdz
 */
public class Pila {

    Producto tope;

    Pila() {
        tope = null;
    }

    public Producto getBuscarId(String id) {
        if (tope == null) {
            return null;
        } else {
            Producto p = tope;
            do {
                if (p.idProducto == id) {
                    p = p.sig;
                } else {
                    return p;
                }

            } while (p != tope);
        }
        return null;
    }

    public int getLongPila() {
        int cont = 0;
        if (tope == null) {
            return 0;
        } else {
            Producto p = tope;
            do {
                cont++;
                p = p.sig;
            } while (p != tope);
            return cont;
        }
    }

    public Producto getBase() {
        Producto p;
        if (tope == null) {
            return null;
        } else {
            p = tope;
            while (p.sig != tope) {
                p = p.sig;
            }
            return p;
        }
    }

    public Producto getCrearNodo() {
        Producto info;
        Producto b;
        String id, nom;
        float costo;
        id = JOptionPane.showInputDialog("Ingrese Id del producto:");
        if (id.equals("")) {
             JOptionPane.showMessageDialog(null, "Error: Id Producto no"
                    + "puede ser vacío!!!");
            return null;
        } else  {
            try {
                do {
                    b = getBuscarId(id);
                    if (b != null) {
                        JOptionPane.showMessageDialog(null, "El Id del producto ya se encuentra registrado."
                                + " Intente nuevamente...!");
                    }
                } while (b != null);
                
                nom = JOptionPane.showInputDialog("Ingrese Id del producto:");
      
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha (puedes cambiarlo según tus necesidades)

                String fechaV = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento (yyyy-MM-dd):");
                String fechaL = JOptionPane.showInputDialog("Ingrese la fecha de lote (yyyy-MM-dd):");

                try {
                Date fechaVn = dateFormat.parse(fechaV);
                Date fechaLt = dateFormat.parse(fechaL);

                } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utiliza el formato yyyy-MM-dd.");
                }
                
                costo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Id del producto:"));
                
                info = new Producto(id,nom,fechaL,fechaV,costo);

                return info;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error!!: " + e + "El "
                        + "nodo no fue creado intente nuevamente.");
                return null;
            }
        }
    }

    public void setPush() {
        Producto info = getCrearNodo(), p;
        if (info != null) {
            if (tope == null) {
                tope = info;
                tope.sig = tope;
                JOptionPane.showMessageDialog(null, "Elemento agregado"
                        + " la pila no tenia elementos.");
            } else {
                p = getBase();
                p.sig = info;
                info.sig = tope;
                tope = info;
                JOptionPane.showMessageDialog(null, "Elemento agregado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Imposible agregar, el nodo no fue creado...");
        }
    }

    public void setPot() {
        if (tope == null) {
            JOptionPane.showMessageDialog(null, "'La pila esta vacia.");
        } else {
            if (tope.sig == tope) {
                tope = null;
                JOptionPane.showMessageDialog(null, "Elemento atendido la pila esta vacia");
            } else {
                Producto m = getBase();
                Producto p = tope;
                m.sig = tope.sig;
                tope = tope.sig;
                p.sig = null;
                p = null;
                JOptionPane.showMessageDialog(null, "Elemento Atendido.");
            }
        }
    }
    
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int Fila, Producto info){
        miModelo.setValueAt(info.idProducto, Fila, 0);
        miModelo.setValueAt(info.nomProducto, Fila, 1);
        miModelo.setValueAt(info.fechaLote, Fila, 2);
        miModelo.setValueAt(info.fechaVence, Fila, 3);
        miModelo.setValueAt(info.precioU, Fila, 3);
    }
    
    public void setLlenarJTable(JTable tab){
        Producto p = getBase();
        int i=0;
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("Id Producto");
        miModelo.addColumn("Nombre del Producto");
        miModelo.addColumn("fecha Lote");
        miModelo.addColumn("Fecha Vence");
        miModelo.addColumn("Precio");
        while(p!=null){                        
            miModelo.addRow(new Object[]{"", "", "", ""});              
            setRegistrarFilaJTable(miModelo,i,p);
            p=p.sig;
            i++;
        }
        tab.setModel(miModelo);
    }

}

