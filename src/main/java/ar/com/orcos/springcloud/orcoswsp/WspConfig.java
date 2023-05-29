package ar.com.orcos.springcloud.orcoswsp;

import it.auties.whatsapp.api.ErrorHandler;
import it.auties.whatsapp.api.WebHistoryLength;
import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.controller.DefaultControllerSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

@Configuration
public class WspConfig {


    @Bean
    public Whatsapp whatsappApi() {

        System.out.println("WspConfig.wsp()");
        Whatsapp w = Whatsapp.webBuilder()
                .serializer(new DefaultControllerSerializer(Path.of("C:\\Users\\Joaquin\\Desktop\\whatsapp4j")))
                .lastConnection()
                .errorHandler(ErrorHandler.toTerminal())
                .build()
                .connect()
                .join();

        w.disconnect();

        System.out.println("FIN WspConfig.wsp()");

        return w;
    }

}
