package negocio;
/**
* @author Alex Da Silva Alves
 * 
 */
import Repositorio.RepositorioProduto;
import dados.ProdutoAbstrato;
import excecoes.ProdutoNaoEncontrado;
import excecoes.RepositorioVazio;
import java.sql.SQLException;
import java.util.ArrayList;

public class NegocioProduto implements InterfaceNegocio{
    private RepositorioProduto repositorio;
    
    public NegocioProduto(int MAX) {
        this.repositorio = new RepositorioProduto();
    }
    

    
    @Override
    public void CadastrarProcessador(ProdutoAbstrato produto) throws SQLException {
        this.repositorio.CadastrarProcessador(produto);
    }
@Override
    public void CadastrarMemoria(ProdutoAbstrato produto) throws SQLException {
        this.repositorio.CadastrarMemoria(produto);
    }
    @Override
    public void CadastrarPlacaMae(ProdutoAbstrato produto) throws SQLException {
        this.repositorio.CadastrarPlacaMae(produto);
    }
    @Override
    public ProdutoAbstrato ConsultarProduto(String nome) throws SQLException, ProdutoNaoEncontrado {
        return this.repositorio.ConsultarProduto(nome);
    }

    @Override
    public void RemoverProduto(String nome) throws SQLException, ProdutoNaoEncontrado {
        this.repositorio.RemoverProduto(nome);
    }

    @Override
    public void AlterarProduto(ProdutoAbstrato produto) throws SQLException, ProdutoNaoEncontrado {
        this.repositorio.AlterarProduto(produto);
    }

    @Override
    public ArrayList<ProdutoAbstrato> ListarProduto() throws SQLException, RepositorioVazio {
        return this.repositorio.ListarProduto();
    }
    
}
