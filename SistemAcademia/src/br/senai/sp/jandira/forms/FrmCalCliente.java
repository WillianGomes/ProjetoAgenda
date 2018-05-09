package br.senai.sp.jandira.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.senai.sp.jandira.classes.Clientes;

public class FrmCalCliente extends JFrame {

	public FrmCalCliente() {
		setSize(700, 400);
		setTitle("Calculadora de Calorias");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// CRIANDO UMA FONTE
		Font fonte = new Font("Arial", 0, 13);

		// CRIANDO AS CORES
		Color color1 = new Color(229, 227, 135);
		Color color2 = new Color(214, 216, 219);
		Color color3 = new Color(72, 158, 74);

		// CRIANDO AS BORDAS COM TITULOS
		TitledBorder bordaTitulo1 = new TitledBorder("Dados:");
		TitledBorder bordaTitulo2 = new TitledBorder("Resultados:");

		// CRIANDO OS PAINEIS
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(color2);
		painelTitulo.setBorder(null);
		painelTitulo.setLayout(null);

		JPanel painelDados = new JPanel();
		painelDados.setBackground(color1);
		painelDados.setBorder(bordaTitulo1);
		painelDados.setLayout(null);

		JPanel painelResultado = new JPanel();
		painelResultado.setBackground(color1);
		painelResultado.setBorder(bordaTitulo2);
		painelResultado.setLayout(null);

		// CRIANDO O COMBOBOX
		JComboBox<String> comboAtividade = new JComboBox<>();
		String[] vetorAtividade = { "Sedentário", "Levemente Ativo", "Moderadamente Ativo","Bastante Ativo", "Muito Ativo" };
		DefaultComboBoxModel<String> modeloAtividade = new DefaultComboBoxModel<>(vetorAtividade);

		// DEFININDO O MODELO
		comboAtividade.setModel(modeloAtividade);

		// CRIANDO OS BOTÕES
		JButton btnCalcular = new JButton();

		// BOTÕES DE GÊNERO
		JRadioButton btnHomem = new JRadioButton();
		JRadioButton btnMulher = new JRadioButton();
		btnHomem.setBackground(color1);
		btnMulher.setBackground(color1);

		// GRUPO DE BOTÕES
		ButtonGroup genero = new ButtonGroup();
		genero.add(btnHomem);
		genero.add(btnMulher);

		// CRIANDO OS jLABEL DOS GÊNEROS
		JLabel lblHomem = new JLabel("Homem");
		JLabel lblMulher = new JLabel("Mulher");

		// CRIANDO JLABEL DO PAINEL DE TITULO
		JLabel lblTitulo = new JLabel("BOA FORMA");

		// CRIANDO OS JLABEL DO PAINEL DE DADOS
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblSexo = new JLabel("Sexo:");
		JLabel lblPeso = new JLabel("Peso:");
		JLabel lblAltura = new JLabel("Altura:");
		JLabel lblIdade = new JLabel("Idade:");
		JLabel lblAtividade = new JLabel("Nível de Atividade:");
		JLabel lblQuilos = new JLabel("quilos");
		JLabel lblCm = new JLabel("cm");
		JLabel lblAnos = new JLabel("anos");

		// CRIANDO OS JLABEL DO PAINEL DE RESULTADOS
		JLabel lblNome2 = new JLabel("Nome:");
		JLabel lblPeso2 = new JLabel("Peso:");
		JLabel lblAltura2 = new JLabel("Altura:");
		JLabel lblIdade2 = new JLabel("Idade:");
		JLabel lblAtividade2 = new JLabel("Nível de Atividade:");
		JLabel lblImc1 = new JLabel("IMC:");
		JLabel lblTmb1 = new JLabel("TMB:");
		JLabel lblFcm1 = new JLabel("FCM:");

		// CRIANDO OS JLABEL PARA RECEBER O RESULTADO
		JLabel lblNomeResultado = new JLabel("---");
		JLabel lblPesoResultado = new JLabel("---");
		JLabel lblAlturaResultado = new JLabel("---");
		JLabel lblIdadeResultado = new JLabel("---");
		JLabel lblAtividadeResultado = new JLabel("---");
		JLabel lblImc2 = new JLabel("---");
		JLabel lblTmb2 = new JLabel("---");
		JLabel lblFcm2 = new JLabel("---");
		
		
		// COLOCANDO COR NOS JLABEL
		lblNomeResultado.setForeground(color3);
		lblPesoResultado.setForeground(color3);
		lblAlturaResultado.setForeground(color3);
		lblIdadeResultado.setForeground(color3);
		lblAtividadeResultado.setForeground(color3);
		lblImc2.setForeground(color3);
		lblTmb2.setForeground(color3);
		lblFcm2.setForeground(color3);

		// CRIANDO TEXTFIELD ("AS CAIXAS")
		// CAIXA COM NOME
		JTextField txtVisor1 = new JTextField("");
		txtVisor1.setEditable(true);
		txtVisor1.setBackground(Color.white);
		txtVisor1.setForeground(Color.black);
		txtVisor1.setFont(fonte);

		// CAIXA COM PESO
		JTextField txtVisor2 = new JTextField("");
		txtVisor2.setEditable(true);
		txtVisor2.setBackground(Color.white);
		txtVisor2.setForeground(Color.black);
		txtVisor2.setFont(fonte);

		// CAIXA COM ALTURA
		JTextField txtVisor3 = new JTextField("");
		txtVisor3.setEditable(true);
		txtVisor3.setBackground(Color.white);
		txtVisor3.setForeground(Color.black);
		txtVisor3.setFont(fonte);

		// CAIXA COM IDADE
		JTextField txtVisor4 = new JTextField("");
		txtVisor4.setEditable(true);
		txtVisor4.setBackground(Color.white);
		txtVisor4.setForeground(Color.black);
		txtVisor4.setFont(fonte);

		// CAIXA COM INFORMAÇÕES DO IMC
		JTextArea txtVisor5 = new JTextArea("");
		txtVisor5.setEditable(true);
		txtVisor5.setBackground(Color.white);
		txtVisor5.setForeground(Color.black);
		txtVisor5.setFont(fonte);

		// CRIANDO A IMAGEM
		ImageIcon iconUser = new ImageIcon(FrmCalCliente.class.getResource("/br/senai/sp/jandira/imagens/Yoga1.png"));
		ImageIcon iconCalc = new ImageIcon(FrmCalCliente.class.getResource("/br/senai/sp/jandira/imagens/Calc2.png"));

		// COLOCANDO NO PAINEL
		getContentPane().add(painelTitulo);
		getContentPane().add(painelDados);
		getContentPane().add(painelResultado);

		// PAINEL DE TITULO
		painelTitulo.add(lblTitulo);

		// COLOCANDO NO PAINEL DE DADOS
		painelDados.add(lblNome);
		painelDados.add(lblSexo);
		painelDados.add(lblPeso);
		painelDados.add(lblAltura);
		painelDados.add(lblIdade);
		painelDados.add(lblAtividade);
		painelDados.add(comboAtividade);
		painelDados.add(btnCalcular);
		painelDados.add(txtVisor1);
		painelDados.add(txtVisor2);
		painelDados.add(txtVisor3);
		painelDados.add(txtVisor4);
		painelDados.add(lblQuilos);
		painelDados.add(lblCm);
		painelDados.add(lblAnos);
		painelDados.add(btnHomem);
		painelDados.add(btnMulher);
		painelDados.add(lblHomem);
		painelDados.add(lblMulher);

		// COLOCANDO NO PAINEL RESULTADO
		painelResultado.add(lblNome2);
		painelResultado.add(lblPeso2);
		painelResultado.add(lblAltura2);
		painelResultado.add(lblIdade2);
		painelResultado.add(lblAtividade2);
		painelResultado.add(lblImc1);
		painelResultado.add(lblTmb1);
		painelResultado.add(lblFcm1);
		painelResultado.add(txtVisor5);

		// DEFINDO O LOCAL PARA RECEBER OS RESULTADOS
		painelResultado.add(lblNomeResultado);
		painelResultado.add(lblPesoResultado);
		painelResultado.add(lblAlturaResultado);
		painelResultado.add(lblIdadeResultado);
		painelResultado.add(lblAtividadeResultado);
		painelResultado.add(lblImc2);
		painelResultado.add(lblTmb2);
		painelResultado.add(lblFcm2);

		// DEFINDO O LOCAL
		painelTitulo.setBounds(0, 0, 685, 58);
		painelDados.setBounds(0, 60, 250, 300);
		painelResultado.setBounds(251, 60, 435, 300);
		lblTitulo.setBounds(5, -20, 300, 100);

		// DEFINDO O LOCAL NO PAINEL DE DADOS
		lblNome.setBounds(10, -10, 100, 100);
		lblSexo.setBounds(10, 20, 100, 100);
		lblPeso.setBounds(10, 50, 100, 100);
		lblAltura.setBounds(10, 80, 100, 100);
		lblIdade.setBounds(10, 110, 100, 100);
		lblAtividade.setBounds(10, 140, 200, 100);
		btnCalcular.setBounds(30, 250, 120, 40);
		comboAtividade.setBounds(10, 210, 180, 20);
		txtVisor1.setBounds(60, 33, 180, 18);
		txtVisor2.setBounds(60, 93, 50, 18);
		txtVisor3.setBounds(60, 123, 50, 18);
		txtVisor4.setBounds(60, 153, 50, 18);
		lblQuilos.setBounds(115, 93, 50, 18);
		lblCm.setBounds(115, 123, 50, 18);
		lblAnos.setBounds(115, 153, 50, 18);
		btnHomem.setBounds(50, 62, 20, 20);
		btnMulher.setBounds(130, 62, 20, 20);
		lblHomem.setBounds(80, 62, 100, 20);
		lblMulher.setBounds(160, 62, 100, 20);

		// DEFINDO O LOCAL NO PAINEL DE RESULTADOS
		lblNome2.setBounds(40, -10, 100, 100);
		lblIdade2.setBounds(40, 20, 100, 100);
		lblPeso2.setBounds(40, 80, 100, 100);
		lblAltura2.setBounds(40, 50, 100, 100);
		lblAtividade2.setBounds(40, 110, 150, 100);
		lblImc1.setBounds(40, 140, 200, 100);
		lblTmb1.setBounds(40, 210, 200, 100);
		lblFcm1.setBounds(40, 235, 200, 100);
		txtVisor5.setBounds(40, 200, 385, 50);

		// DEFINDO O LOCAL PARA RECEBER OS RESULTADOS
		lblNomeResultado.setBounds(90, -10, 250, 100);
		lblIdadeResultado.setBounds(90, 20, 250, 100);
		lblPesoResultado.setBounds(90, 80, 250, 100);
		lblAlturaResultado.setBounds(90, 50, 250, 100);
		lblAtividadeResultado.setBounds(160, 110, 250, 100);
		lblImc2.setBounds(90, 140, 300, 100);
		lblTmb2.setBounds(90, 210, 300, 100);
		lblFcm2.setBounds(90, 235, 300, 100);

		Clientes cliente1 = new Clientes();
		
		// DEFININDO A IMAGEM
		lblTitulo.setIcon(iconUser);
		btnCalcular.setIcon(iconCalc);

		// DEFININDO OS TEXTOS
		btnCalcular.setText("Calcular");
		btnCalcular.setToolTipText("Mostrar o Resultado");

		// EVENTOS
		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// COMANDOS PARA APARECER NO PAINEL
				lblNomeResultado.setText(txtVisor1.getText());
				lblPesoResultado.setText(txtVisor2.getText() + " quilos");
				lblAlturaResultado.setText(txtVisor3.getText() + " cm");
				lblAtividadeResultado.setText(String.valueOf(comboAtividade.getSelectedItem()));
				lblIdadeResultado.setText(txtVisor4.getText());
				
				// IMC
				cliente1.setPeso(Double.parseDouble(txtVisor2.getText()));
				cliente1.setAltura(Double.parseDouble(txtVisor3.getText()));
				cliente1.imc();
				lblImc2.setText(String.valueOf(cliente1.getImc()) + " Kg/m2");
				
				cliente1.mensagem();
				txtVisor5.setText(cliente1.getMensagem());
				
				// TMB
				if (btnHomem.isSelected()) {
					cliente1.setPeso(Double.parseDouble(txtVisor2.getText()));
					cliente1.setAltura(Double.parseDouble(txtVisor3.getText()));
					cliente1.setIdade(Double.parseDouble(txtVisor4.getText()));
					cliente1.setFrequencia(String.valueOf(comboAtividade.getSelectedItem()));
					cliente1.tmbHomem();
					lblTmb2.setText(String.valueOf(cliente1.getTmb()));
					
					
				} else if(btnMulher.isSelected()) {
					cliente1.setPeso(Double.parseDouble(txtVisor2.getText()));
					cliente1.setAltura(Double.parseDouble(txtVisor3.getText()));
					cliente1.setIdade(Double.parseDouble(txtVisor4.getText()));
					cliente1.setFrequencia(String.valueOf(comboAtividade.getSelectedItem()));
					cliente1.tmbMulher();
					lblTmb2.setText(String.valueOf(cliente1.getTmb()));
					
				}
				
				// FCM
					if (btnHomem.isSelected()) {
					cliente1.setPeso(Double.parseDouble(txtVisor2.getText()));
					cliente1.setIdade(Double.parseDouble(txtVisor4.getText()));
					cliente1.fcmHomem();
					lblFcm2.setText(String.valueOf(cliente1.getFcm()));
					
				} else if(btnMulher.isSelected()) {
					cliente1.setPeso(Double.parseDouble(txtVisor2.getText()));
					cliente1.setIdade(Double.parseDouble(txtVisor4.getText()));
					cliente1.fcmMulher();
					lblFcm2.setText(String.valueOf(cliente1.getFcm()));

				}
			}
		});
	}
}