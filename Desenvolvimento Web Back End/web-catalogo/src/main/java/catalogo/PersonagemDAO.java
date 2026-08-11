package catalogo;

import catalogo.FabricaDeConexao;
import catalogo.Personagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {
	public void salvar(Personagem personagem) {
		String sql = "INSERT INTO catalogo (nome, classe, raca, preco, url_imagem) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conexao = FabricaDeConexao.pegarConexao();
				 PreparedStatement stmt = conexao.prepareStatement(sql)) {
				 stmt.setString(1, personagem.getNome());
				 stmt.setString(2, personagem.getClasse());
				 stmt.setString(3, personagem.getRaca());
				 stmt.setDouble(4, personagem.getPreco());
				 stmt.setString(5, personagem.getUrlImagem());
				 stmt.execute();
				 System.out.println("Produto salvo com imagem: " + personagem.getNome());
		} catch (SQLException e) {
			 throw new RuntimeException("Erro ao salvar produto: " + e.getMessage());
		}
	}
	
	public List<Personagem> listarTodos() {
		 List<Personagem> catalogo = new ArrayList<>();
		 String sql = "SELECT * FROM catalogo";
		 try (Connection conexao = FabricaDeConexao.pegarConexao();
		 PreparedStatement stmt = conexao.prepareStatement(sql);
		 ResultSet rs = stmt.executeQuery()) {
		 while (rs.next()) {
		 Personagem p = new Personagem();
			 p.setId(rs.getInt("id"));
			 p.setNome(rs.getString("nome"));
			 p.setClasse(rs.getString("classe"));
			 p.setRaca(rs.getString("raca"));
			 p.setPreco(rs.getDouble("preco"));
			 p.setUrlImagem(rs.getString("url_imagem"));
			 
			 catalogo.add(p);
		 }
		 } catch (SQLException e) {
			 throw new RuntimeException("Erro ao buscar catálogo: " + e.getMessage());
		 }
		 	return catalogo;
		 }
	
	public void apagar(int id) {
		 String sql = "DELETE FROM catalogo WHERE id = ?";
		 try (Connection conexao = FabricaDeConexao.pegarConexao();
		 PreparedStatement stmt = conexao.prepareStatement(sql)) {
		 
			 stmt.setInt(1, id);
			 stmt.execute();
			 System.out.println("Personagem removido com sucesso! ID: " + id);
			 
		 } catch (SQLException e) {
			 throw new RuntimeException("Erro ao apagar personagem: " + e.getMessage());
		 }
	}
	
	public Personagem buscarPorId(int id) {
		 String sql = "SELECT * FROM catalogo WHERE id = ?";
		 try (Connection conexao = FabricaDeConexao.pegarConexao();
		 PreparedStatement stmt = conexao.prepareStatement(sql)) {
		 
			 stmt.setInt(1, id);
			 ResultSet rs = stmt.executeQuery();
			 
			 if (rs.next()) {
				 Personagem p = new Personagem();
				 p.setId(rs.getInt("id"));
				 p.setNome(rs.getString("nome"));
				 p.setClasse(rs.getString("classe"));
				 p.setRaca(rs.getString("raca"));
				 p.setPreco(rs.getDouble("preco"));
				 p.setUrlImagem(rs.getString("url_imagem"));
				 return p;
			 }
		 } catch (SQLException e) {
			 throw new RuntimeException("Erro ao buscar personagem: " + e.getMessage());
		 }
		 	return null;
	}
	
	public void atualizar(Personagem personagem) {
		String sql = "UPDATE catalogo SET nome=?, classe=?, raca=?, preco=?, url_imagem=? WHERE id=?";
		try (Connection conexao = FabricaDeConexao.pegarConexao();
		 PreparedStatement stmt = conexao.prepareStatement(sql)) {
		 
		stmt.setString(1, personagem.getNome());
		stmt.setString(2, personagem.getClasse());
		stmt.setString(3, personagem.getRaca());
		stmt.setDouble(4, personagem.getPreco());
		stmt.setString(5, personagem.getUrlImagem());
		stmt.setInt(6, personagem.getId());
		 
		 stmt.execute();
		 System.out.println("Personagem atualizado com sucesso! ID: " + personagem.getId());
		 
		 } catch (SQLException e) {
			 throw new RuntimeException("Erro ao atualizar personagem: " + e.getMessage());
		 }
	}

}
