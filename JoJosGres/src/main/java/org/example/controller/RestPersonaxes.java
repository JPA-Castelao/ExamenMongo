package org.example.controller;

import org.example.model.Personaxe;
import org.example.model.Saga;
import org.example.service.PersonaxeService;
import org.example.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPersonaxes.MAPPING)
public class RestPersonaxes {

    public static final String MAPPING = "/probas/personaxes";

    @Autowired
    private SagaService sagaService;
    @Autowired
    private PersonaxeService personaxeService;


    @GetMapping
    public List<Personaxe> getAll() {
        return personaxeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personaxe> getById(@PathVariable Long id) {
        return personaxeService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Personaxe> create(@RequestBody Personaxe personaxe) {
        if (personaxe.getSaga() != null && personaxe.getSaga().getIdsaga() != null) {
            Saga sag = sagaService.findById(personaxe.getSaga().getIdsaga()).orElse(null);

            if (sag == null) {
                ResponseEntity.badRequest().build();
            }
            personaxe.setSaga(sag);

        }
        Personaxe gardado = personaxeService.save(personaxe);
        return ResponseEntity.ok(gardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!personaxeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        personaxeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}