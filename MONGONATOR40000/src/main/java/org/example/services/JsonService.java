package org.example.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.models.LosJojos;
import org.example.models.Saga;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.List;

@Service
public class JsonService {

    public void exportarLosJojosJson(List<LosJojos> losjojos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escritor = new FileWriter(
      "E:\\DAM\\ad\\ExamenMongo\\MONGONATOR40000\\src\\main\\java\\org\\example\\json\\LosJojos.json"
        )) {
            String json = gson.toJson(losjojos);
            escritor.write(json);
        } catch (Exception e) {
            System.out.println("Error al exportar. " + e.getMessage());
        }
    }

    public void exportarSagasJson(List<Saga> sagas) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escritor = new FileWriter(
"E:\\DAM\\ad\\ExamenMongo\\MONGONATOR40000\\src\\main\\java\\org\\example\\json\\Sagas.json")) {
            String json = gson.toJson(sagas);
            escritor.write(json);
        } catch (Exception e) {
            System.out.println("Error al exportar. " + e.getMessage());
        }
    }

}
