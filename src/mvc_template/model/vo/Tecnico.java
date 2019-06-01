package mvc_template.model.vo;

/**
 *
 * 
 */
public class Tecnico {
    
    private int id;
    private String nome;
    private String sobrenome;
    private String especializacao;

    
    
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

    /**
     * @return the registro
     */
    public int getId() {
        return id;
    }

    /**
     * @param registro the registro to set
     */
    public void setID(int registro) {
        this.id = registro;
    }
    
    
}
