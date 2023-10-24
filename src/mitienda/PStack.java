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
  Stack <Producto> pilaP;
    
    PStack(){
        pilaP = new Stack();
    }
            
    void setPushProducto(Producto q){
        int pos= pilaP.indexOf(q);
        //Si el cliente no existe es agregado
        if(pos==-1){
            pilaP.push(q);
            JOptionPane.showMessageDialog(null, 
            "Elemento registrado!");
        }else{
            JOptionPane.showMessageDialog(null, 
            "El Prodcuto ya se encuentra registrado!");
        }
    }
    
    void setPopProducto(){
        if(!pilaP.empty()){
            pilaP.pop();
            JOptionPane.showMessageDialog(null, 
            "Elemento atendido!");
        }else{
            JOptionPane.showMessageDialog(null, 
            "La pila no tiene elementos!");
        }
    }
    
    Producto getInfoProductoid(String id){
        Producto aux = new Producto();
        int i=0;
        while(i<pilaP.size()){
            aux=(Producto) pilaP.get(i);
            if(aux.idProducto.equals(id))
                return aux;
            i++;
        }
        aux=null;
        return aux;
    }
    
    void setPopProductoId(String id){        
        Producto aux = null;
        if(!pilaP.empty()){
            aux = getInfoProductoid(id);
            if((aux!=null)&&(pilaP.remove(aux)))              
                JOptionPane.showMessageDialog(null, 
                "Elemento eliminado!");                            
            else
                JOptionPane.showMessageDialog(null, 
                "El elemento no existe!");            
        }
        else{
            JOptionPane.showMessageDialog(null, 
            "La pila no tiene elementos!");
        }
    }
    
    void getseeInfoProducto(String id){
        Producto aux=getInfoProductoid(id);
        String data="";
        if(aux!=null){
            data="Datos del cliente \n";
            data+="IdCliente: "+aux.idProducto+"\n";
            data+="Nombres: "+aux.nomProducto+"\n";
            data+="Saldo Anterior: "+aux.fechaLote+"\n";
            data+="Valor Operación: "+aux.fechaVence+"\n";
            data+="Operación Realizada: "+aux.precioU+"\n";           
            JOptionPane.showMessageDialog(null, data);
        }
        else{
            JOptionPane.showMessageDialog(null, 
            "El elemento no existe!");
        }
    }
    
    PStack getClonar(){
        PStack caux=new PStack();
        int i;
        Producto aux=null;
        if(this.pilaP==null)
            return null;
        else{
            for(i=0;i<pilaP.size();i++){
                aux=(Producto) pilaP.get(i);
                caux.pilaP.add(i, aux);
            }
            return caux;
        }
    }
    
    void getseeAll(){
        Producto aux=null;
        int op=0, i=0;
        PStack caux=this.getClonar();
        while((i<caux.pilaP.size())&&(op==0)){
            aux=(Producto) caux.pilaP.elementAt(i);
            getseeInfoProducto(aux.idProducto);
            i++;                        
            op=JOptionPane.showConfirmDialog(
            null, "Desea continuar?");
        }
        caux=null;
    }
    
    public double getPromedio(){
       float suma = 0;
       for (Producto producto : pilaP) {
        // Supongamos que los objetos Producto tienen un atributo llamado "valor"
        // que es un número que deseas sumar
        double valorProducto = producto.precioU;  // Obtén el valor del Producto
        suma += valorProducto;  // Acumula el valor en la suma
    }
    return suma/pilaP.size();
    }
}    
    
  


