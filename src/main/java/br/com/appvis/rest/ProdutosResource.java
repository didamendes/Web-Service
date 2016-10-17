package br.com.appvis.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.appvis.domain.Produto;
import br.com.appvis.domain.ProdutoService;
import br.com.appvis.domain.Response;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")

public class ProdutosResource {
	
	

	private ProdutoService produtoService = new ProdutoService();
	
	@GET
	public List<Produto> get(){
		List<Produto> produtos = produtoService.getProdutos();
		return produtos;
	}
	
	@GET
	@Path("{id}")
	public Produto get(@PathParam("id") long id){
		Produto p = produtoService.getProduto(id);
		return p;
	}
	
	@GET
	@Path("/categoria/{categoria}")
	public List<Produto> getByCategoria(@PathParam("categoria") String categoria){
		List<Produto> produtos = produtoService.findByCategoria(categoria);
		return produtos;
	}
	
	@GET
	@Path("/nome/{nome}")
	public List<Produto> getByNome(@PathParam("nome") String nome){
		List<Produto> produtos = produtoService.findByName(nome);
		return produtos;
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id){
		produtoService.delete(id);
		return Response.Ok("Produto deletado com sucesso");
	}
	
	@POST
	public Response post(Produto p){
		produtoService.save(p);
		return Response.Ok("Produto salvo com sucesso");
	}
	
	@PUT
	public Response put(Produto p){
		produtoService.save(p);
		return Response.Ok("Produto salvo com sucesso");
	}
	
}
