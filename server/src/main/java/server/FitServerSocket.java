package server;

import interfaces.IController;
import interfaces.IModel;
import logger.LoggerCS;
import model.Firm;
import utils.ConstProtocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class FitServerSocket implements Runnable {
    private final static LoggerCS logger = new LoggerCS(FitServerSocket.class);
    private Socket clientSocket;
    private IModel model;
    private IController controller;

    public FitServerSocket(Socket clientSocket, IModel model, IController controller) {
        this.clientSocket = clientSocket;
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void run() {

        try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {
            logger.info("Клиент подключился");
            while (!clientSocket.isClosed()) {
                Object inputObject = readObject(in);
                logger.info("От клиента получен запрос " + inputObject);
                if (inputObject == null)
                    break;
                if (inputObject instanceof ConstProtocol) {
                    if (actionSelection(out, in, (ConstProtocol) inputObject)) break;
                }
            }
            clientSocket.close();
            logger.info("Пользователь закрыл соединение");
        } catch (IOException e) {
            logger.error("Ошибка чтения/записи в поток. " + e.toString());
        }
    }

    private boolean actionSelection(ObjectOutputStream out, ObjectInputStream in, ConstProtocol inputConstProtocol) {
        switch (inputConstProtocol) {
            case exit:
                return true;
            case find: {
                findFirm(out, in);
                break;
            }
            case getAll: {
                getAll(out);
                break;
            }
            case filter: {
                filter(out, in);
                break;
            }
        }
        return false;
    }

    private Object readObject(ObjectInputStream in) {
        Object object = null;
        try {
            object = in.readObject();
        } catch (IOException e) {
            logger.error("Ошибка ввода вывода. " + e.toString());
        } catch (ClassNotFoundException e) {
            logger.error("Ошибка. Класс не найден. " + e.toString());
        }
        return object;
    }

    private void findFirm(ObjectOutputStream out, ObjectInputStream in) {
        Integer inputInt = readObjectToInteger(in);
        if (inputInt != null) {
            String findValue = readObjectToString(in);
            if (findValue != null) {
                try {
                    out.reset();
                    out.writeObject(model.findFirm(inputInt));
                    out.flush();
                } catch (IOException e) {
                    logger.error(e.toString());
                }
            }
        }
    }

    private void getAll(ObjectOutputStream out) {
        try {
            out.reset();
            List<Firm> firmList = model.getFirms();
            for (Firm firm : firmList) {
                logger.info(firm.toString());
                out.writeObject(firm);
            }
            out.writeObject(ConstProtocol.finish);
            out.flush();
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

    private void filter(ObjectOutputStream out, ObjectInputStream in) {
        String filterFirm = readObjectToString(in);
        if (filterFirm != null) {
            try {
                out.reset();
                List<Firm> firmList = model.getFirms();
                for (Firm firm : firmList) {
                    logger.info(firm.toString());
                    out.writeObject(firm);
                }
                out.writeObject(ConstProtocol.finish);
                out.flush();
            } catch (IOException e) {
                logger.error(e.toString());
            }
        }
    }
    private String readObjectToString(ObjectInputStream in) {
        Object string = readObject(in);
        if (string instanceof String)
            return (String) string;
        logger.error("Ошибка. Тип не соответствует. Ожидается String");
        return null;
    }

    private Integer readObjectToInteger(ObjectInputStream in) {
        Object integer = readObject(in);
        if (integer instanceof Integer)
            return (Integer) integer;
        logger.error("Ошибка. Тип не соответствует. Ожидается Integer");
        return null;
    }
}
