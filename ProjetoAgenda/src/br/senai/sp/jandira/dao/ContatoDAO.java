package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jbdc.Conexao;
import br.senai.sp.jandira.model.Contato;

public class ContatoDAO  {
	
	private Contato contato;
	private ResultSet resultado;
	private PreparedStatement stm;
	
	public void setContato(Contato contato){
		this.contato = contato;
		
	}
	
	public ResultSet getContatos(){
		
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		resultado = null;
		stm = null;
		
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			
			Conexao.fecharConexao();
			
			} catch (Exception erro){
				System.out.println(erro.getMessage());
				JOptionPane.showMessageDialog(null, "Ocorreu um Erro na Consulta!",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
		return resultado;
	}
	
	public ArrayList<Contato> getListaContatos(){
		
		ArrayList<Contato> contatos = new ArrayList<>();
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		resultado = null;
		stm = null;
		
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			
			while (resultado.next()){
				Contato contato = new Contato();
				contato.setId(resultado.getInt("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setDtNascimento(resultado.getString("dtNasc"));
				contato.setEmail(resultado.getString("email"));
				contato.setDtNascimento(resultado.getString("dtNasc"));
				contato.setEndereco(resultado.getString("endereco"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setCelular(resultado.getString("celular"));
				contato.setSexo(resultado.getString("sexo"));
				contatos.add(contato);
	
			}
			
			Conexao.fecharConexao();
			
			} catch (Exception erro){
				System.out.println(erro.getMessage());
				JOptionPane.showMessageDialog(null, "Ocorreu um Erro na Consulta!",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
		return contatos;
	}
	
	public Contato getContato(int id){
		
		Contato contato = new Contato();
		
		/* DEFININDO O FORMATO DAS DTAS DO BANCO PARA PT-BR */
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		String consulta = "SELECT * FROM contatos WHERE id = ?";
		resultado = null;
		stm = null;
		
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, id);
			resultado = stm.executeQuery();
			
			resultado.next();
			contato.setId(resultado.getInt("id"));
			contato.setNome(resultado.getString("nome"));
			contato.setDtNascimento(df.format(resultado.getDate("dtNasc")));
			contato.setEmail(resultado.getString("email"));
			contato.setEndereco(resultado.getString("endereco"));
			contato.setTelefone(resultado.getString("telefone"));
			contato.setCelular(resultado.getString("celular"));
			contato.setSexo(resultado.getString("sexo"));
			
			Conexao.fecharConexao();
			
			} catch (Exception erro){
				System.out.println(erro.getMessage());
				JOptionPane.showMessageDialog(null, "Ocorreu um Erro na Consulta!",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
		return contato;
	
	}
	
	/**** METODO GRAVAR ****/
	public void gravar(){
		String sql = "INSERT INTO contatos "
				+ "(nome, dtNasc, email, endereco, "
				+ "telefone, celular, sexo) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.DtNascimento());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getEndereco());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getSexo());
			stm.execute();
			
			Conexao.fecharConexao();
			
			JOptionPane.showMessageDialog(null, "Contato Gravado com Sucesso!");
			
		} catch (Exception erro){
			System.out.println(erro.getMessage());
			
		}
		
	}
	
	/**** METODO ATUALIZAR ****/
	public void atualizar(){
		String sqlUpt = "UPDATE contatos SET "
				+ "nome = ?, dtNasc = ?, email = ?, endereco = ?, "
				+ "telefone = ?, celular = ?, sexo = ? "
				+ "WHERE id = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sqlUpt);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.DtNascimento());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getEndereco());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getSexo());
			stm.setInt(8, contato.getId());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato Atualizado com Sucesso!");
			
			Conexao.fecharConexao();
			
		} catch (Exception erro){
			System.out.println(erro.getMessage());
			
		}
		
	}
	
	/**** METODO EXCLUIR ****/
	public void excluir(){
		String sqlDel = "DELETE FROM contatos " + "WHERE id = ?";
				
		try {
			stm = Conexao.getConexao().prepareStatement(sqlDel);
			stm.setInt(1, contato.getId());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato Deletado com Sucesso!");
			
			Conexao.fecharConexao();
			
		} catch (Exception erro){
			System.out.println(erro.getMessage());
			
		}
		
	}
}