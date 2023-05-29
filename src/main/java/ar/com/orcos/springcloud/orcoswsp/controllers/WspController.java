package ar.com.orcos.springcloud.orcoswsp.controllers;

import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.model.contact.ContactJid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class WspController {

    @Autowired
    private Whatsapp whatsappApi;

    @RequestMapping("/enviar")
    public ResponseEntity<?> test() {
        //ENVIAR MENSAJE
        // 1º Obtengo el chat
        var chat = whatsappApi.store()
                .findChatByJid(ContactJid.of("5493515925801@s.whatsapp.net"))
                //.findChatByName("My Awesome Friend")
                .orElseThrow(() -> new NoSuchElementException("Hey, you don't exist"));

        // 2º Envio el mensaje(deacuerdo al tipo)
        //1
        whatsappApi.sendMessage(chat, "Prueba Envio");

        return ResponseEntity.ok("Mensaje Enviado");
    }

    @GetMapping("/test2")
    public ResponseEntity<?> test2() {
        return ResponseEntity.ok("Hola Mundo");
    }

}
