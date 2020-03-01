import client.ClientSocket;
import client.ClientUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.concurrent.Callable;

import static client.ClientUtils.alertSelectedItem;
import static client.LoaderFX.getStage;


public class ConnectionFormController {
    @FXML
    private TextField hostField;
    @FXML
    private TextField portField;
    @FXML
    private Label connectLab;

    private ClientSocket clientSocket;

    public void onClickConnect(ActionEvent actionEvent) {
        String host = hostField.getText();
        int port;
        try {
            port = Integer.parseInt(portField.getText());
        } catch (NumberFormatException e) {
            alertSelectedItem(null, "Ошибка!", "Неверный формат номера порта!");
            return;
        }
        clientSocket = ClientUtils.connect(host, port);
        if ((clientSocket != null) && (clientSocket.getSocket() != null)) {
            connectLab.setText("Успешно!");
            Stage stage = getStage(ControllerFirm.class, (Callable<ControllerFirm>) () -> new ControllerFirm(clientSocket), "firm.fxml", false, "Фирмы");
            stage.setOnShown(event -> hostField.getScene().getWindow().hide());
            stage.show();
        }
    }
}
