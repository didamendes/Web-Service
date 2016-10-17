<html>
<body>
	<form enctype="text/plain" method="POST" action="<%=request.getContextPath()%>/rest/produtos">
		<input type="hidden" name="id" /> 
		Nome: <input type="text" name="nome" />
		<br /><br />
		Categoria: <input type="text" name="categoria" />
		<br /><br />
		Codigo Barra: <input type="text" name="codigoBarra" />
		<br /><br />
		Descrição: <input type="text" name="descricao" />
		<br /><br />
		Preco Venda: <input type="text" name="precoVenda" />
		<br /><br />
		Fornecedor: <input type="text" name="fornecedor" />
		<br /><br />
		Foto: <input type="text" name="urlProduto" />
		<br /><br />
		<input type="submit" name="Enviar" />
	</form>
</body>
</html>
