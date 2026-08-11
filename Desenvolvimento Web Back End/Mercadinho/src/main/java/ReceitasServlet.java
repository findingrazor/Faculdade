


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

@Path("/Mercadinhpo")
@Tag(name = "Receitas", description = "Lista de Receitas do Mercadinho")
/**
 * Servlet implementation class ReceitasServlet
 */
@WebServlet("/ReceitasServlet")
public class ReceitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
      private List<Receitas> database = Arrays.asList(
    		  new Receitas("Bolo de Cenoura", "Cenoura, Óleo, Ovos, Farinha, Acúcar, Chocolate", "Sobremesa"),
    		  new Receitas("Pão de Queijo", "Polvilho, Queijo Meia Cura, Ovos, Leite, Óleo", "Lanche"),
    		  new Receitas("Omelete de Ervas", "Ovos, Salsinha, Cebolinha, Sal, Manteiga", "Refeição Rápida"),
    		  new Receitas("Panqueca Americana", "Farinha, Leite, Ovo, Fermento, Baunilha", "Café da Manhã")
    		  );
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceitasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @GET // Define o método para o Swagger
    @Operation(summary = "Guarda as receitas do mercadinho", description = "Armazena uma lista com receitas que possuem produtos para aplicar a pesquisa dinamica.")
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
    ) throws ServletException, IOException  {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String query = request.getParameter("q");
		List<Receitas> filtrados = database;
		
		if(query != null && !query.isEmpty()) {
			filtrados = database.stream().filter(d -> d.getNome().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList());
		}
		
		StringBuilder json = new StringBuilder("[");
		for(int i=0; i<filtrados.size(); i++) {
			Receitas d = filtrados.get(i);
			json.append(String.format("{\"nome\":\"%s\", \"ingredientes\":\"%s\", \"cat\":\"%s\"}", d.getNome(), d.getIngredientes(), d.getCategoria()));
			if (i<filtrados.size()-1) json.append(",");
		}
		json.append("]");
		
		response.getWriter().print(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
