import client.ClientSocket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Firm;
import static client.ClientUtils.*;

public class ControllerFirm {
    @FXML
    public TextField filterId;
    @FXML
    public TextField filterName;
    @FXML
    public TableColumn<Firm, String> idColumn;
    @FXML
    public TableColumn<Firm, String> nameColumn;
    @FXML
    public TableView<Firm> table;
    private ClientSocket clientSocket;

    ControllerFirm(ClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @FXML
    void initialize() {
        onClickRefresh(null);
    }
    public void onClickRefresh(ActionEvent actionEvent) {
        if (clientSocket == null)
            return;
        table.getItems().clear();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Number"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name Firm"));
        for (Firm firm : getAllFirm(clientSocket, filterName.getText())) {
            table.getItems().add(firm);
        }
    }
}
