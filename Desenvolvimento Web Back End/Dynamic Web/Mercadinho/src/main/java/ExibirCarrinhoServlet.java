

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		List<String> itens = (List<String>)session.getAttribute("carrinho");
		var out = response.getWriter();
		out.println("<html><head><meta charset=\"UTF-8\"></head><body><h2>Itens no seu Carrinho:</h2><ul>");
		if(itens != null && !itens.isEmpty()) {
			for(String item : itens) {
				out.println("<li>" + item + "</li>");
			} 
			
		}else {
			out.println("<p>O carrinho está vazio!</p>");
		}
		out.println("</ul>");
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
