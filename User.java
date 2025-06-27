package br.betinha.sys;
import java.util.Random;
import java.util.Scanner;

public class User {
	//scanner
	Scanner in = new Scanner(System.in);
	//random
	Random random = new Random();
	
	//piadas 
	//
	//numero aleatorio
	int aleatorioMenorIdade = random.nextInt(10) + 1;
	int aleatorioViagemTemporal = random.nextInt(3) + 1;
	int aleatorioMensagem = random.nextInt(3) + 1;
	//
	//viagem temporal
	boolean viagemTemporal = false;
	
	//-var operacionais-
	//
	//*saldo
	private double saldo = 5000;
	
	//aposta 
	private double valorAposta;
	
	//dados user
	private String nome;
	private String senhaConta;
	private String senhaCartao;
	private String cpf;
	private String email;
	private String logradouro;
	private String cep;
	private String telefone;
	private String senhaCartaoDigitada;
	private boolean a = true;
	
	//*operacionais
	//
	//**saque e depósito
	boolean verificacao = false;
	final int MAX_TENTATIVAS = 3;
	int tentativas = 0;
	boolean cartaoBloqueado = false;
	double valorDeposito = 0;
	boolean login = false;
	private String senhaDigitada;
	private String nomeDigitado;
	boolean bloqueioDefinitivo = false;
	boolean logindefinitivo = true;
	//
	//**login
	int tentativasLogin = 1;
	
	
	//identidade
	public void identidade() {
		System.out.println("======================================");
		System.out.println("Bem-vindo ao sistema vital da Betinha, um rogue-like (não sei o que significa, mas usei essa palavra porque a achei sensasional) INSANO sobre um cassino-bet caótico!");
		System.out.println("Além do nosso cassino e bet, você encontrara um sistema bancário, um cartão e uma loja na qual você poderá gastar seu dinheiro!!!");
		System.out.println("======================================");
		System.out.println("Para usufruir desse sistema genial, insira seus dados nos campos a seguir.");
		System.out.println("======================================");
		System.out.print("Nome do usuário: ");
		this.nome = in.nextLine();
		System.out.print("CPF: ");
		int menoridade = random.nextInt(10) + 1;
		this.cpf = in.nextLine();
		System.out.print("E-mail: ");
		this.email = in.nextLine();
		System.out.print("Telefone: ");
		this.telefone = in.nextLine();
		System.out.print("CEP: ");
		this.cep = in.nextLine();
		System.out.print("Logradouro: ");
		this.logradouro = in.nextLine();
		System.out.print("Senha da conta: ");
		this.senhaConta = in.nextLine();
		System.out.print("Senha do cartão (Obs.: esta senha não poderá ser redefinida): ");
		this.senhaCartao = in.nextLine();
		if (menoridade == 1) {
			System.out.println("Na consulta à Receita Federal, você é menor de 18 anos. Não será possível utilizar a Betinha no prazo de " + aleatorioMenorIdade + " anos");
			System.out.println("Viajar no tempo? (True para sim, false para não.)");
			viagemTemporal = in.nextBoolean();
			
			if (viagemTemporal == true) {
				System.out.println("Você decide, imprudentemente, entrar num buraco de minhoca para jogar num cassino... Vamos ver na onde isso dá.");
				System.out.println("======================================");
				if (aleatorioViagemTemporal == 3) {
					if (aleatorioMensagem == 1) {
						System.out.print("Uma borboleta, que pensava que ia encontrar uma refeição, acabou entrando junto com você! \nVocê meio que destruiu o universo. \nParabéns. \n");
						logindefinitivo = false;
					} else if (aleatorioMensagem == 2) {
						System.out.println("Você conseguiu! \nMentira, na verdade, quando saiu do buraco de minhoca, você acabou tropeçando numa banana e isso ruiu o Mark Zuckerberg, que ficou maluco e destruiu o planeta Terra. \nIt's over para o beta. \n");
						logindefinitivo = false;
					} else {
						System.out.print("Você conseguiu! \nVoltar 4,56 bilhões de anos. \nAcho que você errou as configurações do buraco de minhoca, e a falta de cianobactérias te deixou sem oxigênio. \n(In)felizmente, nessa época não existia  Betinha. \n");
						logindefinitivo = false;
					}
				} else {
					System.out.print("Você distorceu o tecido do espaço-tempo e pode ter bagunçado a vida de inúmeros seres. \nMas, você pode apostar. \nVocê se enche de determinação com o poder da imprudência, \nda pilantragem, \ndo vício em apostas, \ne da infalibilidade da lei de Murphy.\n");
					logindefinitivo = true;
				}
			} else {
				System.out.print("Você é ético e não quis definhar o tecido do espaço-tempo (ou criar uma nova linha temporal) \ne, talvez, instaurar o caos universal para jogar num cassino michuruca. \nContinue assim. \n");
				logindefinitivo = false;
			}
		}
		System.out.println("======================================");
		login = false;
		

	}
	
	
	
	//login
	public void login() {
			int tentativasRestantesLogin = MAX_TENTATIVAS - tentativasLogin;
			System.out.println("Para o log-in, verifique seus dados a seguir");
			System.out.println("======================================");
			System.out.print("Nome do usuario: ");
			nomeDigitado = in.nextLine();
			System.out.print("Senha da conta: ");
			senhaDigitada = in.nextLine();
			System.out.println("======================================");
			
			if ((!senhaConta.equals(senhaDigitada) || !nome.equals(nomeDigitado)) && tentativasRestantesLogin > 0) {
				tentativasLogin = tentativasLogin + 1;
				tentativasRestantesLogin = (MAX_TENTATIVAS - tentativasLogin) + 1;
				System.out.println("===========================================");
				System.out.println("Usuario e/ou senha incorretos. Tentativas restantes: " + tentativasRestantesLogin);
				System.out.println("===========================================");
				tentativasRestantesLogin = (MAX_TENTATIVAS - tentativasLogin) + 1;
			} else if (senhaConta.equals(senhaDigitada) && nome.equals(nomeDigitado) && tentativasRestantesLogin > 0)  {
				login = true;
				System.out.println("Log-in bem sucedido!");
			} else if (tentativasLogin == MAX_TENTATIVAS) {
				System.out.println("Numero maximo de tentativas excedido! Reinicie o sistema e tente novamente.");
				logindefinitivo = false;
			}
	} 
	
	//opcoes de saque e deposito do banco da bet
	public void sacarSaldo() {
		a = true;
		verificacao = false;
		while (cartaoBloqueado == false && a == true) {
		int tentativasRestantes = MAX_TENTATIVAS - tentativas;
		System.out.println("Insira a quantidade que você deseja sacar do seu saldo de apostas:");
		double s = in.nextDouble();
		in.nextLine();
		System.out.println("===========================================");
		System.out.print("Confirme sua senha (senha do cartão): ");
		senhaCartaoDigitada = in.nextLine();
		System.out.println("===========================================");
		
		if (senhaCartaoDigitada.equals(senhaCartao)) {
			verificacao = true;
		} else {
			verificacao = false;
			this.tentativas += 1;
		}	
		
		if(s > this.valorDeposito && verificacao == true) {
			System.out.println("Não é possiível sacar uma quantia maior daquela possuída em conta.");
			a = false;
			System.out.println("===========================================");
		} else if (s <= this.valorDeposito && verificacao == true){
			this.saldo += s;
			this.valorDeposito -= s;
			System.out.println("Saque realizado com sucesso!");
			a = false;
			System.out.println("===========================================");
		} else if (s <= this.valorDeposito && verificacao == false) {
			System.out.println("Senha do cartão incorreta. Tentativas restantes até o bloqueio do cartão: " + tentativasRestantes);
			System.out.println("===========================================");
			if (tentativasRestantes <= 0) {
				this.cartaoBloqueado = true;
				System.out.println("Cartão bloqueado. Desbloqueie e tente novamente mais tarde.");
				a = false;
				System.out.println("===========================================");
			}
		} else if (s > this.valorDeposito && verificacao == false) {
			System.out.println("Senha incorreta e quantidade inválida. Tentativas restantes: " + tentativasRestantes);
			System.out.println("===========================================");
		} else if(s <= 0 && verificacao == true) {
			System.out.println("Não e possivel sacar essa quantia.");
			System.out.println("===========================================");
		} else if (s <= 0 && verificacao == false) {
			System.out.println("Quantidade inválida e senha do cartão incorreta.");
			System.out.println("===========================================");
		} else if (cartaoBloqueado == true) {
			System.out.println("Cartão bloqueado. Tente novamente mais tarde.");
			System.out.println("===========================================");
		}
	} 
		
}
	
 
	
	public void depositarSaldo() {
		a = true;
		verificacao = false;
		while (cartaoBloqueado == false && a == true) {
		int tentativasRestantes = MAX_TENTATIVAS - tentativas;
		System.out.println("Insira a quantidade que você deseja depositar para apostar:");
		double s = in.nextDouble();
		in.nextLine();
		System.out.println("===========================================");
		System.out.print("Confirme sua senha (senha do cartão): ");
		senhaCartaoDigitada = in.nextLine();
		System.out.println("===========================================");
		
		if (senhaCartaoDigitada.equals(senhaCartao)) {
			verificacao = true;
		} else {
			verificacao = false;
			this.tentativas += 1;
		}	
		
		if(s > this.saldo && verificacao == true) {
			System.out.println("Não é possivel depositar uma quantia maior daquela possuida em conta.");
			a = false;
			System.out.println("===========================================");
		} else if (s <= this.saldo && verificacao == true){
			this.saldo -= s;
			this.valorDeposito += s;
			System.out.println("Depósito realizado com sucesso!");
			a = false;
			System.out.println("===========================================");
		} else if (s <= this.saldo && verificacao == false) {
			System.out.println("Senha do cartão incorreta. Tentativas restantes até o bloqueio do cartão: " + tentativasRestantes);
			System.out.println("===========================================");
			if (tentativasRestantes <= 0) {
				this.cartaoBloqueado = true;
				System.out.println("Cartão bloqueado. Desbloqueie e tente novamente mais tarde.");
				a = false;
				
				System.out.println("===========================================");
			}
		} else if (s > this.saldo && verificacao == false) {
			System.out.println("Senha incorreta e quantidade inválida. Tentativas restantes: " +tentativasRestantes);
			System.out.println("===========================================");
		} else if(s <= 0 && verificacao == true) {
			System.out.println("Não é possivel depositar essa quantia.");
			System.out.println("===========================================");
		} else if (s <= 0 && verificacao == false) {
			System.out.println("Quantidade inválida e senha do cartão incorreta.");
			System.out.println("===========================================");
		}  else if (cartaoBloqueado == true) {
			System.out.println("Cartão bloqueado. Tente novamente mais tarde.");
			System.out.println("===========================================");
		}
	}	
}
	
	
	//getters e setters
	public double getSaldo() {
		return this.saldo;
		}
	
	public double getSaldoAposta( ) {
		return this.valorDeposito;
		}
	
	public void setNome(String n) {
		n = this.nome;
		}
	
	public void setCEP(String c) {
		c = this.cep;
		}
	
	public void setLogradouro(String l) {
		l = this.logradouro;
		}
	
	public void setSenhaConta(String s) {
		s = this.senhaConta;
		}
	
	public void setCPF(String c) {
		c = this.cpf;
		}
	
	public void setEMAIL(String e) {
		e = this.email;
		}
	
	public void setTelefone(String t) {
		t = this.telefone;
		}
	
	public String getNome() {
		return this.nome;
		}
	
	public String getSenhaConta() {
		return this.senhaConta;
		}
	
	public String getEMAIL() {
		return this.email;
		}
	
	public String getCPF() {
		return this.cpf;
	}
	
	public String getLogradouro() {
		return this.logradouro;
	}
	
	public String getTelefone() {
		return this.telefone;
		}
	
	public String getCEP() {
		return this.cep;
		}
	
	
	//desbloquear cartao
	public void desbloquearCartao() {
		while (bloqueioDefinitivo == false && a == true) {
		System.out.println("======================================");
		System.out.print("Para desbloquear seu cartao, insira a senha da sua conta a seguir:");
		String senhaContaDigitada = in.nextLine();
		System.out.println("======================================");
			if (senhaContaDigitada.equals(senhaConta)) {
				System.out.println("======================================");
				System.out.println("Cartao desbloqueado com sucesso!");
				System.out.println("======================================");
				a = false;
			} else {
				System.out.println("======================================");
				System.out.println("Cartao bloqueado definitivamente. Reinicie o sistema.");
				System.out.println("======================================");
				bloqueioDefinitivo = true;
			} 
		} System.out.println("Cartão bloqueado definitivamente. Reinicie o sistema.");
		System.out.println("======================================");
	}
	
	//hora da aposta
	public void aposta() {
		System.out.println("Quanto você deseja apostar?");
		valorAposta = in.nextDouble();
		if (valorAposta <= this.valorDeposito) {
			valorDeposito -= valorAposta;
			System.out.println("======================================");
			System.out.println("Você apostou " + valorAposta + " reais.");
			System.out.println("======================================");
			System.out.printf("Saldo de apostas atual: R$%.2f\n", valorDeposito);
			System.out.println("======================================");
		} else if (valorAposta <= 0) {
			System.out.println("======================================");
			System.out.println("Aposta inválida.");
			System.out.println("======================================");
		}
	}
	
	
	//multiplicadores de saldo
	
	public void multiplicador(double a) {
		double resultado = this.valorAposta * a;
		this.valorDeposito = this.valorDeposito + resultado;
		if (resultado != 0) {
			System.out.println("======================================");
			System.out.printf("Parabéns, você venceu! Saldo de apostas atual: R$%.2f\n", valorDeposito);
			System.out.println("======================================");
		} else {
			System.out.println("======================================");
			System.out.printf("Infelizmente, você perdeu. :c Na próxima você consegue! Saldo de apostas atual: R$%.2f\n", valorDeposito);
			System.out.println("======================================");
		}
	}
	//gastar na loja 
		public boolean gastar(double gasto) {
			if (gasto <= this.valorDeposito) {
				this.valorDeposito -= this.valorDeposito;
				return true;
			} else {
				return false;
			}
		}
		
		public void especiais(String s) {
			if (s.equals("Ralsei")) {
				System.out.println("======================================");
				System.out.println("Você descobriu um dos códigos secretos! 3000 reais foram adicionados ao seu saldo.");
				System.out.println("======================================");
				this.saldo += 5000;
			} else if (s.equals("Felipe")) {
				System.out.println("======================================");
				System.out.println("Você descobriu um dos códigos secretos! 3000 reais foram adicionados ao seu saldo.");
				System.out.println("======================================");
				this.saldo += 3000;
			} else if (s.equals("Isaías")) {
				System.out.println("======================================");
				System.out.println("Você descobriu um dos códigos secretos! 3000 reais foram adicionados ao seu saldo.");
				System.out.println("======================================");
				this.saldo += 3000;
			} else if (s.equals("Eduardo")) {
				System.out.println("======================================");
				System.out.println("Você descobriu um dos códigos secretos! 3000 reais foram adicionados ao seu saldo.");
				System.out.println("======================================");
				this.saldo += 3000;
			} else {
				System.out.println("======================================");
				System.out.println("Código inválido. :(");
				System.out.println("======================================");
			}
		}
		
		public void depositarBonus(double valor) {
		    this.saldo += valor;
		}

}
	
	

}

