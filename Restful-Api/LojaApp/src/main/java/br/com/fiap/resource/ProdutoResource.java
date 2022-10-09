package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {
	
	ProdutoBO pb = new ProdutoBO();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> buscar() {
		return pb.listar();
	}
	
	//GET-BY-ID
	//
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)//gera informação
	public ProdutoTO buscar(@PathParam("id") int id) {
		return pb.listar(id);
	}
	
	//CADASTRAR
	// a classe response consegue gerar o retorno nescessário do httpstatus(códigos de retorno)
	//UriInfo é uma interface que recebe a passa os parametros da URI(menor parte que a url pode ser dividida)
	// a anotation COntext associa as informações da uriinfo para o produtoTO
	@POST
	@Consumes(MediaType.APPLICATION_JSON)//recebe informação
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) {
		//cadastrar o produto
		pb.cadastar(produto);
		
		//Construir o path
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();//pega toda a url
		
		//Parseando o código e concatenandp com o path
		//pega a url e adiciona ao final dela o código do produto
		builder.path(Integer.toString(produto.getCodigo()));
		
		//retornando o status code do http através do builder
		
		return Response.created(builder.build()).build();
		
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response atualizar(ProdutoTO produto, @PathParam("id") int id) {
		
		//Setar o código do produto
		produto.setCodigo(id);
		
		//atualizando o produto
		pb.atualizar(produto);
		
		//retornando o status 200
		return Response.ok().build();
		
	}
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		pb.excluir(id);
	}
}
