package br.senai.sp.jandira.agenda;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.jbdc.Conexao;

public class Agenda {

	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		ResultSet resultado = dao.getContatos();
		
		try {
			while (resultado.next()){
				System.out.println("LISTA DE CONTATO");
				System.out.println("--------------------------");
				System.out.println(resultado.getInt("id") + " - Nome: " + resultado.getString("nome"));
				System.out.println("Data De Nascimento: " + resultado.getString("dtNasc"));
				System.out.println("Endereço: " + resultado.getString("endereco"));
				System.out.println("Telefone: " + resultado.getString("telefone"));
				System.out.println("Celular: " + resultado.getString("celular"));
				System.out.println("E-Mail: " + resultado.getString("email"));
				System.out.println("Sexo: " + resultado.getString("sexo"));
				System.out.println("--------------------------");
				
			}
			Conexao.fecharConexao();
			
		} catch (Exception erro){
			System.out.println(erro.getMessage());
			JOptionPane.showMessageDialog(null, "Ocorreu um Erro na Consulta!");
		}
	}

}