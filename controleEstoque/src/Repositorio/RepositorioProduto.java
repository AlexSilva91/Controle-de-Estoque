package Repositorio;

/**
* @author Alex Da Silva Alves
 * 
 */
import conexao.FabricaConexao;
import dados.Memoria;
import dados.PlacaMae;
import dados.Processador;
import dados.ProdutoAbstrato;
import excecoes.ProdutoNaoEncontrado;
import excecoes.RepositorioVazio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RepositorioProduto implements InterfaceRepositorioProduto{
    private Connection conexao;
    private final ArrayList<ProdutoAbstrato> produto;

    public RepositorioProduto() {
        this.produto = new ArrayList<>();
    }
    
    @Override
    public void CadastrarProcessador(ProdutoAbstrato produto) throws SQLException {
       this.conexao = FabricaConexao.getConnection();
       String sql = "INSERT INTO produtoabstrato(velocidade, marca, id, nome, precoCompra, precoVenda, estoque, classe)VALUES(?,?,?,?,?,?,?,?)";
       try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
           stmt.setDouble(1, ((Processador)produto).getVelocidade());
           stmt.setString(2, ((Processador)produto).getMarca());
           stmt.setInt(3, produto.getId());
           stmt.setString(4, produto.getNome());
           stmt.setDouble(5, produto.getPrecoCompra());
           stmt.setDouble(6, produto.getPrecoVenda());
           stmt.setInt(7, produto.getEstoque());
           stmt.setString(8, "Processador");
           stmt.execute();
       }
        this.conexao.close();
    }
 @Override
    public void CadastrarMemoria(ProdutoAbstrato produto) throws SQLException {
       this.conexao = FabricaConexao.getConnection();
       String sql = "INSERT INTO produtoabstrato(velocidade, tipo, armazenamento, id, nome,  precoCompra, precoVenda, estoque, classe)values(?,?,?,?,?,?,?,?,?)";
       try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
           stmt.setDouble(1, ((Memoria)produto).getVelocidade());
           stmt.setString(2, ((Memoria)produto).getTipo());
           stmt.setInt(3, ((Memoria)produto).getArmazenamento());
           stmt.setInt(4, produto.getId());
           stmt.setString(5, produto.getNome());
           stmt.setDouble(6, produto.getPrecoCompra());
           stmt.setDouble(7, produto.getPrecoVenda());
           stmt.setInt(8, produto.getEstoque());
           stmt.setString(9, "Memoria");
           stmt.execute();
       }
        this.conexao.close();
    }
    @Override
    public void CadastrarPlacaMae(ProdutoAbstrato produto) throws SQLException {
       this.conexao = FabricaConexao.getConnection();
       String sql = "INSERT INTO produtoabstrato(soquete, memoriaMax, tipo, id, nome, precoCompra, precoVenda, estoque, classe)values(?,?,?,?,?,?,?,?,?)";
       try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
           stmt.setString(1, ((PlacaMae)produto).getSoquete());
           stmt.setString(2, ((PlacaMae)produto).getMemoriaMax());
           stmt.setString(3, ((PlacaMae)produto).getTipo());
           stmt.setInt(4, produto.getId());
           stmt.setString(5, produto.getNome());
           stmt.setDouble(6, produto.getPrecoCompra());
           stmt.setDouble(7, produto.getPrecoVenda());
           stmt.setInt(8, produto.getEstoque());
           stmt.setString(9, "PlacaMae");
           stmt.execute();
       }
        this.conexao.close();
    }
    @Override
    public ProdutoAbstrato ConsultarProduto(String nome) throws SQLException, ProdutoNaoEncontrado {
        this.conexao = FabricaConexao.getConnection();
        String sql = "select * from produtoabstrato where nome=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next()) {
            stmt.close();
            this.conexao.close();
            throw new ProdutoNaoEncontrado();
        }else{
            ProdutoAbstrato pa = null;
            switch(resultSet.getString("classe")){
                case "Processador":
                    pa = new Processador(resultSet.getDouble("velocidade"), resultSet.getString("marca"), resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("precoCompra"), resultSet.getDouble("precoVenda"), resultSet.getInt("estoque"), resultSet.getString("classe"));
                    break;
                case "PlacaMae":
                     pa = new PlacaMae(resultSet.getString("soquete"), resultSet.getString("memoriaMax"), resultSet.getString("tipo"),resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("precoCompra"), resultSet.getDouble("precoVenda"), resultSet.getInt("estoque"), resultSet.getString("classe"));
                    break;
                case "Memoria":
                     pa = new Memoria(resultSet.getDouble("velocidade"), resultSet.getString("tipo"),resultSet.getInt("armazenamento"), resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("precoCompra"), resultSet.getDouble("precoVenda"), resultSet.getInt("estoque"), resultSet.getString("classe"));
                    break;
            }
            stmt.close();
            this.conexao.close();
            return pa;
        }
    }

    @Override
    public void RemoverProduto(String nome) throws SQLException, ProdutoNaoEncontrado {
        this.conexao = FabricaConexao.getConnection();
        String sql = "delete from produtoabstrato  where nome=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        if (stmt.executeUpdate()==0) {
            stmt.close();
            this.conexao.close();
            throw new ProdutoNaoEncontrado();
        }else{
            stmt.close();
            this.conexao.close();
        }
    }

    @Override
    public void AlterarProduto(ProdutoAbstrato produto) throws SQLException, ProdutoNaoEncontrado {
        this.conexao = FabricaConexao.getConnection();
        String sql = "update produtoabstrato set  precoCompra = ?, precoVenda = ? where nome = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setDouble(1, produto.getPrecoCompra());
        stmt.setDouble(2, produto.getPrecoVenda());
        stmt.setString(3, produto.getNome());
        if (stmt.executeUpdate()==0) {
            stmt.close();
            this.conexao.close();
            throw new ProdutoNaoEncontrado();
        }else{
            stmt.close();
            this.conexao.close();
        }
    }

    @Override
    public ArrayList<ProdutoAbstrato> ListarProduto() throws SQLException, RepositorioVazio {
        ArrayList <ProdutoAbstrato> prod = new ArrayList<>();
        this.conexao = FabricaConexao.getConnection();
        String sql = "select * from produtoabstrato";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        while(resultSet.next()){
            ProdutoAbstrato pd = null;
            switch(resultSet.getString("classe")){
                 case "Processador":
                    pd = new Processador(resultSet.getDouble("velocidade"), resultSet.getString("marca"), resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("precoCompra"), resultSet.getDouble("precoVenda"), resultSet.getInt("estoque"), resultSet.getString("classe"));
                    break;
                case "PlacaMae":
                     pd = new PlacaMae(resultSet.getString("soquete"), resultSet.getString("memoriaMax"), resultSet.getString("tipo"),resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("precoCompra"), resultSet.getDouble("precoVenda"), resultSet.getInt("estoque"), resultSet.getString("classe"));
                    break;
                case "Memoria":
                     pd = new Memoria(resultSet.getDouble("velocidade"), resultSet.getString("tipo"),resultSet.getInt("armazenamento"), resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("precoCompra"), resultSet.getDouble("precoVenda"), resultSet.getInt("estoque"), resultSet.getString("classe"));
                    break;
            }
            prod.add(pd);
        }
        if (prod.isEmpty()) {
            stmt.close();
            this.conexao.close();
            throw new RepositorioVazio();
        }else{
            stmt.close();
            this.conexao.close();
            return prod;
        }
    
}
}