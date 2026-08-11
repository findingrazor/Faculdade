

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class AlertaServlet
 */
public class AlertaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlertaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		var out = response.getWriter();
		HttpSession session = request.getSession();
		Integer estado = (Integer) session.getAttribute("estado");
		if (estado == null) estado = 0;
	
		out.println("<html><head><meta charset=\"UTF-8\"></head><body>");
		String alertas[] = {"Alerta Verde", "Alerta Amarelo", "Alerta Vermelho"};
		if(estado == 0) {
			out.println("<h1 style=\"color:green\">" + alertas[estado] + "</h1>");
			session.setAttribute("estado", 1);
		} else if (estado == 1) {
			out.println("<h1 style=\"color:yellow\">" + alertas[estado] + "</h1>");
			session.setAttribute("estado", 2);
		}else if (estado == 2) {
			out.println("<h1 style=\"color:red\">" + alertas[estado] + "</h1>");
			session.setAttribute("estado", 0);
		} 
		out.println("<a href='AlertaServlet'>Alertar Novamente</a> | ");
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
