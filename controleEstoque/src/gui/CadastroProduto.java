package gui;

/**
* @author Alex Da Silva Alves
 *
 */
import dados.Memoria;
import dados.PlacaMae;
import dados.Processador;
import dados.ProdutoAbstrato;
import excecoes.ProdutoNaoEncontrado;
import excecoes.RepositorioVazio;
import fachada.ProdutoFachada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class CadastroProduto {
    static final int MAX = 100;
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        ProdutoFachada produtoFachada = new ProdutoFachada(MAX);
        ArrayList<ProdutoAbstrato> produtoAbstratoArray;
        ProdutoAbstrato produtoAbstrato;
        Memoria memoria;
        PlacaMae placaMae;
        Processador processador;
        int op, op1, op2, op3;
        String nome, marca, classe, soquete, memoriamax, tipo;
        double precoCompra, precoVenda, velocidade;
        int id = 0, estoque, armazenamento;
        do{
           System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
           System.out.println("=-=-=-=-=-=-=-=-Controle De Estoque=-=-=-=-=-=-=-=-");
           System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
           System.out.println("0 -- Sair");
           System.out.println("1 -- Cadastrar Produto");
           System.out.println("2 -- Consultar Produto");
           System.out.println("3 -- Listar Produto");
           System.out.println("4 -- Remover Poduto");
           System.out.println("5 -- Atualizar Poduto");
           System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
           System.out.print("Digite sua opção: ");
           op = tc.nextInt();
           switch(op){
               case 0:
                   System.out.println();
                   System.out.println("Até logo...");
                   break;
               case 1:
                       do{
                           System.out.println("\n********************************");
                           System.out.println("***********CADASTRAR************");
                           System.out.println("********************************");
                           System.out.println("0 -- Voltar");
                           System.out.println("1 -- Processador");
                           System.out.println("2 -- Placa Mãe");
                           System.out.println("3 -- Memória");
                           System.out.println("********************************");
                           System.out.print("Digite sua opção: ");
                           op1 = tc.nextInt();
                           switch(op1){
                               case 0:
                                   break;
                               case 1:
                                   try{
                                      System.out.print("\nNome: ");
                                       nome = tc.next();
                                       System.out.print("\nMarca: ");
                                       marca = tc.next();
                                       System.out.print("\nVelocidade: ");
                                       velocidade = tc.nextDouble();
                                       System.out.print("\nPreço de compra: R$ ");
                                       precoCompra = tc.nextDouble();
                                       System.out.print("\nPreço de venda: R$ ");
                                       precoVenda = tc.nextDouble();
                                       System.out.print("\nEstoque: ");
                                       estoque = tc.nextInt();
                                       classe = " ";
                                       processador = new Processador(velocidade, marca, id,  nome,  precoCompra,  precoVenda,  estoque, classe);
                                       produtoFachada.CadastrarProcessador(processador);
                                       System.out.println("\nOperação realizada com sucesso!");
                                   }catch(SQLException msg){
                                       System.out.println(msg.getMessage());
                                   }
                                   break;
                               case 2:       
                                   try{
                                       System.out.print("\nNome: ");
                                       nome = tc.next();
                                       System.out.print("\nMarca: ");
                                       marca = tc.next();
                                       System.out.print("\nSoquete: ");
                                       soquete = tc.next();
                                       System.out.print("\nMemória máxima: ");
                                       memoriamax = tc.next();
                                       System.out.print("\nTipo: ");
                                       tipo = tc.next();
                                       System.out.print("\nVelocidade: ");
                                       velocidade = tc.nextDouble();
                                       System.out.print("\nPreço de compra: R$ ");
                                       precoCompra = tc.nextDouble();
                                       System.out.print("\nPreço de venda: R$ ");
                                       precoVenda = tc.nextDouble();
                                       System.out.print("\nEstoque: ");
                                       estoque = tc.nextInt();
                                       classe = " ";
                                       placaMae = new PlacaMae(soquete, memoriamax, tipo, id, nome, precoCompra, precoVenda, estoque, classe);
                                       produtoFachada.CadastrarPlacaMae(placaMae);
                                       System.out.println("\nOperação realizada com sucesso!");
                                   }catch(SQLException msg){
                                       System.out.println(msg.getMessage());
                                   }
                                   break;
                               case 3:
                                    try{
                                       System.out.print("\nNome: ");
                                       nome = tc.next();
                                       System.out.print("\nArmazenamento: ");
                                       armazenamento = tc.nextInt();
                                       System.out.print("\nTipo: ");
                                       tipo = tc.next();
                                       System.out.print("\nVelocidade: ");
                                       velocidade = tc.nextDouble();
                                       System.out.print("\nPreço de compra: R$ ");
                                       precoCompra = tc.nextDouble();
                                       System.out.print("\nPreço de venda: R$ ");
                                       precoVenda = tc.nextDouble();
                                       System.out.print("\nEstoque: ");
                                       estoque = tc.nextInt();
                                       classe = " ";
                                       memoria = new Memoria(velocidade, tipo, armazenamento, id, nome, precoCompra,  precoVenda,  estoque, classe);
                                       produtoFachada.CadastrarMemoria(memoria);
                                       System.out.println("\nOperação realizada com sucesso!");
                                   }catch(SQLException msg){
                                       System.out.println(msg.getMessage());
                                   }
                                   break;
                           }
                       }while(op1!=0);
                   break;
               case 2:
                   try{
                       System.out.println();
                       System.out.print("Nome: ");
                       nome = tc.next();
                       produtoAbstrato = produtoFachada.ConsultarProduto(nome);
                       System.out.println("\nID: "+produtoAbstrato.getId());
                       System.out.println("Nome: "+produtoAbstrato.getNome());
                       if (produtoAbstrato instanceof Processador) {
                           System.out.println("Velocidade: "+((Processador) produtoAbstrato).getVelocidade());
                           System.out.println("Marca: "+((Processador) produtoAbstrato).getMarca());
                       }else if(produtoAbstrato instanceof PlacaMae){
                           System.out.println("Soquete: "+((PlacaMae) produtoAbstrato).getSoquete());
                           System.out.println("Memória maxima: "+((PlacaMae) produtoAbstrato).getMemoriaMax());
                           System.out.println("Tipo: "+((PlacaMae) produtoAbstrato).getTipo());
                       }else if (produtoAbstrato instanceof Memoria){
                           System.out.println("Velocidade: "+((Memoria) produtoAbstrato).getVelocidade());
                           System.out.println("Tipo: "+((Memoria) produtoAbstrato).getTipo());
                           System.out.println("Armezenamento: "+((Memoria) produtoAbstrato).getArmazenamento());
                       }
                       System.out.println("Classe: "+produtoAbstrato.getClasse());
                       System.out.println("Preço de Compra: R$ "+produtoAbstrato.getPrecoCompra());
                       System.out.println("Preço de venda: R$ "+produtoAbstrato.getPrecoVenda());
                       System.out.println("Estoque: "+produtoAbstrato.getEstoque());
                   }catch(SQLException | ProdutoNaoEncontrado msg){
                       System.out.println();
                       System.out.println(msg.getMessage());
                   }
                   break;
               case 3:
                   try{
                       ArrayList<ProdutoAbstrato> produtoList = produtoFachada.ListarProduto();
                       for (ProdutoAbstrato prod : produtoList) {
                           System.out.println("\nID: "+prod.getId());
                       System.out.println("Nome: "+prod.getNome());
                       if (prod instanceof Processador) {
                          
                           System.out.println("Velocidade: "+((Processador) prod).getVelocidade());
                           System.out.println("Marca: "+((Processador) prod).getMarca());
                       }else if(prod instanceof PlacaMae){
                           System.out.println("Soquete: "+((PlacaMae) prod).getSoquete());
                           System.out.println("Memória maxima: "+((PlacaMae) prod).getMemoriaMax());
                           System.out.println("Tipo: "+((PlacaMae) prod).getTipo());
                       }else if (prod instanceof Memoria){
                           System.out.println("Velocidade: "+((Memoria) prod).getVelocidade());
                           System.out.println("Tipo: "+((Memoria) prod).getTipo());
                           System.out.println("Armezenamento: "+((Memoria) prod).getArmazenamento());
                       }
                       System.out.println("Classe: "+prod.getClasse());
                       System.out.println("Preço de Compra: R$ "+prod.getPrecoCompra());
                       System.out.println("Preço de venda: R$ "+prod.getPrecoVenda());
                       System.out.println("Estoque: "+prod.getEstoque());
                       }
                   }catch(SQLException | RepositorioVazio msg){
                       System.out.println();
                       System.out.println(msg.getMessage());
                   }
                   break;
               case 4:
                   try{
                       System.out.println("\n");
                       System.out.print("Nome: ");
                       nome = tc.next();
                       produtoFachada.RemoverProduto(nome);
                       System.out.println("\nOperação Realizada com sucesso!");
                   }catch(SQLException |  ProdutoNaoEncontrado msg){
                       System.out.println("");
                       System.out.println(msg.getMessage());
                   }
                   break;
               case 5:
                   try{
                       System.out.print("\nNome: ");
                       nome = tc.next();
                       produtoAbstrato = produtoFachada.ConsultarProduto(nome);
                       do{
                           System.out.println("\n********************************");
                           System.out.println("***********ATUALIZAR************");
                           System.out.println("********************************");
                           System.out.println("0 -- Voltar");
                           System.out.println("1 -- Valor de compra");
                           System.out.println("2 -- Valor de Venda");
                           System.out.println("********************************");
                           System.out.print("Digite sua opção: ");
                           op2 = tc.nextInt();
                           switch(op2){
                               case 0:
                                   break;
                               case 1:
                                   System.out.print("\nNovo valor: R$ ");
                                   precoCompra = tc.nextDouble();
                                   produtoAbstrato.setPrecoCompra(precoCompra);
                                   produtoFachada.AlterarProduto(produtoAbstrato);
                                   System.out.println("\nOperação Realizada com sucesso!");
                                   break;
                               case 2:
                                   System.out.print("\nNovo valor: R$ ");
                                   precoVenda = tc.nextDouble();
                                   produtoAbstrato.setPrecoCompra(precoVenda);
                                   produtoFachada.AlterarProduto(produtoAbstrato);
                                   System.out.println("\nOperação Realizada com sucesso!");
                                   break;
                           }
                       }while(op2!=0);
                   }catch(SQLException | ProdutoNaoEncontrado msg){
                       System.out.print("\n"+msg.getMessage());
                   }
                   break;
           }
        }while(op!=0);
        
        
    }
    
}
