

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * Servlet implementation class calculadora
 */
public class calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calculadora() {
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
		String operando1 = request.getParameter("operando1");
		String operando2 = request.getParameter("operando2");
		String operador = request.getParameter("operador");
		if (operando2 == null) {
			operando2 = "0";
		}
		if (operando1 == null) {
			operando1 = "0";
		}
		try {
			int n1 = Integer.parseInt(operando1);
			int n2 = Integer.parseInt(operando2);
			if(n1 < 0 || n2 < 0) {
				out.println("<p>Número(s) inválido(s)! O(s) número(s) deve(m) ser positivo(s)</p>");
			} else {
				out.println("<html><head><title>");
				out.println("Calculadora");
				out.println("</title></head><body>");
				out.println("<h1>Calculadora</h1>");
				out.println("<p>O cálculo "+ operando1 + " " + operador + " " + operando2 + " é igual a: " + calcular(operando1, operando2, operador) +"</p>");
				out.println("</body></html>");
				out.close();
			}
		} catch (NumberFormatException e) {
			out.println("<p>Erro: Entrada(s) inválida(s)</p>");
		}
		
	}
	
	public BigInteger calcular(String operando1, String operando2, String operador) {
		int operan1 = Integer.parseInt(operando1);
		int operan2 = Integer.parseInt(operando2);
		BigInteger op1 = BigInteger.valueOf(operan1);
		BigInteger op2 = BigInteger.valueOf(operan2);
		BigInteger resultado = BigInteger.ZERO;
		if (operador.equals("+")) {
			resultado = op1.add(op2);
		} else if (operador.equals("-")) {
			resultado = op1.subtract(op2);
		} else if (operador.equals("*")) {
			resultado = op1.multiply(op2);
		} else if (operador.equals("/")) {
			resultado = op1.divide(op2);
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
