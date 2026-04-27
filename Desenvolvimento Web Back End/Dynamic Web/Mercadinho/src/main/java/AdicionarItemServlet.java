
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
