package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		setTitle("Agenda");
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

		// **** TABELA ****//
		criarTabela();

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(Color.BLACK);
		painelBotoes.setBorder(new CompoundBorder());
		painelBotoes.setBounds(10, 466, 677, 88);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);

		JButton btnNovo = new JButton("");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNovo.setBounds(10, 11, 107, 66);
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userAdd.png")));
		btnNovo.setToolTipText("Cadastrar Novo Contato");
		painelBotoes.add(btnNovo);

		/**** EVENTO ADICIONAR ****/
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmContatos novo = new FrmContatos("Adicionar");
				novo.setVisible(true);

			}
		});

		JButton btnEditar = new JButton("");
		btnEditar.setBounds(137, 11, 107, 66);
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userEdit.png")));
		btnEditar.setToolTipText("Edita o Cadastro");
		painelBotoes.add(btnEditar);

		/**** EVENTO EDITAR ****/
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar("Editar");

			}
		});

		JButton btnExcuir = new JButton("");
		btnExcuir.setBounds(275, 11, 107, 66);
		btnExcuir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userDelete.png")));
		btnExcuir.setToolTipText("Cadastrar Novo Contato");
		painelBotoes.add(btnExcuir);

		/**** EVENTO EXCLUIR ****/
		btnExcuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar("Excluir");
			}
		});

		JButton btnSair = new JButton("");
		btnSair.setBounds(560, 11, 107, 66);
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setToolTipText("Cadastrar Novo Contato");
		painelBotoes.add(btnSair);

	}

	public void criarTabela() {
		painelTabela = new JPanel();
		painelTabela.setBorder(
				new TitledBorder(null, "Meus Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
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
		DefaultTableModel modeloTabela = new DefaultTableModel() {

			// **** TRAVAR EDI플O DAS TABELAS **** //
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		String[] nomesColunas = { "ID", "NOME", "E-MAIL" };
		modeloTabela.setColumnIdentifiers(nomesColunas);

		/**** DADODS TDA TABLEA ****/
		Object[] linha = new Object[3];

		for (Contato contato : contatos) {
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

	public void Adicionar(String operacao) {
		FrmContatos frmContato = new FrmContatos(operacao);
		frmContato.setTitle(operacao + " Contato");
		int linha = 0;
		int id = 0;

		try {
			linha = tabelaContatos.getSelectedRow();
			id = (int) tabelaContatos.getValueAt(linha, 0);

			ContatoDAO contatoDAO = new ContatoDAO();
			Contato contato = new Contato();
			contato = contatoDAO.getContato(id);

			frmContato.setTextFieldId(contato.getId());
			frmContato.setTextFieldNome(contato.getNome());
			frmContato.setTextFieldEmail(contato.getEmail());
			frmContato.setTextFieldDtNascimento(contato.getDtNascimento());
			frmContato.setTextFieldTelefone(contato.getTelefone());
			frmContato.setTextFieldCelular(contato.getCelular());
			frmContato.setCbSexo(contato.getSexo());
			frmContato.setTextArea(contato.getEndereco());
			frmContato.setVisible(true);

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			JOptionPane.showMessageDialog(null, "Por Favor Escolha um Contato na Lista.", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// **** SELECIONANDO AS LINHAS E COLUNAS **** //
	// System.out.println(tabelaContatos.getValueAt(tabelaContatos.getSelectedRow(),tabelaContatos.getSelectedColumn()));
}