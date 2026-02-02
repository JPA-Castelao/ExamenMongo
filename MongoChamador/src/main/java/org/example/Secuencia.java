package org.example;

import org.example.model.Personaxe;
import org.example.model.Saga;
import org.example.service.ConexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Secuencia {

    @Autowired
    private ConexionService conexionService;

    @Autowired


    public void executar() {

        Saga VA = new Saga("Vento Aureo", "5", "Italia", "2001");
        Personaxe GG = new Personaxe("Giorno Giovanna", "Gold Experience");

        ConexionService cs = new ConexionService();
        cs.crearSaga(VA);
        cs.crearPersonaxe(GG);

        System.out.println("josuke best best jojo");


    }
}
