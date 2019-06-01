package mvc_template.model.vo;

/**
 *
 * 
 */
public class Esporte {
    
    private int id; 
    private String nome;
    private int quantidade_pessoas;

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
    
    
}
