package conexao;

/**
* @author Alex Da Silva Alves
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FabricaConexao {
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost/estoque", "root", "root");
    }
}
