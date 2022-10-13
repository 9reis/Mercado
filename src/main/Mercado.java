package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Produto;

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
			
			case 5: System.out.println("Obrigado pela preferencia. Volte sempre!");
					System.exit(0);
			
			default: System.out.println("Opção invalida!");
			menu();
			break
		}
	}
	
	
	
	
	
	
	
	
	
}
