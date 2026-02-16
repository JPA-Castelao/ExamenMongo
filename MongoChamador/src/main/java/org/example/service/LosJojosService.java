package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.LosJojos;
import org.example.repository.RepositoryLosJojos;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@Service
public class LosJojosService {

    private RepositoryLosJojos rlj;

    public LosJojosService(RepositoryLosJojos rlj) {
        this.rlj = rlj;


    }

    public LosJojos save(LosJojos lj) {

        return rlj.save(lj);
    }

    public List<LosJojos> findAll() {
        return rlj.findAll();
    }

    public void exportarJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<LosJojos> ls = rlj.findAll();
        try (FileWriter escritor = new FileWriter("E:\\DAM\\ad\\ExamenMongo\\MongoChamador\\src\\main\\java\\org\\example\\LosJoJos.json")) {

            String json = gson.toJson(ls);
            escritor.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
