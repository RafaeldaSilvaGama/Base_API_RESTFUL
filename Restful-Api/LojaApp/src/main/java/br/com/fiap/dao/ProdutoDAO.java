package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;
import br.com.fiap.to.ProdutoTO;

public class ProdutoDAO {

	private static List<ProdutoTO> listaDeProdutos;

	public ProdutoDAO() {
		if (listaDeProdutos == null) {
			listaDeProdutos = new ArrayList<ProdutoTO>();

			ProdutoTO pto = new ProdutoTO();
			pto.setCodigo(1);
			pto.setTitulo("Chinelo");
			pto.setPreco(32.90);
			pto.setQuantidade(120);
			listaDeProdutos.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(2);
			pto.setTitulo("Mouse");
			pto.setPreco(99.98);
			pto.setQuantidade(100);
			listaDeProdutos.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(3);
			pto.setTitulo("Teclado");
			pto.setPreco(110.90);
			pto.setQuantidade(67);
			listaDeProdutos.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(4);
			pto.setTitulo("Alcool Gel");
			pto.setPreco(23.77);
			pto.setQuantidade(1000);
			listaDeProdutos.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(5);
			pto.setTitulo("Pilhas AA");
			pto.setPreco(2.98);
			pto.setQuantidade(2000);
			listaDeProdutos.add(pto);

		}
	}

	// Get-All
	public List<ProdutoTO> select() {
		return listaDeProdutos;
	}

	// Get-BY-ID
	public ProdutoTO select(int id) {

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if (listaDeProdutos.get(i).getCodigo() == id) {
				return listaDeProdutos.get(i);
			}
		}
		return null;

	}
	// post
	public boolean insert(ProdutoTO pto) {
		pto.setCodigo(listaDeProdutos.size() + 1);
		return listaDeProdutos.add(pto);
	}
	
	// put
	public void update(ProdutoTO pto) {
		//tras a instancia do objeto para o produtoto sem sobescrever o q ja esta nele
		ProdutoTO produto = select(pto.getCodigo());
		produto.setTitulo(pto.getTitulo());
		produto.setPreco(pto.getPreco());
		produto.setQuantidade(pto.getQuantidade());
		
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if (listaDeProdutos.get(i) == produto) {
				//irá pegar a posição aonde esta o produto e atualizar suas informações
				listaDeProdutos.set(i, produto);
			}
		}
	}
	public void delete(int id) {
		listaDeProdutos.remove(select(id));
		
	}
}
