package org.example.controller;

import org.example.model.Saga;
import org.example.model.Personaxe;
import org.example.service.SagaService;
import org.example.service.PersonaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestSagas.MAPPING)
public class RestSagas {

    public static final String MAPPING = "/postgres/sagas";

    @Autowired
    private SagaService sagaService;
    @Autowired
    private PersonaxeService personaxeService;


    @GetMapping
    public List<Saga> getAll() {
        return sagaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saga> getById(@PathVariable Long id) {
        return sagaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Saga> create(@RequestBody Saga saga) {
        Saga gardado = sagaService.save(saga);
        return ResponseEntity.ok(gardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!sagaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sagaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Saga> update(@PathVariable Long id,
                                       @RequestBody Saga saga) {

        var sagaParaBuscar = sagaService.findById(id);
        if (sagaParaBuscar.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Saga sagaParaActualizar = sagaParaBuscar.get();
        sagaParaActualizar.setTitulo(saga.getTitulo());
        sagaParaActualizar.setParte(saga.getParte());
        sagaParaActualizar.setAmbientacion(saga.getAmbientacion());
        sagaParaActualizar.setAnoinicio(saga.getAnoinicio());

        return ResponseEntity.ok(sagaService.save(sagaParaActualizar));

    }


}