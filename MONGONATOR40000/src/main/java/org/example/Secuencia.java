package org.example;

import org.example.models.LosJojos;
import org.example.models.Personaxe;
import org.example.models.Saga;
import org.example.services.ConexionMongoService;
import org.example.services.ConexionPostgresService;
import org.example.services.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Secuencia {

    @Autowired
    private ConexionMongoService conexionMongoService;
    @Autowired
    private ConexionPostgresService conexionPostgresService;
    @Autowired
    private JsonService jsonService;

    public void executar() {

        ArrayList<Personaxe> listaPersonaxes = new ArrayList<>();

        Personaxe GG = new Personaxe();
        GG.setNome("Giorno Giovanna");
        GG.setStand("Gold Experience");
        Personaxe BB = new Personaxe();
        BB.setNome(" Bruno Bucciarati");
        BB.setStand("Sticky Fingers");
        Personaxe GM = new Personaxe();
        GM.setNome("Guido Mista");
        GM.setStand("Sex Pistols");


        listaPersonaxes.add(GG);
        listaPersonaxes.add(BB);
        listaPersonaxes.add(GM);

        Saga VA = new Saga();

        VA.setTitulo("Vento Aureo");
        VA.setParte(5);
        VA.setAmbientacion("Italia");
        VA.setAnoinicio(2001);
        VA.setListaPersonaxes(listaPersonaxes);

        VA = conexionPostgresService.crearSaga(VA);


        listaPersonaxes = new ArrayList<>();

        Personaxe JK = new Personaxe();
        JK.setNome("Joselyn Kujo");
        JK.setStand("Stone Free");

        listaPersonaxes.add(JK);

        Saga SO = new Saga();
        SO.setTitulo("Stone Ocean");
        SO.setParte(6);
        SO.setAmbientacion("USA");
        SO.setAnoinicio(2011);
        SO.setPersonaxes(listaPersonaxes);

        SO = conexionPostgresService.crearSaga(SO);


        Saga BT = conexionPostgresService.listarSaga(2L);
        Saga SDC = conexionPostgresService.listarSaga(3L);


        Saga DIU = conexionPostgresService.findByTitulo("Diamond is Unbreakable");

        conexionMongoService.crearSaga(DIU);

        List<Saga> sagas = new ArrayList<>();

        sagas = conexionPostgresService.listarTodasAsSagas();
        for (Saga saga : sagas) {
            conexionMongoService.crearSaga(saga);
        }

        LosJojos lj = new LosJojos();
        lj.setSagas(sagas);
        conexionMongoService.crearLosJojos(lj);
        jsonService.exportarLosJojosJson(conexionMongoService.listarJojos());
        jsonService.exportarSagasJson(conexionMongoService.listarTodasAsSagas());


        for (Saga s : sagas) {
            conexionMongoService.borrarSagaPorId(s.getIdsaga());
            conexionPostgresService.borrarSagaPorId(s.getIdsaga());
        }
    }
}





