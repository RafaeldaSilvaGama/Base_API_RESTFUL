package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

//irá garantir que essa classe se 
//comporte como um objeto do tipo json
@XmlRootElement 
public class ProdutoTO {
	
	private int codigo, quantidade;
	private double preco;
	private String titulo;
	
	public ProdutoTO() {
		
	}

	public ProdutoTO(int codigo, int quantidade, double preco, String titulo) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.preco = preco;
		this.titulo = titulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	 
}
