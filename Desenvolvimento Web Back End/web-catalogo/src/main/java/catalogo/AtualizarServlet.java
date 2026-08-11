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
 * Servlet implementation class AtualizarServlet
 */
@WebServlet("/atualizar")
public class AtualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AtualizarServlet() {
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
		int id = Integer.parseInt(request.getParameter("id")); // O campo oculto!
		String nome = request.getParameter("nome");
		String classe = request.getParameter("classe");
		String raca = request.getParameter("raca");
		double preco = Double.parseDouble(request.getParameter("preco"));
		String urlImagem = request.getParameter("urlImagem");
		 
		 Personagem p = new Personagem();
		 p.setId(id);
		 p.setNome(nome);
		 p.setClasse(classe);
		 p.setRaca(raca);
		 p.setPreco(preco);
		 p.setUrlImagem(urlImagem);
		 
		 PersonagemDAO dao = new PersonagemDAO();
		 dao.atualizar(p);
		 
		 response.sendRedirect("vitrine");
	}

}
