

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class AuditoriaVendasListener
 *
 */
@WebListener
public class AuditoriaVendasListener implements HttpSessionAttributeListener {
	 private static final double LIMITE_COMPRA_SUSPEITA = 1000.00;
	 private static final double VARIACAO_ALERTA_ESTOQUE = 200.00;

    /**
     * Default constructor. 
     */
    public AuditoriaVendasListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	processarAuditoria(se, "ATUALIZAÇÃO DE CARRINHO");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         processarAuditoria(se, "INÍCIO DE COMPRA");
    }
    
    private void processarAuditoria(HttpSessionBindingEvent event, String operacao) { 
    	if ("total_compra".equals(event.getName())) {
    		Double valorAntigo = (event.getValue() instanceof Double) ? (Double) event.getValue() : 0.0;
    		Double novoTotal = (Double) event.getSession().getAttribute("total_compra");
    		double diferenca = novoTotal - valorAntigo;
    		System.out.println("\n[LOG DA AUDITORA CLARISSE AMARAL] " + operacao);
    		System.out.println("ID Cliente (Sessão): " + event.getSession().getId());
    		System.out.printf("Valor Atual: R$ %.2f%n", novoTotal);
    		if(novoTotal > LIMITE_COMPRA_SUSPEITA) {
    			System.err.println("WARNING: Compra de alto valor detectada. Verificar limite de crédito.");
    		}
    		if(diferenca > VARIACAO_ALERTA_ESTOQUE) {
    			System.err.printf("WARNING: Incremento brusco de R$ %.2f detectado em uma única operação.%n", diferenca);
    		}
    	}

    }
	
}
