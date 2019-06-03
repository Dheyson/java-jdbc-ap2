package model.vo;

import java.util.ArrayList;

/**
 *
 * 
 */
public class Tecnico {
    
    private int id;
    private String nome;
    private String sobrenome;
    private String especializacao;
    private Endereco endereco;
    private ArrayList<String> telefones;

    
  
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<String> telefones) {
        this.telefones = telefones;
    }
    
}
