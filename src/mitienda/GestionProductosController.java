/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mitienda;

import java.net.URL;
import java.time.LocalDate;
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
    private Button btnAceptar;

    @FXML
    private Button btnAceptar2;

    @FXML
    private TextField txtBusqueda;

    @FXML
    private ComboBox<String> comboFiltros;

    @FXML
    private ComboBox<String> comboMeses;

    @FXML
    private Button actualizarTabla;

    @FXML
    private Menu MenListar;

    @FXML
    private MenuItem mayorPrecio;

    @FXML
    private MenuItem menPrecio;

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

        ObservableList<String> opcFiltros = FXCollections.observableArrayList(
                "id Producto", "Nombre Producto", "Fecha Lote", "Fecha Vence", "precio");

        comboFiltros.setItems(opcFiltros);
        comboFiltros.setValue("Filtro Busqueda");

        ObservableList<String> opcMeses = FXCollections.observableArrayList(
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        );
        comboMeses.setItems(opcMeses);
        comboMeses.setValue("Filtro Mes");
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
        ObservableList<Producto> productosEncontradosMen = FXCollections.observableArrayList();

        if (ListaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia ingrese primero productos!!");
            return;
        }

        for (Producto producto : ListaProductos) {
            if (producto.getPrecioU() < promedio) {

                productosEncontradosMen.add(producto);

            }
        }
        // Actualiza la tabla con los productos encontrados
        MiTabla.setItems(productosEncontradosMen);
    }

    @FXML
    void eventoListarMayoresP(ActionEvent event) {
        float promedio = pilaProductos.getPromedio();
        // Crea una lista para almacenar los productos que coincidan al ser menores al promedio
        ObservableList<Producto> productosEncontradosMay = FXCollections.observableArrayList();

        if (ListaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia ingrese primero productos!!");
            return;
        }

        for (Producto producto : ListaProductos) {
            if (producto.getPrecioU() > promedio) {

                productosEncontradosMay.add(producto);

            }
        }
        // Actualiza la tabla con los productos encontrados
        MiTabla.setItems(productosEncontradosMay);
    }

    @FXML
    void eventoMayorPrecio(ActionEvent event) {

        float Mayor = 0;

        ObservableList<Producto> productoMay = FXCollections.observableArrayList();

        if (ListaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia ingrese primero productos!!");
            return;
        }

        for (Producto producto : ListaProductos) {
            if (producto.getPrecioU() > Mayor) {
                Mayor = producto.getPrecioU();
            }
        }

        for (Producto producto : ListaProductos) {
            if (producto.getPrecioU() == Mayor) {
                productoMay.add(producto);
            }
        }

        JOptionPane.showMessageDialog(null, "Producto con mayor precio encontrado con exito!!");

        // Actualiza la tabla con los productos encontrados
        MiTabla.setItems(productoMay);
    }

    @FXML
    void eventoMenorPrecio(ActionEvent event) {

        ObservableList<Producto> productoMen = FXCollections.observableArrayList();

        float Menor = ListaProductos.getLast().precioU;

        if (ListaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia ingrese primero productos!!");
            return;
        }

        for (Producto producto : ListaProductos) {
            if (producto.getPrecioU() < Menor) {
                Menor = producto.getPrecioU();
            }
        }

        for (Producto producto : ListaProductos) {
            if (producto.getPrecioU() == Menor) {
                productoMen.add(producto);
            }
        }

        JOptionPane.showMessageDialog(null, "Producto con menor precio encontrado con exito!!");

        // Actualiza la tabla con los productos encontrados
        MiTabla.setItems(productoMen);
    }

    @FXML
    void eventoActualizar(ActionEvent event) {
        if (ListaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No es posible actualizar la lista esta vacia!!");
            return;
        }

        MiTabla.setItems(ListaProductos);
    }


    @FXML
    void eventoBuscarMes(ActionEvent event) {
        // Obtén el mes seleccionado del ComboBox
        String mesSeleccionado = comboMeses.getValue();

        // Crea una lista para almacenar los productos que coinciden con el mes
        ObservableList<Producto> productosMesEncontrado = FXCollections.observableArrayList();

        for (Producto producto : ListaProductos) {
            // Obtiene el mes de la fecha de lote y fecha de vencimiento
            int mesLote = producto.getFechaLote().getMonthValue();
            int mesVencimiento = producto.getFechaVence().getMonthValue();

            // Compara si alguno de los meses coincide con el mes seleccionado
            if (mesLote == obtenerNumeroMes(mesSeleccionado) || mesVencimiento == obtenerNumeroMes(mesSeleccionado)) {
                productosMesEncontrado.add(producto);
            }
        }

        // Actualiza la tabla con los productos encontrados
        MiTabla.setItems(productosMesEncontrado);
    }

    @FXML
    void eventoBusqueda(ActionEvent event) {
        String campoSeleccionado = (String) comboFiltros.getValue();
        String criterio = txtBusqueda.getText().toLowerCase(); // Convertir a minúsculas para la comparación

        ObservableList<Producto> productosBusqueda = FXCollections.observableArrayList();

        for (Producto producto : ListaProductos) {
            String valorCampo = "";
            switch (campoSeleccionado) {
                case "id Producto":
                    valorCampo = producto.getIdProducto();
                    break;
                case "Nombre Producto":
                    valorCampo = producto.getNomProducto();
                    break;
                case "Fecha Lote":
                    valorCampo = producto.getFechaLote().toString();
                    break;
                case "Fecha Vence":
                    valorCampo = producto.getFechaVence().toString();
                    break;
                case "precio":
                    valorCampo = String.valueOf(producto.getPrecioU());
                    break;
            }
            if (comboFiltros.getValue().equals("id Producto")) {
                if (valorCampo.toLowerCase().equals(criterio)) {
                    productosBusqueda.add(producto);
                }
            } else if (comboFiltros.getValue().equals("Nombre Producto")) {
                if (valorCampo.toLowerCase().equals(criterio)) {
                    productosBusqueda.add(producto);
                }
            } else if (comboFiltros.getValue().equals("Fecha Lote")) {
                if (valorCampo.toLowerCase().contains(criterio)) {
                    productosBusqueda.add(producto);
                }
            } else if (comboFiltros.getValue().equals("Fecha Vence")) {
                if (valorCampo.toLowerCase().contains(criterio)) {
                    productosBusqueda.add(producto);
                }
            } else if (comboFiltros.getValue().equals("precio")) {
                if (valorCampo.toLowerCase().contains(criterio)) {
                    productosBusqueda.add(producto);
                }
            }
        }

        // Actualiza la tabla con los productos encontrados
        MiTabla.setItems(productosBusqueda);
    }

    // Método para obtener el número de mes a partir del nombre
    private int obtenerNumeroMes(String nombreMes) {
        switch (nombreMes) {
            case "Enero":
                return 1;
            case "Febrero":
                return 2;
            case "Marzo":
                return 3;
            case "Abril":
                return 4;
            case "Mayo":
                return 5;
            case "Junio":
                return 6;
            case "Julio":
                return 7;
            case "Agosto":
                return 8;
            case "Septiembre":
                return 9;
            case "Octubre":
                return 10;
            case "Noviembre":
                return 11;
            case "Diciembre":
                return 12;
            default:
                return 0; // Valor predeterminado si no se encuentra el mes
        }
    }
}
