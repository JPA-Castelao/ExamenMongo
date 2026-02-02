package org.example.model;

public class Personaxe {


        private String nome;
        private String stand;
        private String idsaga;

        public Personaxe() {
        }

    public Personaxe(String nome, String stand) {
        this.nome = nome;
        this.stand = stand;
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

        public String getIdsaga() {
            return idsaga;
        }

        public void setIdsaga(String idsaga) {
            this.idsaga = idsaga;
        }
    }
