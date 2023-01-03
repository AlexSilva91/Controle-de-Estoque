package excecoes;
/**
* @author Alex Da Silva Alves
 * 
 */

public class ProdutoNaoEncontrado extends Exception{
    public ProdutoNaoEncontrado(){ 
         super("Produto não encontrado!");
   }
}
