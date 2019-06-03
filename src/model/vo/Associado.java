package model.vo;

import java.util.ArrayList;
import java.util.Date;

public class Associado {
    
    private int id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String email;
    private Date data_nascimento;
    private char sexo;
    private Date data_associacao;
    private int times_id;
    private Endereco endereco;
    private ArrayList<String> telefones;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getData_associacao() {
        return data_associacao;
    }

    public void setData_associacao(Date data_associacao) {
        this.data_associacao = data_associacao;
    }

    public int getTimes_id() {
        return times_id;
    }

    public void setTimes_id(int times_id) {
        this.times_id = times_id;
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