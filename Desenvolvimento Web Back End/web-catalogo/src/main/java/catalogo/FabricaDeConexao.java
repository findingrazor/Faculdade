package catalogo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	// URL do banco. 
	 private static final String URL = "jdbc:h2:~/meucatalogo";
	 private static final String USUARIO = "sa";
	 private static final String SENHA = "";
	 public static Connection pegarConexao() {
	 try {
	 // Garante que o driver do H2 seja carregado na memória do Tomcat
	 Class.forName("org.h2.Driver");
	 return DriverManager.getConnection(URL, USUARIO, SENHA);
	 } catch (SQLException | ClassNotFoundException e) {
	 throw new RuntimeException("Erro ao conectar ou criar o banco de dados: " + e.getMessage());
	 }
	 }
	 // Método Main apenas para criarmos o banco rapidamente
	 public static void main(String[] args) {
	 System.out.println("Tentando gerar o arquivo do banco...");
	 
	 try (Connection conexao = pegarConexao()) {
	 System.out.println("SUCESSO! O banco foi criado/conectado com sucesso.");
	 System.out.println("Você já pode abrir o H2 Console no navegador!");
	 } catch (SQLException e) {
	 System.out.println("Falha crítica: " + e.getMessage());
	 }
	 }
}
