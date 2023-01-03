package dados;

/**
* @author Alex Da Silva Alves
 * 
 */
public class Processador extends ProdutoAbstrato{
    private double velocidade;
    private String marca;

    public Processador(double velocidade, String marca, int id, String nome, double precoCompra, double precoVenda, int estoque, String classe) {
        super(id, nome, precoCompra, precoVenda, estoque, classe);
        this.velocidade = velocidade;
        this.marca = marca;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
    
}
