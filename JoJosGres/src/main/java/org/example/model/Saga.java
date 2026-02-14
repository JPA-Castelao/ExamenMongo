package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sagas")
public class Saga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsaga")
    private Long idsaga;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "parte")
    private int parte;
    @Column(name = "ambientacion")
    private String ambientacion;
    @Column(name = "anoinicio")
    private int anoinicio;

    @OneToMany(mappedBy = "saga", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Personaxe> listaPersonaxes;

    public Saga() {
    }

    @Override
    public String toString() {
        return "Saga{" +
                "idsaga=" + idsaga +
                ", titulo='" + titulo + '\'' +
                ", parte=" + parte +
                ", ambientacion='" + ambientacion + '\'' +
                ", anoinicio=" + anoinicio +
                ", listaPersonaxes=" + listaPersonaxes +
                '}';
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

    public List<Personaxe> getListaPersonaxes() {
        return listaPersonaxes;
    }

    public void setListaPersonaxes(List<Personaxe> listaPersonaxes) {
        this.listaPersonaxes = listaPersonaxes;
    }

    public Long getIdsaga() {
        return idsaga;
    }

    public void setIdsaga(Long idsaga) {
        this.idsaga = idsaga;
    }


}
