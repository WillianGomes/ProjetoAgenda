package br.senai.sp.jandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		
		/* COLOCANDO O HORARIO */
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		Date dataAtual = new Date();
		
		JLabel lblData = new JLabel("Data Atual");
		lblData.setBounds(251, 89, 429, 22);
		painelPrincipal.add(lblData);
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setForeground(Color.BLACK);
		lblData.setText("Hoje é: " + df.format(dataAtual));

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
				FrmCliente novo = new FrmCliente("Adicionar");
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
				
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat dfBanco = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000000");
				
				String minhaData = "23-04-2018";
				Date dataSistema = null;
				
				
				try {
					dataSistema = df.parse(minhaData);
					System.out.println(dataSistema);
					
				} catch (ParseException e1) {
					e1.printStackTrace();
					
				}
				
				Adicionar("Excluir");
			}
		});

		JButton btnSair = new JButton("");
		btnSair.setBounds(560, 11, 107, 66);
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setToolTipText("Cadastrar Novo Contato");
		painelBotoes.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Você deseja sair?", "Sair do Sistema", JOptionPane.YES_NO_CANCEL_OPTION);
				if (resposta == 0){
					System.exit(0);
				}
			}
		});
		
	}

	public void criarTabela() {
		painelTabela = new JPanel();
		painelTabela.setBorder(
				new TitledBorder(null, "Meus Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelTabela.setBounds(0, 111, 691, 344);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);

		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 675, 323);
		painelTabela.add(scrollTabela);

		tabelaContatos = new JTable();

		ArrayList<Contato> contatos = new ArrayList<>();
		ContatoDAO dao = new ContatoDAO();
		contatos = dao.getListaContatos();

		/***** TITULO DA TABELA *****/
		DefaultTableModel modeloTabela = new DefaultTableModel() {

			// **** TRAVAR EDIÇÃO DAS TABELAS **** //
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

		// **** TRAVANDO MOVIMENTAÇÃO E EDIÇÃO DAS COLUNAS **** //
		tabelaContatos.getTableHeader().setReorderingAllowed(false);

		// **** FORMATAÇÃO DAS COLUNAS DA TABLEA **** //
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaContatos.getColumnModel().getColumn(0).setResizable(false);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(190);
		tabelaContatos.getColumnModel().getColumn(1).setResizable(false);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(174);
		tabelaContatos.getColumnModel().getColumn(2).setResizable(false);
		scrollTabela.setViewportView(tabelaContatos);

	}

	public void Adicionar(String operacao) {
		FrmCliente frmContato = new FrmCliente(operacao);
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
			frmContato.setTextFieldDtNascimento(contato.DtNascimento());
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
}