

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.annotation.WebServlet;

import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import java.util.List;

@Path("/carrinho")
@Tag(name = "Adicionar Item Carrinho de Compras", description = "Operações de adição de produtos no carrinho do mercadinho")
/**
 * Servlet implementation class AdicionarItemServlet
 */
public class AdicionarItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@POST // Define o método para o Swagger
	 @Operation(
	 summary = "Adiciona um item no carrinho",
	 description = "Gera uma página HTML contendo a lista de produtos armazenados na sessão e o valor total da compra.",
	 parameters = { 
			 @Parameter(name = "produto", description = "Nome do produto", required = true, in = ParameterIn.QUERY, example = "Arroz"),
			 @Parameter( name = "preco", description = "Preço do produto", required = true, in = ParameterIn.QUERY, example = "10.5")
	 }) 
	 @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Página do carrinho renderizada com sucesso",content = { @Content(mediaType = "text/html"),
	// Adicionamos isso para "avisar" o Swagger que o Produto existe
	//Content(mediaType = "application/json", schema = Schema(implementation = Produto.class)) 
	}),
	 @ApiResponse(
	 responseCode = "500", 
	 description = "Erro interno ao processar a sessão"
	 )
	 })
	public void doPost(
			@Context jakarta.servlet.http.HttpServletRequest request, 
		    @Context jakarta.servlet.http.HttpServletResponse response
		    ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		List<Produto> itens = (List<Produto>)session.getAttribute("carrinho");
		if(itens == null) {
			itens = new ArrayList<>();
		}
		String nome = request.getParameter("produto");
		double preco = Double.parseDouble(request.getParameter("preco")); 
		if(nome != null && !nome.trim().isEmpty()) {
			itens.add(new Produto(nome, preco));
		}
		double novoTotal = 0.0;
		for (Produto p : itens) {
			novoTotal += p.getPreco();
		}
		session.setAttribute("total_compra", novoTotal);
		session.setAttribute("carrinho", itens);
		response.getWriter().println("Produto " + nome + " adicionado!");
		response.getWriter().println("Total atual na sessao: R$ " + novoTotal);
		response.sendRedirect("ExibirCarrinhoServlet");
	}

}
