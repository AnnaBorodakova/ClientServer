package server;

import interfaces.IController;
import interfaces.IModel;
import logger.LoggerCS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
        private final static LoggerCS logger = new LoggerCS(Server.class);
        private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public void startServer(int port, IModel model, IController controller) {
        logger.info("Сервер запускается на порту: " + port);
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (!server.isClosed()) {
                Socket client = server.accept();
                logger.info("Подключился пользователь");
                executorService.execute(new FitServerSocket(client, model, controller));
            }
        } catch (IOException e) {
            logger.error(e.toString());
        }
        executorService.shutdown();
        logger.info("Сервер выключается");
    }

}

