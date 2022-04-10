package org.finalProject.client;

import org.finalProject.client.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ClientApplication.class, args);
        ClientService clientService = ctx.getBean(ClientService.class);

        System.out.println("===== balance:\t" + clientService.requestBalance().getBalance() + " =====");
    }
}
