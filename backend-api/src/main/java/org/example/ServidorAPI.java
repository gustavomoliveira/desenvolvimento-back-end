package org.example;

import io.javalin.Javalin;
import org.example.api.AuthController;

public class ServidorAPI {
    public static void main(String[] args) {
        var app = Javalin.create();

        AuthController.registrarRotas(app);

        app.start();
    }
}
