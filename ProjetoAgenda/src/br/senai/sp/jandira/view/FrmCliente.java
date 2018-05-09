package br.senai.sp.jandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;

public class FrmCliente extends JFrame {

	private JPanel painelPrincipal;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldCelular;
	private JComboBox cbSexo;
	private JTextArea textArea;
	private JFormattedTextField textFieldDtNasc;

	public void setTextFieldId(int id) {
		this.textFieldId.setText(String.valueOf(id));
	}

	public void setTextFieldNome(String nome) {
		this.textFieldNome.setText(nome);
		;
	}

	public void setTextFieldEmail(String email) {
		this.textFieldEmail.setText(email);
	}

	public void setTextFieldDtNascimento(String dtNascimento) {
		this.textFieldDtNasc.setText(dtNascimento);
	}

	public void setTextFieldTelefone(String telefone) {
		this.textFieldTelefone.setText(telefone);
	}

	public void setTextFieldCelular(String celular) {
		this.textFieldCelular.setText(celular);
	}

	public void setCbSexo(String sexo) {
		if (sexo.equals("F")) {
			cbSexo.setSelectedIndex(0);

		} else {
			cbSexo.setSelectedIndex(1);
		}
	}

	public void setTextArea(String area) {
		this.textArea.setText(area);
	}

	public FrmCliente(String operacao) {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Contatos");
		setBounds(100, 100, 678, 489);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 642, 92);
		painelPrincipal.add(panel);
		panel.setLayout(null);

		JLabel lblContatos = new JLabel("Contatos");
		lblContatos.setBackground(Color.GRAY);
		lblContatos.setBounds(0, 0, 307, 92);
		lblContatos.setForeground(Color.BLUE);
		lblContatos.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/contatos.png")));
		lblContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblContatos.setFont(new Font("Tahoma", Font.BOLD, 47));
		panel.add(lblContatos);

		JLabel lblOperacao = new JLabel("Opera\u00E7\u00E3o");
		lblOperacao.setForeground(Color.RED);
		lblOperacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOperacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacao.setBounds(483, 27, 98, 39);
		panel.add(lblOperacao);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados de Contato:",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(10, 114, 642, 248);
		painelPrincipal.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(10, 20, 28, 23);
		panel_1.add(lblID);

		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldId.setBounds(10, 39, 86, 20);
		panel_1.add(textFieldId);
		textFieldId.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(106, 23, 46, 18);
		panel_1.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNome.setBounds(106, 39, 526, 20);
		panel_1.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 70, 46, 14);
		panel_1.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldEmail.setBounds(10, 84, 440, 20);
		panel_1.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSexo.setBounds(457, 70, 46, 14);
		panel_1.add(lblSexo);

		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] { "Nao Especificado", "Feminino", "Masculino" }));
		cbSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbSexo.setBounds(460, 84, 172, 20);
		panel_1.add(cbSexo);

		JLabel lblDatNascimento = new JLabel("Dt.Nascimento");
		lblDatNascimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDatNascimento.setBounds(10, 115, 86, 14);
		panel_1.add(lblDatNascimento);

		JLabel lbltelefone = new JLabel("Telefone:");
		lbltelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbltelefone.setBounds(161, 115, 55, 14);
		panel_1.add(lbltelefone);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTelefone.setBounds(162, 132, 240, 20);
		panel_1.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCelular.setBounds(412, 115, 46, 14);
		panel_1.add(lblCelular);

		textFieldCelular = new JTextField();
		textFieldCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCelular.setBounds(412, 132, 220, 20);
		panel_1.add(textFieldCelular);
		textFieldCelular.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereco.setBounds(10, 161, 75, 14);
		panel_1.add(lblEndereco);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 622, 62);
		panel_1.add(scrollPane);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		/* DEFININDO A MÁSCARA PARA UMA DATA */
		MaskFormatter dataMask = null;
		
		try {
			dataMask = new MaskFormatter("##/##/####");
			
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		
		
		textFieldDtNasc = new JFormattedTextField(dataMask);
		textFieldDtNasc.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDtNasc.setBounds(10, 133, 134, 19);
		panel_1.add(textFieldDtNasc);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 358, 642, 92);
		painelPrincipal.add(panel_2);
		panel_2.setLayout(null);

		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setBounds(517, 11, 115, 66);
		panel_2.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Você deseja sair?", "Sair do Sistema", JOptionPane.YES_NO_CANCEL_OPTION);
				if (resposta == 0){
					FrmCliente.this.dispose();
				}
			}
		});

		JButton btnSalvar = new JButton("");
		
		/* AÇÃO DO BOTÃO SALVAR */
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat toDataBase = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000000");
				
				Date date = null;
				String dataAccess = "";
							
				try {
					date = toDate.parse(textFieldDtNasc.getText());
					dataAccess = toDataBase.format(date);
					
					Contato contato = new Contato();
					contato.setNome(textFieldNome.getText());
					contato.setDtNascimento(dataAccess);
					contato.setTelefone(textFieldTelefone.getText());
					contato.setCelular(textFieldCelular.getText());
					contato.setEmail(textFieldEmail.getText());
					contato.setEndereco(textArea.getText());
					contato.setSexo(cbSexo.getSelectedItem().toString().substring(0, 1));
					
					ContatoDAO contatoDAO = new ContatoDAO();
					contatoDAO.setContato(contato);
					
					if (lblOperacao.getText().equals("Adicionar")){
						contatoDAO.gravar();
						limparControles();
						
					} else if (lblOperacao.getText().equals("Editar")){
						contato.setId(Integer.parseInt(textFieldId.getText()));
						
						JOptionPane.showMessageDialog(null, "Deseja Mesmo Atualizar o Usúario!?",
								"Atualizando Usúario", JOptionPane.CLOSED_OPTION);
						
						contatoDAO.atualizar();
							
					} else if (lblOperacao.getText().equals("Excluir")){
						contato.setId(Integer.parseInt(textFieldId.getText()));
						
						int resposta = JOptionPane.showConfirmDialog(null, "Você deseja sair?", "Sair do Sistema", JOptionPane.YES_NO_CANCEL_OPTION);
						if (resposta == 0){
							System.exit(0);
							
						contatoDAO.excluir();
						}
						
					}
					
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, "A Data Está Incorreta!",
							"Data Incorreta", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
					
				}
				
				/* ANTES DE TUDO CRIAR UM CONTATO */

			}
			
	});
		
		btnSalvar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/save.png")));
		btnSalvar.setBounds(10, 11, 115, 66);
		panel_2.add(btnSalvar);
		
	}
		
	private void limparControles(){
		textFieldId.setText("");
		textFieldNome.setText("");
		textFieldEmail.setText("");
		textFieldDtNasc.setText("");
		textFieldTelefone.setText("");
		textFieldCelular.setText("");
		textArea.setText("");
		cbSexo.setSelectedIndex(0);
		textFieldNome.grabFocus();
	}
}