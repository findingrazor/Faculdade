package catalogo;

import catalogo.Personagem;
import catalogo.PersonagemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class CadastroCatalogoServlet
 */
@WebServlet("/cadastrar")
public class CadastroCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CadastroCatalogoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String nome = request.getParameter("nome");
		String classe = request.getParameter("classe");
		String raca = request.getParameter("raca");
		double preco = Double.parseDouble(request.getParameter("preco"));
		String urlImagem = request.getParameter("urlImagem");
		Personagem novoPersonagem = new Personagem(0, nome, classe, raca, preco, urlImagem);
		PersonagemDAO dao = new PersonagemDAO();
		dao.salvar(novoPersonagem);
		response.setContentType("text/html");
		response.getWriter().println("<h2>Personagem adicionado com sucesso!</h2>");
		response.getWriter().println("<a href='novo-item.html'>Cadastrar outro item</a> | <a href='vitrine'>Ver Vitrine</a>");

	}

}
