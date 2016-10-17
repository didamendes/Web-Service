package test;

import java.sql.SQLException;
import java.util.List;


import br.com.appvis.domain.Produto;
import br.com.appvis.domain.ProdutoService;
import junit.framework.TestCase;

public class ProdutoTest extends TestCase {

	
	private ProdutoService produtoService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// Cria o bean pelo Spring
		produtoService = (ProdutoService) SpringUtil.getInstance().getBean(ProdutoService.class);
	}
	
	public void testListaProdutos() {
		List<Produto> produtos = produtoService.getProdutos();
		
		assertNotNull(produtos);
		
		assertTrue(produtos.size() > 0);
		
		Produto web = produtoService.findByCategoria("outros").get(0);
		assertEquals("outros", web.getCategoria());
		
		Produto busca = produtoService.findByName("Web Services RESTful").get(0);
		assertEquals("Web Services RESTful", busca.getNome());
		
	}
	
	
	public void testSalvarDeletarProduto() {
		Produto p = new Produto();
		p.setNome("Teste");
		p.setCategoria("Categoria");
		p.setCodigoBarra("Codigo");
		p.setDescricao("Descricao");
		p.setPrecoVenda("Preco Venda");
		p.setFornecedor("Teste");
		p.setUrlProduto("Foto");
		
		produtoService.save(p);
		
		Long id = p.getId();
		assertNotNull(id);
		
		//Busca no banco de dados
		p = produtoService.getProduto(id);
		assertEquals("Teste", p.getNome());
		assertEquals("Categoria", p.getCategoria());
		assertEquals("Codigo", p.getCodigoBarra());
		assertEquals("Descricao", p.getDescricao());
		assertEquals("Preco Venda", p.getPrecoVenda());
		assertEquals("Teste", p.getFornecedor());
		assertEquals("Foto", p.getUrlProduto());
		
		
		// Atualiza o produto
		p.setNome("Teste UPDATE");
		produtoService.save(p);
		
		//Busca o produto
		p = produtoService.getProduto(id);
		assertEquals("Teste UPDATE", p.getNome());
		
		// Deleta o produto
		produtoService.delete(id);
		
		//Busca o produto novamente
		p = produtoService.getProduto(id);
		
		assertNull(p);
		
	}

}
