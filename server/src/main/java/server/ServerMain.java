package server;

import controller.Controller;
import interfaces.IController;
import interfaces.IModel;
import model.Model;

public class ServerMain {
    public static void main(String[] args) {
        int port;
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }else{
            port = 7878;
        }
        IController controller = new Controller();
        IModel model = new Model();
        controller.setModel(model);
        Server server = new Server();
        server.startServer(port, model, controller);
    }
}
