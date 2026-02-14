package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Saga;
import org.example.repository.RepositorySaga;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.List;
import java.util.Optional;

@Service
public class SagaService {


    private RepositorySaga repositorySaga;


    public SagaService(RepositorySaga repositorySaga) {
        this.repositorySaga = repositorySaga;
    }

    //Leer todas as sagas
    public List<Saga> findAll() {
        return repositorySaga.findAll();
    }

    //Leer por id
    public Optional<Saga> findById(Long id) {

        return repositorySaga.findById(id);
    }

    //gardar saga

    public Saga save(Saga saga) {
        return repositorySaga.save(saga);
    }

    //borrar por id

    public void deleteById(Long id) {
        repositorySaga.deleteById(id);
    }

    //exists por id
    public boolean existsById(Long id) {
        return repositorySaga.existsById(id);
    }





}
