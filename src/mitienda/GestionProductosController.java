/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mitienda;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Alex Nvdz
 */
public class GestionProductosController implements Initializable {
    
    @FXML
    private TableView MiTabla;
    private MenuBar MenuBar;
    private Menu MenRegistrar;
    private Menu MenBuscar;
    private Menu MenListar;
    private MenuItem Listar1;
    private Menu MenOperaciones;
    private MenuItem Op1;
    private MenuItem Op2;
    private MenuItem Op3;
    private Menu MenSalir;
    
    @FXML
    private void MenSalir(ActionEvent event) {
        System.exit(0);
    }
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TableColumn id = new TableColumn("ID");
        TableColumn nomP = new TableColumn("NOMBRE");
        TableColumn fechaLote = new TableColumn("FECHA LOTE");
        TableColumn fechaVence = new TableColumn("FECHA VENCE");
        TableColumn precioU = new TableColumn("PRECIO");
        
        
        MiTabla.getColumns().addAll(id, nomP, fechaLote, fechaVence, precioU);
    }    
    
}
