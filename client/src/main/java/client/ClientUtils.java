package client;

import javafx.scene.control.Alert;
import model.Firm;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ClientUtils {

    private final static LoggerCS logger = new LoggerCS(ClientUtils.class);

    private ClientUtils() {
    }
    public static boolean alertSelectedItem(Object selectedItem, String title, String messageText) {
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(messageText);
            alert.showAndWait();
            return false;
        }
        return true;
    }

    public static ClientSocket connect(String host, int port) {
        try {
            return new ClientSocket(InetAddress.getByName(host), port);
        } catch (UnknownHostException e) {
            logger.error("Ошибка: Неизвестен хост. " + e.toString());
        }
        return null;
    }

    public static List<Firm> getAllFirm(ClientSocket clientSocket, String nameFirm) {
        List<Firm> firmList = new ArrayList<>();
        boolean isFiltered = !nameFirm.isEmpty();
        try {
            if (isFiltered) {
                logger.info("get filter");
                clientSocket.getOos().writeObject(ConstProtocol.filter);
            } else {
                logger.info("get all");
                clientSocket.getOos().writeObject(ConstProtocol.getAll);
            }
            clientSocket.getOos().flush();
        } catch (IOException e) {
            logger.error("Ошибка при отправке потока. " + e.toString());
            return new ArrayList<>();
        }
        if (isFiltered) {
            try {
                clientSocket.getOos().writeObject(nameFirm);
                clientSocket.getOos().flush();
            } catch (IOException e) {
                logger.error("Ошибка записи в поток. " + e.toString());
                return new ArrayList<>();
            }
        }
        Object inputObject;
        do {
            try {
                inputObject = clientSocket.getOis().readObject();
            } catch (ClassNotFoundException e) {
                logger.error("Ошибка класс не найден. " + e.toString());
                return new ArrayList<>();
            } catch (IOException e) {
                logger.error("Ошибка чтения из потока. " + e.toString());
                return new ArrayList<>();
            }
            if (inputObject instanceof Firm) {
                logger.info((inputObject).toString());
                firmList.add((Firm) inputObject);
            }
        } while (!((inputObject == ConstProtocol.finish)));
        return firmList;
    }

}
