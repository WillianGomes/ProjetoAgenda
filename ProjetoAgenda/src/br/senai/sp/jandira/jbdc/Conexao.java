package br.senai.sp.jandira.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static Connection con;
	
	public static Connection getConexao(){
		
		con = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess://C:/Users/17259234/Documents/BancoDeDados1.accdb";
			con = DriverManager.getConnection(dbURL);
			
			
		} catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Não foi Possivel Conectar-se ao Banco de dados!",
					"Erro", JOptionPane.ERROR_MESSAGE);
			
		}
		
		return con;
	}
	
	public static void fecharConexao(){
		if (con != null){
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "O Banco já está Fechado!",
						"Erro", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
	}
}