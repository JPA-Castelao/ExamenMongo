package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "personaxes")
public class Personaxe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String stand;
    @ManyToOne
    @JoinColumn(name = "idsaga")
    @JsonBackReference
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Saga idsaga;

    public Personaxe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public Saga getSaga() {
        return idsaga;
    }

    public void setSaga(Saga idsaga) {
        this.idsaga = idsaga;
    }
}
