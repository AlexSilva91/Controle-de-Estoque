package dados;

/**
* @author Alex Da Silva Alves
 * 
 */
public class PlacaMae extends ProdutoAbstrato{
    private String soquete;
    private String memoriaMax;
    private String tipo;

    public PlacaMae(String soquete, String memoriaMax, String tipo, int id, String nome, double precoCompra, double precoVenda, int estoque, String classe) {
        super(id, nome, precoCompra, precoVenda, estoque, classe);
        this.soquete = soquete;
        this.memoriaMax = memoriaMax;
        this.tipo = tipo;
    }
    
   

    public String getSoquete() {
        return soquete;
    }

    public void setSoquete(String soquete) {
        this.soquete = soquete;
    }

    public String getMemoriaMax() {
        return memoriaMax;
    }

    public void setMemoriaMax(String memoriaMax) {
        this.memoriaMax = memoriaMax;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
