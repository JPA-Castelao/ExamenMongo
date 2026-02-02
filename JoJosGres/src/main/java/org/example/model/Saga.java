package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sagas")
public class Saga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsaga;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "parte")
    private int parte;
    @Column(name = "ambientacion")
    private String ambientacion;
    @Column(name = "anoinicio")
    private int anoinicio;

    @OneToMany(mappedBy = "idsaga")
    @JsonManagedReference
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<Personaxe> listaPersonaxes;

    public Saga() {
    }

    public Long getId() {
        return idsaga;
    }

    public void setId(Long id) {
        this.idsaga = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getParte() {
        return parte;
    }

    public void setParte(int parte) {
        this.parte = parte;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAmbientacion() {
        return ambientacion;
    }

    public void setAmbientacion(String ambientacion) {
        this.ambientacion = ambientacion;
    }

    public int getAnoinicio() {
        return anoinicio;
    }

    public void setAnoinicio(int anoinicio) {
        this.anoinicio = anoinicio;
    }


}
