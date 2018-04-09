package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jbdc.Conexao;

public class ContatoDAO  {
	
	private ResultSet resultado;
	private PreparedStatement stm;
	
	public ResultSet getContatos(){
		
		String consulta = "SELECT * FROM contatos ORDER BY name ASC";
		resultado = null;
		stm = null;
		
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			Conexao.fecharConexao();
			} catch (Exception erro){
				JOptionPane.showMessageDialog(null, "Ocorreu um Erro na Consulta!",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
		return resultado;
	}
}