package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {
	private ProdutoDAO pd;

	// GET-ALL
	public List<ProdutoTO> listar() {
		pd = new ProdutoDAO();
		// Aqui são colocadas as regras de negócio
		return pd.select();

	}

	// GET-BY-ID
	public ProdutoTO listar(int id) {
		pd = new ProdutoDAO();
		return pd.select(id);
	}

	public boolean cadastar(ProdutoTO pto) {
		pd = new ProdutoDAO();
		//regra de negócio
		if (pto.getCodigo() > 0 && pto != null) {
			return pd.insert(pto);
		}
		return false;
	}
	public void atualizar(ProdutoTO pto) {
		pd = new ProdutoDAO();
		pd.update(pto);
	}
	
	public void excluir(int id) {
		pd = new ProdutoDAO();
		pd.delete(id);
	}
}
