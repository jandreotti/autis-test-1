package ar.com.orcos.springcloud.orcoswsp;

import it.auties.whatsapp.api.*;
import it.auties.whatsapp.controller.DefaultControllerSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class OrcoswspApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrcoswspApplication.class, args);

    }


}
