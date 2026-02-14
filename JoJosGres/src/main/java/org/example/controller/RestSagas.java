package org.example.controller;

import org.example.model.Saga;
import org.example.service.PersonaxeService;
import org.example.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestSagas.MAPPING)
public class RestSagas {

    public static final String MAPPING = "/probas/sagas";

    @Autowired
    private SagaService sagaService;
    @Autowired
    private PersonaxeService personaxeService;


    @GetMapping
    public List<Saga> findAll() {
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

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Saga>> getByTitulo(@PathVariable String titulo) {
        List<Saga> sagas = sagaService.getByTitulo(titulo);
        if (sagas == null || sagas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sagas);
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