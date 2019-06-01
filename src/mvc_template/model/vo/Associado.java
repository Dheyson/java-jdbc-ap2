package mvc_template.model.vo;

// 

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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the data_nascimento
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the data_associacao
     */
    public Date getData_associacao() {
        return data_associacao;
    }

    /**
     * @param data_associacao the data_associacao to set
     */
    public void setData_associacao(Date data_associacao) {
        this.data_associacao = data_associacao;
    }

    /**
     * @return the times_id
     */
    public int getTimes_id() {
        return times_id;
    }

    /**
     * @param times_id the times_id to set
     */
    public void setTimes_id(int times_id) {
        this.times_id = times_id;
    }

 
    
}