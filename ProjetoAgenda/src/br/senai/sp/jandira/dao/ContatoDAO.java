package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			contato.setDtNascimento(resultado.getString("dtNasc"));
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
		
		
	}
	
	/**** METODO ATUALIZAR ****/
	public void atualizar(){
		
		
	}
	
	/**** METODO EXCLUIR ****/
	public void excluir(){
		
		
	}
}