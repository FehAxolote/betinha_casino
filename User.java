package betinha_casino;
import java.util.Scanner;

public class User {
	//scanner
	Scanner in = new Scanner(System.in);
	
	///var
	private int saldo = 5000;
	private String nome;
	private String senhaConta;
	private String senhaCartao;
	boolean verificacao = false;
	final int MAX_TENTATIVAS = 3;
	int tentativas = 0;
	int tentativasLogin = 1;
	int tentativasRestantes = MAX_TENTATIVAS - tentativas;
	boolean cartaoBloqueado = false;
	int valorDeposito = 0;
	boolean login = false;
	private String senhaDigitada;
	private String nomeDigitado;
	boolean bloqueioDefinitivo = false;
	boolean logindefinitivo = true;
	
	//identidade
	public void identidade() {
		System.out.println("======================================");
		System.out.println("Bem-vindo ao sistema vital da Betinha!");
		System.out.println("Alem do nosso cassino e bet, voce encontrara um sistema bancario, um cartao e uma loja na qual voce podera gastar seu dinheiro!!!");
		System.out.println("======================================");
		System.out.println("Para usufruir desse sistema genial, insira seus dados nos campos a seguir.");
		System.out.println("======================================");
		System.out.print("Nome do usuario: ");
		this.nome = in.nextLine();
		System.out.print("Senha da conta: ");
		this.senhaConta = in.nextLine();
		System.out.print("Senha do cartao: ");
		this.senhaCartao = in.nextLine();
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
		verificacao = false;
		while (cartaoBloqueado == false) {
		System.out.println("Insira a quantidade que voce deseja sacar:");
		int s = in.nextInt();
		System.out.println("===========================================");
		System.out.println("Confirme sua senha (senha do cartao):");
		String senhaCartaoDigitada = in.nextLine();
		System.out.println("===========================================");
		
		if (senhaCartaoDigitada.equals(senhaCartao)) {
			verificacao = true;
		} else {
			verificacao = false;
			this.tentativas += 1;
		}	
		
		if(s > this.valorDeposito && verificacao == true) {
			System.out.println("Nao e possivel sacar uma quantia maior daquela possuida em conta.");
			System.out.println("===========================================");
		} else if (s <= this.valorDeposito && verificacao == true){
			this.saldo += s;
			this.valorDeposito -= s;
			System.out.println("Deposito realizado com sucesso!");
			System.out.println("===========================================");
		} else if (s <= this.valorDeposito && verificacao == false) {
			System.out.println("Senha do cartao incorreta. Tentativas restantes ate o bloqueio do cartao: " + tentativasRestantes);
			System.out.println("===========================================");
			if (tentativasRestantes <= 0) {
				this.cartaoBloqueado = true;
				System.out.println("Cartao bloqueado. Desbloqueie e tente novamente mais tarde.");
				System.out.println("===========================================");
			}
		} else if (s > this.valorDeposito && verificacao == false) {
			System.out.println("Senha incorreta e quantidade invalida. Tentativas restantes: " +tentativasRestantes);
			System.out.println("===========================================");
		} else if(s <= 0 && verificacao == true) {
			System.out.println("Nao e possivel sacar essa quantia.");
			System.out.println("===========================================");
		} else if (s <= 0 && verificacao == false) {
			System.out.println("Quantidade invalida e senha do cartao incorreta.");
			System.out.println("===========================================");
		} 
	} System.out.println("Cartao bloqueado. Tente novamente mais tarde.");
	System.out.println("===========================================");
		
}
 
	
	public void depositarSaldo() {
		verificacao = false;
		while (cartaoBloqueado == false) {
		System.out.println("Insira a quantidade que voce deseja sacar:");
		int s = in.nextInt();
		System.out.println("===========================================");
		System.out.println("Confirme sua senha (senha do cartao):");
		String senhaCartaoDigitada = in.nextLine();
		System.out.println("===========================================");
		
		if (senhaCartaoDigitada.equals(senhaCartao)) {
			verificacao = true;
		} else {
			verificacao = false;
			this.tentativas += 1;
		}	
		
		if(s > this.saldo && verificacao == true) {
			System.out.println("Nao e possivel depositar uma quantia maior daquela possuida em conta.");
			System.out.println("===========================================");
		} else if (s <= this.saldo && verificacao == true){
			this.saldo -= s;
			this.valorDeposito += s;
			System.out.println("Deposito realizado com sucesso!");
			System.out.println("===========================================");
		} else if (s <= this.saldo && verificacao == false) {
			System.out.println("Senha do cartao incorreta. Tentativas restantes ate o bloqueio do cartao: " + tentativasRestantes);
			System.out.println("===========================================");
			if (tentativasRestantes <= 0) {
				this.cartaoBloqueado = true;
				System.out.println("Cartao bloqueado. Desbloqueie e tente novamente mais tarde.");
				System.out.println("===========================================");
			}
		} else if (s > this.saldo && verificacao == false) {
			System.out.println("Senha incorreta e quantidade invalida. Tentativas restantes: " +tentativasRestantes);
			System.out.println("===========================================");
		} else if(s <= 0 && verificacao == true) {
			System.out.println("Nao e possivel depositar essa quantia.");
			System.out.println("===========================================");
		} else if (s <= 0 && verificacao == false) {
			System.out.println("Quantidade invalida e senha do cartao incorreta.");
			System.out.println("===========================================");
		} 
	} System.out.println("Cartao bloqueado. Tente novamente mais tarde.");
	System.out.println("===========================================");
		
	}
	
	
	//getters e setters
	public int getSaldo() {
		return this.saldo;
		}
	
	public void setNome(String n) {
		this.nome = n;
		}
	
	public String getNome() {
		return this.nome;
		}
	
	public void setSenhaConta(String s) {
		this.senhaConta = s;
		}
	
	public String getSenhaConta() {
		return this.senhaConta;
		}
	
	public void setSenhaCartao(String s) {
		this.senhaCartao = s;
		}
	
	public String getSenhaCartao() {
		return this.senhaCartao;
		}
	
	//desbloquear cartao
	public void desbloquearCartao() {
		while (bloqueioDefinitivo == false) {
		System.out.println("======================================");
		System.out.print("Para desbloquear seu cartao, insira a senha da sua conta a seguir:");
		String senhaContaDigitada = in.nextLine();
		System.out.println("======================================");
			if (senhaContaDigitada.equals(senhaConta)) {
				System.out.println("======================================");
				System.out.println("Cartao desbloqueado com sucesso!");
				System.out.println("======================================");
			} else {
				System.out.println("======================================");
				System.out.println("Cartao bloqueado definitivamente. Reinicie o sistema.");
				System.out.println("======================================");
				bloqueioDefinitivo = true;
			} 
		} System.out.println("Cartao bloqueado definitivamente. Reinicie o sistema.");
		System.out.println("======================================");
	}
	
	//multiplicadores de saldo
	
	
	

}

