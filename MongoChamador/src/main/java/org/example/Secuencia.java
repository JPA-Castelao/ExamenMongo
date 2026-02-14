package org.example;

import org.example.model.LosJojos;
import org.example.model.Personaxe;
import org.example.model.Saga;
import org.example.service.ConexionService;
import org.example.service.LosJojosService;
import org.example.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Secuencia {

    @Autowired
    private ConexionService conexionService;

    @Autowired
    private SagaService sagaService;

    @Autowired
    private LosJojosService losJojosService;

    public void executar() {

        ArrayList<Personaxe> personaxes = new ArrayList<>();

        Personaxe GG = new Personaxe();
        GG.setNome("Giorno Giovanna");
        GG.setStand("Gold Experience");

        personaxes.add(GG);

        Personaxe BB = new Personaxe();
        BB.setNome("Bruno Bucciarati");
        BB.setStand("Sticky Fingers");

        personaxes.add(BB);

        Personaxe GM = new Personaxe();
        GM.setNome("Guido Mista");
        GM.setStand("Sex Pistols");
        personaxes.add(GM);

        Saga VA = new Saga();
        VA.setTitulo("Vento Aureo");
        VA.setParte(5);
        VA.setAmbientacion("Italia");
        VA.setAnoinicio(2001);
        VA.setPersonaxes(personaxes);

        personaxes.clear();

        Personaxe JK = new Personaxe();
        JK.setNome("Joselyn Kujo");
        JK.setStand("Stone Free");

        personaxes.add(JK);

        Saga SO = new Saga();
        SO.setTitulo("Stone Ocean");
        SO.setParte(6);
        SO.setAmbientacion("USA");
        SO.setAnoinicio(2011);
        SO.setPersonaxes(personaxes);

        // SO = conexionService.crearSaga(SO);
//        VA = conexionService.crearSaga(VA);


        System.out.println("VA: " + VA.getTitulo());
        System.out.println("VA: " + VA.getIdsaga());
        Saga BT = conexionService.listarSaga(2L);
        Saga SDC = conexionService.listarSaga(3L);
        System.out.println("SC: " + BT.getTitulo());
        System.out.println("SC: " + BT.getIdsaga());

        Saga DIU = conexionService.findByTitulo("Diamond is Unbreakable");

//        sagaService.save(DIU);

        List<Saga> sagas = new ArrayList<>();

        sagas = conexionService.listarTodasAsSagas();
//        for (Saga saga : sagas) {
//            sagaService.save(saga);
//        }

        LosJojos lj = new LosJojos();
        lj.setSagas(sagas);
        losJojosService.save(lj);
        losJojosService.exportarJson();


        for (Saga s : sagas) {
            sagaService.deleteById(s.getIdsaga());
            conexionService.borrarSagaPorId(s.getIdsaga());
        }
    }
}
