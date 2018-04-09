package br.senai.sp.jandira.agenda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jbdc.Conexao;

public class Agenda {

	public static void main(String[] args) {
		
		String consulta = "SELECT * FROM contatos";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			rs = stm.executeQuery();
			
			while (rs.next()){
				System.out.println("LISTA DE CONTATO");
				System.out.println("--------------------------");
				System.out.println(rs.getInt("id") + " - Nome: " + rs.getString("nome"));
				System.out.println("Data De Nascimento: " + rs.getString("dtNasc"));
				System.out.println("Endereço: " + rs.getString("endereco"));
				System.out.println("Telefone: " + rs.getString("telefone"));
				System.out.println("Celular: " + rs.getString("celular"));
				System.out.println("E-Mail: " + rs.getString("email"));
				System.out.println("Sexo: " + rs.getString("sexo"));
				System.out.println("--------------------------");
				
			}
			Conexao.fecharConexao();
			
		} catch (Exception erro){
			System.out.println(erro.getMessage());
			JOptionPane.showMessageDialog(null, "Ocorreu um Erro na Consulta!");
		}
	}

}