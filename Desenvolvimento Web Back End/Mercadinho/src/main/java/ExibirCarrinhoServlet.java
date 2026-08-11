


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.annotation.WebServlet;

import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import java.util.List;

@Path("/carrinho")
@Tag(name = "Exibir Carrinho de Compras", description = "Operações de visualização do carrinho do mercadinho")
/**
 * Servlet implementation class ExibirCarrinhoServlet
 */
public class ExibirCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExibirCarrinhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    Locale ptBr = Locale.of("pt", "BR");
    NumberFormat nfBR = NumberFormat.getCurrencyInstance(ptBr);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @GET // Define o método para o Swagger
    @Operation(summary = "Exibe o conteúdo do carrinho", description = "Gera uma página HTML contendo a lista de produtos armazenados na sessão e o valor total da compra.")
    @ApiResponses(value = {
    @ApiResponse(
    responseCode = "200", 
    description = "Página do carrinho renderizada com sucesso",
    content = @Content(mediaType = "text/html")
    ),
    @ApiResponse(
    responseCode = "500", 
    description = "Erro interno ao processar a sessão"
    )
    })
    
    public void doGet(
    @Context jakarta.servlet.http.HttpServletRequest request, 
    @Context jakarta.servlet.http.HttpServletResponse response
    ) throws ServletException, IOException {

		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		List<Produto> itens = (List<Produto>)session.getAttribute("carrinho");
		double total = (Double) session.getAttribute("total_compra"); 
		var out = response.getWriter();
		out.println("<html><head><meta charset=\"UTF-8\"></head><body><h2>Itens no seu Carrinho:</h2><ul>");
		if(itens != null && !itens.isEmpty()) {
			for(Produto item : itens) {
				out.println("<li>" + item.getNome() + "<br>" + nfBR.format(item.getPreco()) + "</li>");
			} 
			
		}else {
			out.println("<p>O carrinho está vazio!</p>");
		}
		out.println("</ul>");
		out.println("O valor total do carrinho é: " + nfBR.format(total) + "<br><br>");
		out.println("<a href='index.html'>Adicionar mais</a> | ");
		out.println("<a href='Logout'>Limpar Sessão (Logout)</a>");
		out.println("</body></html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
