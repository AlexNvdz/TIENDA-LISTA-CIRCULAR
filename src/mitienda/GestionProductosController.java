package mitienda;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class GestionProductosController {
    
    String idProducto="", nomProducto="";
    Date fechaLote = null, fechaVence=null;
    float precioU = -1;
    Producto caux = new Producto();
    PStack pilaProductos = new PStack();

   @FXML
    private MenuItem Listar1;

    @FXML
    private Menu MenBuscar;

    @FXML
    private Menu MenListar;

    @FXML
    private Menu MenOperaciones;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private TableView<?> MiTabla;

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
    private Menu menSalir;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtLote;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtVence;
    
    @FXML
    void eventoSalir(ActionEvent event) {
        System.exit(0);
    }
    
    
     @FXML
    void EventoMostrar(ActionEvent event) {
        
    }
    
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    
    @FXML
    void eventoRegitrar(ActionEvent event) throws ParseException {
        String fechaRegex = "\\d{2}/\\d{2}/\\d{4}";
        idProducto = txtID.getText();
        nomProducto = txtNombre.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        if (txtLote.getText().equals("") && txtVence.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese las fechas!!!");
            return;
        } else {
            if (Pattern.matches(fechaRegex, txtLote.getText()) && Pattern.matches(fechaRegex, txtVence.getText())) {
                 try {
        
                 Date fechaLote = format.parse(txtLote.getText());
                 Date fechaVence = format.parse(txtVence.getText());
                 float precioU = Float.parseFloat(txtPrecio.getText());

                Producto caux = new Producto(idProducto, nomProducto, fechaLote, fechaVence, precioU);
                pilaProductos.setPushProducto(caux);
                
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al procesar fechas o precio.");
                }
            } else {
            JOptionPane.showMessageDialog(null, "Ingrese el formato correcto dd/mm/yyyy");
            }
        }
    }
    
     public void initialize(URL url, ResourceBundle rb) {
        // TODO
         

     }
}
