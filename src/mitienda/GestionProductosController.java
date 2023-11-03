/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mitienda;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Nvdz
 */
public class GestionProductosController implements Initializable {

    String idProducto = "", nomProducto = "";
    LocalDate fechaLote = null, fechaVence = null;
    float precioU = -1;
    PStack pilaProductos = new PStack();

    @FXML
    private Menu MenBuscar;

    @FXML
    private Menu MenListar;

    @FXML
    private Menu MenOperaciones;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private TableView<Producto> MiTabla;

    @FXML
    private MenuItem Op1;

    @FXML
    private MenuItem Op2;

    @FXML
    private MenuItem Op3;

    @FXML
    private Button btnRegistrar;

    @FXML
    private MenuItem busFL;

    @FXML
    private MenuItem busFV;

    @FXML
    private MenuItem busId;

    @FXML
    private MenuItem busNom;

    @FXML
    private MenuItem busPrecio;

    @FXML
    private MenuItem funSalir;

    @FXML
    private DatePicker getFechaL;

    @FXML
    private DatePicker getFechaV;

    @FXML
    private Menu menSalir;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    private ObservableList<Producto> ListaProductos;
    @FXML
    private TableColumn<Producto, String> idColumn;
    @FXML
    private TableColumn<Producto, String> nomColumn;
    @FXML
    private TableColumn<Producto, String> fechaLColumn;
    @FXML
    private TableColumn<Producto, String> fechaVColumn;
    @FXML
    private TableColumn<Producto, Integer> precioUColumn;
    @FXML
    private ComboBox<String> BoxMeses;

    @FXML
    void eventoSalir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void EventoMostrar(ActionEvent event) {
        pilaProductos.mostrarProductos();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nomProducto"));
        fechaLColumn.setCellValueFactory(new PropertyValueFactory<>("fechaLote"));
        fechaVColumn.setCellValueFactory(new PropertyValueFactory<>("fechaVence"));
        precioUColumn.setCellValueFactory(new PropertyValueFactory<>("precioU"));

        // Inicializa la lista observable de productos
        ListaProductos = FXCollections.observableArrayList();

        // Asocia la lista de productos a la tabla
        MiTabla.setItems(ListaProductos);

        ObservableList<String> opciones = FXCollections.observableArrayList(
                "idProducto", "nomProducto", "FechaLote", "FechaVence", "precioU");
    }

    @FXML
    void eventoRegitrar(ActionEvent event) {
        String id = txtID.getText();
        String nom = txtNombre.getText();

        for (Producto producto : ListaProductos) {
            if (producto.getIdProducto().equals(id) || producto.getNomProducto().equals(nom)) {
                JOptionPane.showMessageDialog(null, "El nombre o el id ya se encuentra registrado!!! "
                        + "Intente nuevamente.");
                return;
            }
        }

        if (getFechaL.getValue() == null && getFechaV.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese las fechas!!!");
            return;
        } else {

            LocalDate fechaLote = getFechaL.getValue();
            LocalDate fechaVence = getFechaV.getValue();
            float precio = Float.parseFloat(txtPrecio.getText());

            Producto producto = new Producto(id, nom, fechaLote, fechaVence, precio);
            pilaProductos.setPushProducto(producto);
            ListaProductos.add(producto);
            txtID.clear();
            txtNombre.clear();
            getFechaL.setValue(null);
            getFechaV.setValue(null);
            txtPrecio.clear();
            txtID.requestFocus();
        }
    }

    @FXML
    void eventoPromedio(ActionEvent event) {
        float promedio = pilaProductos.getPromedio();
        // Muestra el precio promedio en una ventana emergente
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Precio Promedio");
        alert.setHeaderText(null);
        alert.setContentText("El precio promedio de los productos es: " + promedio);
        alert.showAndWait();

    }

    @FXML
    void eventoListarMenoresP(ActionEvent event) {
         float promedio = pilaProductos.getPromedio();
        // Crea una lista para almacenar los productos que coincidan al ser menores al promedio
        ObservableList<Producto> productosEncontrados = FXCollections.observableArrayList();
        
        if (ListaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia ingrese primero productos!!");
            return;
        }
    
        for (Producto producto : ListaProductos) {
            if (producto.getPrecioU() < promedio ) {
                
                productosEncontrados.add(producto);
                
            }
        }
        // Actualiza la tabla con los productos encontrados
        MiTabla.setItems(productosEncontrados);
    }

}
