package fachada;
/**
* @author Alex Da Silva Alves
 * 
 */
import dados.ProdutoAbstrato;
import excecoes.ProdutoNaoEncontrado;
import excecoes.RepositorioVazio;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.NegocioProduto;


public class ProdutoFachada implements InterfaceFachada{
    private NegocioProduto negocioProduto;
    
    public ProdutoFachada(int MAX) {
        this.negocioProduto = new NegocioProduto(MAX);
    }
    
    @Override
    public void CadastrarProcessador(ProdutoAbstrato produto) throws SQLException {
        this.negocioProduto.CadastrarProcessador(produto);
    }
     @Override
    public void CadastrarMemoria(ProdutoAbstrato produto) throws SQLException {
        this.negocioProduto.CadastrarMemoria(produto);
    }
@Override
    public void CadastrarPlacaMae(ProdutoAbstrato produto) throws SQLException {
        this.negocioProduto.CadastrarPlacaMae(produto);
    }
    @Override
    public ProdutoAbstrato ConsultarProduto(String nome) throws SQLException, ProdutoNaoEncontrado {
        return this.negocioProduto.ConsultarProduto(nome);
    }

    @Override
    public void RemoverProduto(String nome) throws SQLException, ProdutoNaoEncontrado {
        this.negocioProduto.RemoverProduto(nome);
    }

    @Override
    public void AlterarProduto(ProdutoAbstrato produto) throws SQLException, ProdutoNaoEncontrado {
        this.negocioProduto.AlterarProduto(produto);
    }

    @Override
    public ArrayList<ProdutoAbstrato> ListarProduto() throws SQLException, RepositorioVazio {
        return this.negocioProduto.ListarProduto();
    }
    
}
