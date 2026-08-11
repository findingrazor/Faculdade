


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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

@Path("/Mercadinho")
@Tag(name = "Logout", description = "Encerra a Sessão do Mercadinho")
/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @GET // Define o método para o Swagger
    @Operation(summary = "Encerra a sessão", description = "Encerra a sessão do cliente apagando seu carrinho e apagando os dados no cookie.")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getSession().invalidate();
		response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
