

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet Filter implementation class AcessoMercadinhoFilter
 */
public class AcessoMercadinhoFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AcessoMercadinhoFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		LocalTime acesso = LocalTime.now();
		LocalTime limiteInicial = LocalTime.of(10, 0);
		LocalTime limiteFinal = LocalTime.of(22, 0);
		HttpServletResponse redirect = (HttpServletResponse) response;
		
		System.out.println("[Mercadinho Log] Cliente entrou na loja virtual em: " + new java.util.Date());
		if(acesso.isBefore(limiteInicial)) {
			System.out.println("[Mercadinho Log] Acesso negado, Mercadinho fechado! Volte ás " + limiteInicial);
			redirect.sendRedirect("AcessoNegado.html");
			return;
		}else if(acesso.isAfter(limiteFinal)){
			System.out.println("[Mercadinho Log] Acesso negado, Mercadinho fechado! Volte ás " + limiteInicial);
			redirect.sendRedirect("AcessoNegado.html");
			return;
		}else {
			chain.doFilter(request, response); // Continua o fluxo para a loja
			System.out.println("[Mercadinho Log] Resposta do sistema enviada em: " + new java.util.Date());
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
