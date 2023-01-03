package Repositorio;

/**
* @author Alex Da Silva Alves
 * 
 */
import dados.ProdutoAbstrato;
import excecoes.ProdutoNaoEncontrado;
import excecoes.RepositorioVazio;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceRepositorioProduto {
    public void CadastrarProcessador(ProdutoAbstrato produto) throws SQLException;
    public void CadastrarMemoria(ProdutoAbstrato produto) throws SQLException;  
    public void CadastrarPlacaMae(ProdutoAbstrato produto) throws SQLException;
    public ProdutoAbstrato ConsultarProduto(String nome)throws SQLException, ProdutoNaoEncontrado;
    public void RemoverProduto(String nome) throws SQLException, ProdutoNaoEncontrado;
    public void AlterarProduto(ProdutoAbstrato produto)throws SQLException, ProdutoNaoEncontrado;
    public ArrayList<ProdutoAbstrato> ListarProduto()throws SQLException, RepositorioVazio;
}
