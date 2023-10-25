package mitienda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GestionProductosController {

     @FXML
    private TableView MiTabla;
     
    @FXML
    private MenuItem Listar1;

    @FXML
    private Menu MenBuscar;

    @FXML
    private Menu MenListar;

    @FXML
    private Menu MenOperaciones;

    @FXML
    private Menu MenRegistrar;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem Op1;

    @FXML
    private MenuItem Op2;

    @FXML
    private MenuItem Op3;
    

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
