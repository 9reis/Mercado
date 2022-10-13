package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Produto;
import util.Utils;

public class Mercado {

	static Scanner input = new Scanner(System.in);	
	private static ArrayList<Produto> produtos;
	private static Map<Produto, Integer> carrinho;
	
	public static void main(String[] args) {
		produtos = new ArrayList<>();
		carrinho = new HashMap<>();
		menu();
	}
	
	private static void menu() {
		
		System.out.println("=================================================");
		System.out.println("------------ WELCOME to Reis Market -------------");
		System.out.println("=================================================");
		System.out.println();
		System.out.println("**** Escolha uma operação que deseja realizar ****");
		System.out.println("--------------------------------------------------");
		System.out.println("|      	Opcion 1 - Registrar    |");
		System.out.println("|     	Opcion 2 - Listar    	|");
		System.out.println("|    	Opcion 3 - Comprar      |");
		System.out.println("|     	Opcion 4 - Carrinho     |");
		System.out.println("|    	Opcion 5 - Sair         |");
		System.out.println("--------------------------------------------------");
	
		int option = input.nextInt();
	
		switch(option) {
			case 1: cadastrarProdutos();
			break;
			
			case 2 : listarProdutos();
			break;
			
			case 3: comprarProdutos();
			break;
			
			case 4: verCarrinho();
			break;
			
			case 5: System.out.println("Volte sempre!");
					System.exit(0);
			
			default: System.out.println("Opção invalida!");
			menu();
			break;
		}
	}
	
	private static void cadastrarProdutos() {
		System.out.println("Nome do produto: ");
		String nome = input.next();
		
		System.out.println("Preço do produto:");
		Double preco = input.nextDouble();
		
		Produto produto = new Produto(nome,preco);
		produtos.add(produto);
		
		System.out.println();
		System.out.println(produto.getNome() + " cadastrado com sucesso! ");
		menu();
	}// FIM cadastrarProdutos
	
	
	
	private static void listarProdutos() {
		if(produtos.size() > 0 ){
			System.out.println("Lista de produtos \n ");
			
			for( Produto p : produtos) {
				System.out.println(p);
				System.out.println("--------------------");
			}
		}else {
			System.out.println();
			System.out.println("**************************");
			System.out.println("Nenhum produto cadastrado");
			System.out.println("**************************");
			System.out.println();
		}
		
		menu();
	} // FIM listarProdutos
	
	
	
	private static void comprarProdutos() {
		if(produtos.size() > 0) {
			System.out.println("Codigo do produto: \n");
			
			System.out.println();
			System.out.println("--------- Produtos disponíveis ---------");
			
			for(Produto p : produtos ) {
				System.out.println(p + "\n");
			}
			
			int id = Integer.parseInt(input.next());
			boolean isPresent = false;
			
			for (Produto p : produtos) {
				if(p.getId() == id) {
					int qtd = 0;
					try {
						qtd = carrinho.get(p);
						carrinho.put(p, qtd +1);
					}catch(NullPointerException e) {
						carrinho.put(p,1);
					}
					
					System.out.println(p.getNome() + " adicionado ao carrinho.");
					isPresent = true;
					
					System.out.println();
					
					if( isPresent) {
						System.out.println("Deseja adicionar outro produto?");
						System.out.println(" 1 - Sim || 0 - Finaliza a compra");
						
						int option = Integer.parseInt(input.next());
						
						if( option == 1 ) {
							comprarProdutos();
						}else {
							finalizarCompra();
						}
					}
				}else {
					System.out.println("Produto não encontrado");
					menu();
				}
				
			}
		}else {
			System.out.println();
			System.out.println("*******************************");
			System.out.println("Não existe produtos cadastrados");
			System.out.println("*******************************");
			System.out.println();
			menu();
		}
	} // FIM comprarProdutos
	
	
	
	private static void verCarrinho() {
		System.out.println("-------- Produtos no seu carrinho --------");
		
		if(carrinho.size() > 0) {
			for(Produto p : carrinho.keySet()) {
				System.out.println("Produto: " + p + "\nQuantodade: " + carrinho.get(p)); 
			}
		}else {
				System.out.println();
				System.out.println("***************");
				System.out.println("Carrinho vazio!");
				System.out.println("***************");
				System.out.println();
			}
			menu();
	}// FIM verCarrinho
	
	
	private static void finalizarCompra() {
		Double valorDaCompra = 0.0;
		System.out.println("Seus produtos");
		
		for( Produto p : carrinho.keySet()) {
			int qtd = carrinho.get(p);
			valorDaCompra += p.getPreco() * qtd;
			System.out.println(p);
			System.out.println("Quantidade " + qtd);
			System.out.println("-----------------");
		}
		
		System.out.println("O valor da sua compra é: " + Utils.doubleToString(valorDaCompra) );
		carrinho.clear();
		System.out.println("Obrigado pela preferencia");
		menu();
	}
}
