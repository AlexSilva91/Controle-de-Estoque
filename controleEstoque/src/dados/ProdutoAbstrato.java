package dados;


/**
* @author Alex Da Silva Alves
 * 
 */
public abstract class ProdutoAbstrato {
    private int id;
    private String nome;
    private double precoCompra, precoVenda;
    private int estoque;
    private String classe;

    public ProdutoAbstrato(int id, String nome, double precoCompra, double precoVenda, int estoque, String classe) {
        this.id = id;
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.classe = classe;
    }

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

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }


    
}
