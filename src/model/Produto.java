package model;

import util.Utils;

public class Produto {
	 public static int count = 1;
	 
	 private int id; 
	 private String nome; 
	 private Double preco;
	 
	 public Produto(String nome, double preco) {
		this.id = count;
		this.nome = nome;
		this.preco = preco;
		Produto.count += 1;
	 }

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String toString() {
		return "id: " + this.getId() + 
				"\nNome: " + this.getNome() +
				"\nPreço: " + Utils.doubleToString(this.getPreco());
	}
	
	 
	 
	 
	 
	
	
}
