package br.betinha.sys;
import java.util.Random;
import java.util.Scanner;

public class User {
	//ansi codes 
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";
    
	//scanner
	Scanner in = new Scanner(System.in);
	//random
	Random random = new Random();
	
	//piadas 
	//
	//numero aleatorio
	int aleatorioMenorIdade = random.nextInt(10) + 1;
	int aleatorioViagemTemporal = random.nextInt(3) + 1;
	int aleatorioMensagem = random.nextInt(4) + 1;
	//
	//viagem temporal
	boolean viagemTemporal = false;
	
	//-var operacionais-
	//
	//*saldo
	private double saldo = 5000;
	
	//aposta 
	private double valorAposta;
	
	//senha secreta
	private boolean senhaSecretaUsada = false;
	boolean ralsei = false;
	boolean felipe = false;
	boolean eduardo = false;
	boolean isaias = false;
	
	//dados user
	private String nome;
	private String senhaConta;
	private String senhaCartao;
	private String cpf;
	private String email;
	private String logradouro;
	private String cep;
	private String telefone;
	private String apelido;
	private String senhaCartaoDigitada;
	private boolean a = true;
	private boolean b = true;
	
	//*operacionais
	//
	//**saque e depósito
	boolean verificacao = false;
	final int MAX_TENTATIVAS = 3;
	int tentativas = 1;
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
		System.out.println(YELLOW + BOLD + "Bem-vindo ao sistema vital da Betinha, um roguelike \n(não sei o que significa, mas usei essa palavra porque a achei sensasional) \nINSANO sobre um cassino-bet caótico!");
		System.out.println("Além do nosso cassino e bet, você encontrara um sistema bancário, um cartão e uma loja na qual você poderá gastar seu dinheiro!!!");
		System.out.println(RESET + "======================================");
		System.out.println("Para usufruir desse sistema genial, insira seus dados nos campos a seguir.");
		System.out.println("======================================");
		System.out.print(CYAN + "Nome do usuário: " + RESET);
		this.nome = in.nextLine();
		System.out.print(CYAN + "Apelido: " + RESET);
		this.setApelido(in.nextLine());
		System.out.print(CYAN + "CPF: " + RESET);
		int menoridade = random.nextInt(10) + 1;
		this.cpf = in.nextLine();
		System.out.print(CYAN + "E-mail: " + RESET);
		this.email = in.nextLine();
		System.out.print(CYAN + "Telefone: " + RESET);
		this.telefone = in.nextLine();
		System.out.print(CYAN + "CEP: " + RESET);
		this.cep = in.nextLine();
		System.out.print(CYAN + "Logradouro: " + RESET);
		this.logradouro = in.nextLine();
		System.out.print(CYAN + "Senha da conta: " + RESET);
		this.senhaConta = in.nextLine();
		System.out.print(CYAN + "Senha do cartão (obs.: esta senha não poderá ser redefinida): " + RESET);
		this.senhaCartao = in.nextLine();
		if (menoridade == 1) {
			System.out.println(RED + "===========================================");
			System.out.println("Na consulta à Receita Federal, você é menor de 18 anos. Não será possível utilizar a Betinha no prazo de " + aleatorioMenorIdade + " anos.");
			System.out.println("===========================================");
			System.out.println(RESET + "Viajar no tempo? (True para sim, false para não.)");
			viagemTemporal = in.nextBoolean();
			in.nextLine();
			if (viagemTemporal == true) {
				System.out.println(BLUE + "Você decide, imprudentemente, entrar num buraco de minhoca para jogar num cassino... Vamos ver na onde isso dá." + RESET);
				System.out.println("======================================");
				if (aleatorioViagemTemporal == 3) {
					if (aleatorioMensagem == 1) {
						System.out.print(RED + "Uma borboleta, que pensava que ia encontrar uma refeição, acabou entrando junto com você! \nVocê meio que destruiu o universo. \nParabéns. \n" + RESET);
						logindefinitivo = false;
					} else if (aleatorioMensagem == 2) {
						System.out.println(RED + "Você conseguiu! \nMentira, na verdade, quando saiu do buraco de minhoca, você acabou tropeçando numa banana e isso ruiu o Mark Zuckerberg, que ficou maluco e destruiu o planeta Terra. \nIt's over para o beta. \n" + RESET);
						logindefinitivo = false;
					} else if (aleatorioMensagem == 3 ){
						System.out.print(RED + "Você conseguiu! \nVoltar 4,56 bilhões de anos. \nAcho que você errou as configurações do buraco de minhoca, e a falta de cianobactérias te deixou sem oxigênio. \n(In)felizmente, nessa época não existia  Betinha. \n" + RESET);
						logindefinitivo = false;
					} else {
						System.out.print(RED + "Uhm... Acho que você entrou no buraco de minhoca errado. \nEsse é muito pequeno, só cabe uma minhoca. \nPrecisa de ajuda? \n" + RESET);
					}
				} else {
					System.out.print(GREEN + "Você distorceu o tecido do espaço-tempo e pode ter bagunçado a vida de inúmeros seres. \nMas, você pode apostar. \nVocê se enche de determinação com o poder da imprudência, \nda pilantragem, \ndo vício em apostas, \ne da infalibilidade da lei de Murphy.\n" + RESET);
					logindefinitivo = true;
				}
			} else {
				System.out.print(GREEN + "Você é ético e não quis definhar o tecido do espaço-tempo (ou criar uma nova linha temporal) \ne, talvez, instaurar o caos universal para jogar num cassino michuruca. \nContinue assim. \n" + RESET);
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
			System.out.print(CYAN + "Apelido do usuário: " + RESET);
			nomeDigitado = in.nextLine();
			System.out.print(CYAN + "Senha da conta: " + RESET);
			senhaDigitada = in.nextLine();
			System.out.println("======================================");
			
			if ((!senhaConta.equals(senhaDigitada) || !apelido.equals(nomeDigitado)) && tentativasRestantesLogin > 0) {
				tentativasLogin = tentativasLogin + 1;
				tentativasRestantesLogin = (MAX_TENTATIVAS - tentativasLogin) + 1;
				System.out.println("===========================================");
				System.out.println(RED + "Usuário e/ou senha incorretos. Tentativas restantes: " + tentativasRestantesLogin + RESET);
				System.out.println("===========================================");
				tentativasRestantesLogin = (MAX_TENTATIVAS - tentativasLogin) + 1;
			} else if (senhaConta.equals(senhaDigitada) && nome.equals(nomeDigitado) && tentativasRestantesLogin > 0)  {
				login = true;
				System.out.println(GREEN + "Log-in bem sucedido!" + RESET);
			} else if (tentativasLogin == MAX_TENTATIVAS) {
				System.out.println(RED + "Número máximo de tentativas excedido! Reinicie o sistema e tente novamente." + RESET);
				logindefinitivo = false;
			}
	} 
	
	//opcoes de saque e deposito do banco da bet
	public void sacarSaldo() {
		tentativas = 1;
		a = true;
		verificacao = false;
		while (cartaoBloqueado == false && a == true) {
		int tentativasRestantes = MAX_TENTATIVAS - tentativas;
		System.out.println("======================================");
		System.out.print ("Insira a quantidade que você deseja sacar do seu saldo de apostas: ");
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
			System.out.println(RED + "Não é possiível sacar uma quantia maior daquela possuída em conta." + RESET);
			a = false;
			System.out.println("===========================================");
		} else if (s <= this.valorDeposito && verificacao == true){
			this.saldo += s;
			this.valorDeposito -= s;
			System.out.println(GREEN + "Saque realizado com sucesso!" + RESET);
			a = false;
			System.out.println("===========================================");
		} else if (s <= this.valorDeposito && verificacao == false) {
			System.out.println(RED + "Senha do cartão incorreta. Tentativas restantes até o bloqueio do cartão: " + tentativasRestantes + RESET);
			System.out.println("===========================================");
			if (tentativasRestantes <= 0) {
				this.cartaoBloqueado = true;
				System.out.println(RED + "Cartão bloqueado. Desbloqueie e tente novamente mais tarde." + RESET);
				a = false;
				System.out.println("===========================================");
			}
		} else if (s > this.valorDeposito && verificacao == false) {
			System.out.println(RED + "Senha incorreta e quantidade inválida. Tentativas restantes: " + tentativasRestantes + RESET);
			System.out.println("===========================================");
		} else if(s <= 0 && verificacao == true) {
			System.out.println(RED + "Não é possível sacar essa quantia." + RESET);
			System.out.println("===========================================");
		} else if (s <= 0 && verificacao == false) {
			System.out.println(RED + "Quantidade inválida e senha do cartão incorreta." + RESET);
			System.out.println("===========================================");
		} else if (cartaoBloqueado == true) {
			System.out.println(RESET + "Cartão bloqueado. Tente novamente mais tarde." + RESET);
			System.out.println("===========================================");
		}
	} 	if (bloqueioDefinitivo == true || cartaoBloqueado == true) { 
		System.out.println("===========================================");
		System.out.println(RED + "Sistema indisponível." + RESET);
		System.out.println("==========================================="); }
		
}
	
 
	
	public void depositarSaldo() {
		tentativas = 1;
		a = true;
		verificacao = false;
		while (cartaoBloqueado == false && a == true) {
		int tentativasRestantes = MAX_TENTATIVAS - tentativas;
		System.out.println("======================================");
		System.out.print("Insira a quantidade que você deseja depositar para apostar: ");
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
			System.out.println(RED + "Não é possivel depositar uma quantia maior daquela possuida em conta." + RESET);
			a = false;
			System.out.println("===========================================");
		} else if (s <= this.saldo && verificacao == true){
			this.saldo -= s;
			this.valorDeposito += s;
			System.out.println(GREEN + "Depósito realizado com sucesso!" + RESET);
			a = false;
			System.out.println("===========================================");
		} else if (s <= this.saldo && verificacao == false) {
			System.out.println(RED + "Senha do cartão incorreta. Tentativas restantes até o bloqueio do cartão: " + tentativasRestantes + RESET);
			System.out.println("===========================================");
			if (tentativasRestantes <= 0) {
				this.cartaoBloqueado = true;
				System.out.println(RED + "Cartão bloqueado. Desbloqueie e tente novamente mais tarde." + RESET);
				a = false;
				
				System.out.println("===========================================");
			}
		} else if (s > this.saldo && verificacao == false) {
			System.out.println(RED + "Senha incorreta e quantidade inválida. Tentativas restantes: " + tentativasRestantes + RESET);
			System.out.println("===========================================");
		} else if(s <= 0 && verificacao == true) {
			System.out.println(RED + "Não é possivel depositar essa quantia." + RESET);
			System.out.println("===========================================");
		} else if (s <= 0 && verificacao == false) {
			System.out.println(RED + "Quantidade inválida e senha do cartão incorreta." + RESET);
			System.out.println("===========================================");
		}  else if (cartaoBloqueado == true) {
			System.out.println(RED + "Cartão bloqueado. Tente novamente mais tarde." + RESET);
			System.out.println("===========================================");
		}
	}	if (bloqueioDefinitivo == true || cartaoBloqueado == true) { 
		System.out.println("===========================================");
		System.out.println(RED + "Sistema indisponível." + RESET);
		System.out.println("==========================================="); }
}
	
	
	//getters e setters
	public double getSaldo() {
		return this.saldo;
		}
	
	public double getSaldoAposta( ) {
		return this.valorDeposito;
		}
	
	public void setNome(String n) {
		this.nome = n;
		}
	
	public void setCEP(String c) {
		this.cep = c;
		}
	
	public void setLogradouro(String l) {
		this.logradouro = l;
		}
	
	public void setSenhaConta(String s) {
		this.senhaConta = s;
		}
	
	public void setCPF(String c) {
		this.cpf = c;
		}
	
	public String getApelido() {
		return apelido;
		}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
		}

	public boolean getSenhaSecretaUsada() {
	    return senhaSecretaUsada;
		}
	
	public void setSenhaSecretaUsada(boolean usada) {
	    this.senhaSecretaUsada = usada;
		}

	public void setEMAIL(String e) {
		this.email = e;
		}
	
	public void setTelefone(String t) {
		this.telefone = t;
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
		b = true;
		while ((bloqueioDefinitivo == false && b == true) && cartaoBloqueado == true) {
		System.out.println("======================================");
		System.out.print("Para desbloquear seu cartao, insira a senha da sua conta a seguir: ");
		String senhaContaDigitada = in.nextLine();
		System.out.println("======================================");
			if (senhaContaDigitada.equals(senhaConta)) {
				System.out.println("======================================");
				System.out.println(GREEN + "Cartão desbloqueado com sucesso!" + RESET);
				System.out.println("======================================");
				b = false;
				cartaoBloqueado = false;
			} else {
				System.out.println("======================================");
				System.out.println(RED + "Cartão bloqueado definitivamente. Reinicie o sistema." + RESET);
				System.out.println("======================================");
				bloqueioDefinitivo = true;
				cartaoBloqueado = true;
			} 
		} 
		if (cartaoBloqueado == false) { System.out.println("======================================");
		System.out.println(GREEN + "Cartão já desbloqueado." + RESET);
		System.out.println("======================================");
		}
	}
	
	//hora da aposta
	public void aposta() {
		System.out.println("Quanto você deseja apostar?");
		valorAposta = in.nextDouble();
		if (valorAposta <= this.valorDeposito) {
			valorDeposito -= valorAposta;
			System.out.println("======================================");
			System.out.println(YELLOW + BOLD + "Você apostou " + valorAposta + " reais." + RESET);
			System.out.println("======================================");
			System.out.printf(YELLOW + BOLD + "Saldo de apostas atual: R$%.2f\n"  + RESET, valorDeposito);
			System.out.println("======================================");
		} else if (valorAposta <= 0) {
			System.out.println("======================================");
			System.out.println(RED + "Aposta inválida." + RESET);
			System.out.println("======================================");
		}
	}
	
	
	//multiplicadores de saldo
	
	public void multiplicador(double a) {
		double resultado = this.valorAposta * a;
		this.valorDeposito = this.valorDeposito + resultado;
		if (resultado != 0) {
			System.out.println("======================================");
			System.out.printf(GREEN + "Parabéns, você venceu! Saldo de apostas atual: R$%.2f\n" + RESET, valorDeposito);
			System.out.println("======================================");
		} else {
			System.out.println("======================================");
			System.out.printf(RED + "Infelizmente, você perdeu. :c Na próxima você consegue! Saldo de apostas atual: R$%.2f\n"  + RESET, valorDeposito);
			System.out.println("======================================");
		}
	}
	//gastar na loja 
		public boolean gastar(double gasto) {
			if (gasto <= this.valorDeposito) {
				this.valorDeposito -= gasto;
				return true;
			} else {
				return false;
			}
		}
		
		public void especiais(String s) {
			if (s.equals("Ralsei") && ralsei == false) {
				System.out.println("======================================");
				System.out.println(GREEN + "Você descobriu um dos códigos secretos! 3000 reais foram adicionados ao seu saldo." + RESET);
				ralsei = true;
				System.out.println("======================================");
				this.saldo += 3000;
			} else if (s.equals("Felipe") && felipe == false) {
				System.out.println("======================================");
				System.out.println(GREEN + "Você descobriu um dos códigos secretos! 3000 reais foram adicionados ao seu saldo." + RESET);
				felipe = true;
				System.out.println("======================================");
				this.saldo += 3000;
			} else if (s.equals("Isaías") && isaias == false) {
				System.out.println("======================================");
				System.out.println(GREEN + "Você descobriu um dos códigos secretos! 3000 reais foram adicionados ao seu saldo." + RESET);
				isaias = true;
				System.out.println("======================================");
				this.saldo += 3000;
			} else if (s.equals("Eduardo") && eduardo == false) {
				System.out.println("======================================");
				System.out.println(GREEN + "Você descobriu um dos códigos secretos! 3000 reais foram adicionados ao seu saldo." + RESET);
				eduardo = true;
				System.out.println("======================================");
				this.saldo += 3000;
			} else {
				System.out.println("======================================");
				System.out.println(RED + "Código inválido. :(" + RESET);
				System.out.println("======================================");
			}
		}
		
		public void depositarBonus(double valor) {
		    this.saldo += valor;
		}

}
