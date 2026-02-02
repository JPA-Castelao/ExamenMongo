package org.example.model;

public class Saga {

    private String titulo;
    private String parte;
    private String ambientacion;
    private String anoinicio;

    public Saga() {
    }

    public Saga(String titulo, String parte, String ambientacion, String anoinicio) {
        this.titulo = titulo;
        this.parte = parte;
        this.ambientacion = ambientacion;
        this.anoinicio = anoinicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public String getAmbientacion() {
        return ambientacion;
    }

    public void setAmbientacion(String ambientacion) {
        this.ambientacion = ambientacion;
    }

    public String getAnoinicio() {
        return anoinicio;
    }

    public void setAnoinicio(String anoinicio) {
        this.anoinicio = anoinicio;
    }
}
