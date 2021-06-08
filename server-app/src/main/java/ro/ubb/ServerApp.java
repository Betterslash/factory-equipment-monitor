package ro.ubb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.tcp.Server;

public class ServerApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.config");
        var server = context.getBean(Server.class);
        server.startServer();
        System.out.println("bye server");
    }
}
