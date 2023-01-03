package dados;

/**
* @author Alex Da Silva Alves
 * 
 */
public class Memoria extends ProdutoAbstrato{
    private double velocidade;
    private String tipo;
    private int armazenamento;

    public Memoria(double velocidade, String tipo, int armazenamento, int id, String nome, double precoCompra, double precoVenda, int estoque, String classe) {
        super(id, nome, precoCompra, precoVenda, estoque, classe);
        this.velocidade = velocidade;
        this.tipo = tipo;
        this.armazenamento = armazenamento;
    }
    
   

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }
    
    
}
