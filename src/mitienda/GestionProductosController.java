package mitienda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionProductosController {
    
    String idProducto="", nomProducto="", fechaLote="", fechaVence="",aux="";
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
    private TableColumn<?, ?> TFt;

    @FXML
    private TableColumn<?, ?> TFv;

    @FXML
    private TableColumn<?, ?> TNom;

    @FXML
    private TableColumn<?, ?> TPrecio;

    @FXML
    private TableColumn<?, ?> Tid;

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
    void eventoRegitrar(ActionEvent event) {
        idProducto = txtID.getText();
        nomProducto = txtNombre.getText();
         
    }

     public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }
}
