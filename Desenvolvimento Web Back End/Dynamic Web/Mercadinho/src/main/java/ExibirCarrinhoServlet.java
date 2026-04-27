

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
