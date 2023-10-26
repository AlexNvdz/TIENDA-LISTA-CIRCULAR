package mitienda;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class GestionProductosController {
    
    String idProducto="", nomProducto="";
    LocalDate fechaLote = null, fechaVence=null;
    float precioU = -1;
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
    
    @FXML
    void eventoSalir(ActionEvent event) {
        System.exit(0);
    }
    
    
     @FXML
    void EventoMostrar(ActionEvent event) {
        pilaProductos.mostrarProductos();
    }
    
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    
    @FXML
    void eventoRegitrar(ActionEvent event) throws ParseException {
        String id = txtID.getText();
        String nom = txtNombre.getText();
        if (getFechaL.getValue()==null && getFechaV.getValue()==null) {
            JOptionPane.showMessageDialog(null, "Ingrese las fechas!!!");
            return;
        } else {
           
                 try {
        
                 LocalDate fechaLote = getFechaL.getValue();
                 LocalDate fechaVence = getFechaV.getValue() ;
                 float precio = Float.parseFloat(txtPrecio.getText());

                Producto producto = new Producto(id, nom, fechaLote, fechaVence, precio);
                pilaProductos.setPushProducto(producto);
                
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al procesar fechas o precio.");
                }
            }
        }
  
     public void initialize(URL url, ResourceBundle rb) {
        // TODO
         

     }
    }
    
    

