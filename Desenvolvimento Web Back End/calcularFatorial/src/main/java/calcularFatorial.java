

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.math.BigInteger;

/**
 * Servlet implementation class calcularFatorial
 */
public class calcularFatorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcularFatorial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();
		String numero = request.getParameter("numero");
		if (numero == null) {
			numero = "0";
		}
		try {
			int n = Integer.parseInt(numero);
			if(n < 0) {
				out.println("<p>Número inválido! O número deve ser positivo</p>");
			} else {
				out.println("<html><head><title>");
				out.println("Calcular Fatorial");
				out.println("</title></head><body>");
				out.println("<h1>Calcular Fatorial</h1>");
				out.println("<p>O cálculo fatorial de " + numero + "! é: " + calculoFatorial(numero) + "</p>");
				out.println("</body></html>");
				out.close();
			}
		}catch(NumberFormatException e) {
			out.println("<p>Erro: Entrada inválida</p>");
		}
		
	}
	
	public BigInteger calculoFatorial(String numero) {
		int n = Integer.parseInt(numero);
		BigInteger resultado = BigInteger.ONE;
		for(int i = 2; i <= n; i++) {
			resultado = resultado.multiply(BigInteger.valueOf(i));
		}
		return resultado;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
