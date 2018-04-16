package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	private JPanel painelTabela;

	public FrmAgenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 604);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.BLACK);
		painelTitulo.setBounds(0, 0, 691, 88);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Agenda de Contatos");
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda64.png")));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(0, 0, 691, 88);
		painelTitulo.add(lblTitulo);
		
		//**** CONSTRU플O DA TABELA ****//
		criarTabela();
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(Color.BLACK);
		painelBotoes.setBorder(new CompoundBorder());
		painelBotoes.setBounds(10, 466, 677, 88);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmContatos novo = new FrmContatos();
				novo.setVisible(true);
				
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNovo.setBounds(10, 11, 107, 66);
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userAdd.png")));
		btnNovo.setToolTipText("Cadastrar Novo Contato");
		painelBotoes.add(btnNovo);
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContatos editar = new FrmContatos();
				editar.setVisible(true);
				
				// **** SELECIONANDO AS LINHAS E COLUNAS **** //
				//System.out.println(tabelaContatos.getValueAt(tabelaContatos.getSelectedRow(),tabelaContatos.getSelectedColumn()));
			}
		});
		btnEditar.setBounds(137, 11, 107, 66);
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userEdit.png")));
		btnEditar.setToolTipText("Edita o Cadastro");
		painelBotoes.add(btnEditar);
		
		JButton btnExcuir = new JButton("");
		btnExcuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContatos excluir = new FrmContatos();
				excluir.setVisible(true);
			}
		});
		btnExcuir.setBounds(275, 11, 107, 66);
		btnExcuir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userDelete.png")));
		btnExcuir.setToolTipText("Cadastrar Novo Contato");
		painelBotoes.add(btnExcuir);
		
		JButton btnSair = new JButton("");
		btnSair.setBounds(560, 11, 107, 66);
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setToolTipText("Cadastrar Novo Contato");
		painelBotoes.add(btnSair);
	}
	
	public void criarTabela(){
		
		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Meus Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelTabela.setBounds(0, 92, 691, 363);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 675, 331);
		painelTabela.add(scrollTabela);
		
		tabelaContatos = new JTable();
		
		ArrayList<Contato> contatos = new ArrayList<>();
		ContatoDAO dao = new ContatoDAO();
		contatos = dao.getListaContatos();
		
		/***** TITULO DA TABELA *****/
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			// **** TRAVAR EDI플O DAS TABELAS **** //
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		String[] nomesColunas = {"ID","NOME","E-MAIL"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		
		/**** DADODS TDA TABLEA ****/
		Object[] linha = new Object[3];
		
		for (Contato contato : contatos){
			linha[0] = contato.getId();
			linha[1] = contato.getNome();
			linha[2] = contato.getEmail();
			modeloTabela.addRow(linha);
		}
		
		tabelaContatos.setModel(modeloTabela);	
		
		// **** TRAVANDO MOVIMENTA플O E EDI플O DAS COLUNAS **** //
		tabelaContatos.getTableHeader().setReorderingAllowed(false);
		
		// **** FORMATA플O DAS COLUNAS DA TABLEA **** //
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaContatos.getColumnModel().getColumn(0).setResizable(false);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(190);
		tabelaContatos.getColumnModel().getColumn(1).setResizable(false);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(174);
		tabelaContatos.getColumnModel().getColumn(2).setResizable(false);
		scrollTabela.setViewportView(tabelaContatos);
		
	}
}