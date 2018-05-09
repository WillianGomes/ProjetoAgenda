package br.senai.sp.jandira.classes;

public class Clientes {

	private String nome;
	private String sexo;
	private double peso;
	private double altura;
	private double idade;
	private double imc;
	private double fcm;
	private double tmb;
	private double valor;
	private String mensagem;
	private String frequencia;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getIdade() {
		return idade;
	}

	public void setIdade(double idade) {
		this.idade = idade;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getFcm() {
		return fcm;
	}

	public void setFcm(double fcm) {
		this.fcm = fcm;
	}

	public double getTmb() {
		return tmb;
	}

	public void setTmb(double tmb) {
		this.tmb = tmb;
	}
	
	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	
	// METODOS
	public void imc(){
		
		valor = altura/100;
		imc = peso / (valor * valor);
	}
		
	public void tmbHomem() {
		this.tmb = 66 + (12.3 * peso) + (5 * altura) - (6.8 * idade);
			if (frequencia.equals("Sedentário")) {
				this.tmb = tmb * 1.20;	
				
			} else if (frequencia.equals("Levemente Ativo")) {
				this.tmb = tmb * 1.37;
				
			} else if (frequencia.equals("Moderadamente Ativo")) {
				this.tmb = tmb * 1.55;	
				
			} else if (frequencia.equals("Bastante Ativo")) {
				this.tmb = tmb * 1.72;
				
			} else if (frequencia.equals("Muito Ativo")) {
				this.tmb = tmb * 1.90;	
				
		}
	}
	
	public void tmbMulher(){
		this.tmb = 665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
			if (frequencia.equals("Sedentário")) {
				this.tmb = tmb * 1.20;	
				
			} else if (frequencia.equals("Levemente Ativo")) {
				this.tmb = tmb * 1.37;
				
			} else if (frequencia.equals("Moderadamente Ativo")) {
				this.tmb = tmb * 1.55;	
				
			} else if (frequencia.equals("Bastante Ativo")) {
				this.tmb = tmb * 1.72;
				
			} else if (frequencia.equals("Muito Ativo")) {
				this.tmb = tmb * 1.90;	
				
		}
	}


	public void fcmHomem(){
		this.fcm = ((210 -(0.5 * idade)) - peso/100) + 4;
		
	}
	
	public void fcmMulher(){
		this.fcm = ((210 -(0.5 * idade)) - peso/100);
		
	}
	
	public void mensagem(){
		if (imc >= 16 && imc <= 16.9) {
			mensagem = "Muito abaixo do peso \n\nQueda de cabelo, infertilidade, ausência menstrual.";
			
		} else if (imc >= 17 && imc <= 18.4) {
			mensagem = "Abaixo do peso \n\nFadiga, stress, ansiedade.";
		
		} else if (imc >= 18.5 && imc <= 24.9) {
			mensagem = "Peso normal \n\nMenor risco de doenças cardíacas e vasculares.";
		
		} else if (imc >= 25 && imc <= 29.9) {
			mensagem = "Acima do peso \n\nFadiga, má circulação, varizes.";
			
		} else if (imc >= 30 && imc <= 34.9) {
			mensagem = "Obesidade Grau I \n\nDiabetes, angina, infarto, aterosclerose.";
			
		} else if (imc >= 35 && imc <= 40) {
			mensagem = "Obesidade Grau II \n\nApneia do sono, falta de ar.";
					
		} else if (imc >= 40) {
			mensagem = "Obesidade Grau III \n\nRefluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
		
		}
	}
}