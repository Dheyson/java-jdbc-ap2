package model.vo;

import java.util.ArrayList;


public class Esporte {
    
    private int id; 
    private String nome;
    private int quantidade_pessoas;
    private ArrayList<Treino> teinos;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade_pessoas() {
        return quantidade_pessoas;
    }

    public void setQuantidade_pessoas(int quantidade_pessoas) {
        this.quantidade_pessoas = quantidade_pessoas;
    }

    public ArrayList<Treino> getTeinos() {
        return teinos;
    }

    public void setTeinos(ArrayList<Treino> teinos) {
        this.teinos = teinos;
    }
 
}
