package br.betinha.sys;
import java.util.Scanner;

public class GeneralMenu {
	//ansi colours
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";
   
	
	public static void main(String[] args) {
	//importando classes
		User user = new User();
		BettingGame bg = new BettingGame();
		Bet beta = new Bet();
		BetinhaStore lj = new BetinhaStore();
		Scanner in = new Scanner(System.in);
		
	//var
		boolean a = true;
		boolean b = true;
		boolean c = true;
		boolean d = true;
		boolean e = true;
		boolean loja = true;
		boolean cad = true;
		int selecao1;
		int selecao2; 
		int selecao3;
		int selecao4;
		int selecao5;
		int cadastro;
		
	//iniciando o sistema 
		user.identidade();
		while (user.login == false && user.logindefinitivo == true) {
			user.login();
		}
		if(user.login == true && user.logindefinitivo == true) {
			while (a) {
			    b = true;
			    c = true;
			    d = true;
			    e = true;
			System.out.println("=".repeat(43));
			System.out.println(BOLD + "🎰 Bem-vindo ao MENU da Betinha 🎰!" + RESET);
			System.out.println("=".repeat(43));
			System.out.println(GREEN + "[1] (🏦) - Verificar banco;" + RESET);
			System.out.println(PURPLE + "[2] (🎲) - Cassino e BET;" + RESET);
			System.out.println(YELLOW + "[3] (🛒) - Loja da Betinha." + RESET);
			System.out.println(CYAN + "[4] (ℹ️) - INFO;" + RESET);
			System.out.println(RED + "[5] (❌) - Sair." + RESET);
			System.out.println(BLUE + BOLD + "=".repeat(43));
			System.out.println("Usuário: " + user.getApelido());
			System.out.println("=".repeat(43) + RESET);
			selecao1 = user.lerInteiroSM(in);	
			switch (selecao1) {
				case 1:
					while (b) {
						System.out.println(GREEN + "🏦".repeat(43) + RESET);
						System.out.println(GREEN + BOLD + "Selecione uma das opções a seguir:" + RESET);
						System.out.println(GREEN + "🏦".repeat(43) + RESET);
						System.out.println(GREEN + BOLD + "💎 Bem-vindo ao MENU da BankTinha 💎!" + RESET);
						System.out.println(GREEN + "[1] (🪙)- Sacar do SALDO DE APOSTAS;");
						System.out.println("[2] (💰) - Depositar no SALDO DE APOSTAS;");
						System.out.println("[3] (📊) - Verificar saldo;");
						System.out.println("[4] (🔓) - Desbloquear cartao;");
						System.out.println("[5] (🔚) - Sair." + RESET);
						System.out.println(BLUE + BOLD + "===========================================");
						System.out.println("Usuário: " + user.getApelido());
						System.out.println("===========================================" + RESET);
						selecao2 = user.lerInteiroSM(in);				
						switch(selecao2) {
						case 1:
							user.sacarSaldo();
							break;
						case 2: 
							user.depositarSaldo();
							break;
						case 3: 
							System.out.println("===========================================");
							System.out.printf(YELLOW + BOLD + "Seu saldo: R$%.2f\n"  + RESET, user.getSaldo());
							System.out.printf(YELLOW + BOLD + "Seu saldo de apostas: R$%.2f\n"  + RESET, user.getSaldoAposta());
							System.out.println("===========================================");
							break;
						case 4: 
							user.desbloquearCartao();
							break;
						case 5:
							b = false;
							break;
						default:
							System.out.println(RED + "Opção inválida!" + RESET);
							break;
						}
			}	
					break;
				case 2:
					while (c) {
						System.out.println(PURPLE + "🎲".repeat(43) + RESET);
						System.out.println(PURPLE + BOLD + "Selecione uma das opções a seguir:" + RESET);
						System.out.println(PURPLE + "🎲".repeat(43) + RESET);
						System.out.println(PURPLE + BOLD + "♣️ Bem-vindo ao MENU da Betinha Cassino. Jogue com responsabilidade e se divirta ♣️!" + RESET);
						System.out.println(PURPLE + "[1] (💸) - BET;");
						System.out.println("[2] (🔢) - Adivinhe o número;");
						System.out.println("[3] (🃏) - Jogo Especial;");
						System.out.println("[4] (🔚) - Sair." + RESET);
						System.out.println(BLUE + BOLD + "=".repeat(43));
						System.out.println("Usuário: " + user.getApelido());
						System.out.println("=".repeat(43) + RESET);
						selecao3 = user.lerInteiroSM(in);	
						switch(selecao3) {
						case 1:
							beta.bet(user);
							break;
						case 2: 
							bg.game(user);
							break;
						case 3: 
							IsaiasBet.jogar(user, in);
							break;
						case 4:
							c = false;
							break;
						default:
							System.out.println(RED + "Opção inválida!" + RESET);
							break;
						}
			}	
					break;
					
				case 3:
					while (d) {
						cad = true;
						System.out.println(YELLOW + "🛒".repeat(43) + RESET);
						System.out.println(YELLOW + BOLD + "Selecione uma das opções a seguir:" + RESET);
						System.out.println(YELLOW + "🛒".repeat(43) + RESET);
						System.out.println(YELLOW + BOLD + "📦 Bem-vindo ao MENU da Loja da Betinha 📦!" + RESET);
						System.out.println(YELLOW + "[1] (🛍️) - Comprar produtos;");
						System.out.println("[2] (✅) - Posses;");
						System.out.println("[3] (📝) - Recadastrar dados;");
						System.out.println("[4] (🎁) - Resgatar códigos;");
						System.out.println("[5] (🔚) - Sair." + RESET);
						System.out.println(BLUE + BOLD + "===========================================");
						System.out.println("Usuário: " + user.getApelido());
						System.out.println("===========================================" + RESET);
						selecao4 = user.lerInteiroSM(in);	
						switch(selecao4) {
						case 1:
							while (loja) {
								System.out.println("===========================================");
								lj.mostrarPremios(user);
								System.out.println("===========================================");
								System.out.println("Digite o número do item que deseja resgatar, ou digite -1 para voltar ao menu anterior.");
								
								int item = user.lerInteiroSM(in);

								if (item == -1) {
									System.out.println("Retornando ao menu principal da Loja da Betinha...");
									break; 
								}

								boolean sucesso = lj.resgatarPremio(user, item);

								if (!sucesso) {
									System.out.println("Deseja tentar novamente? (s/n)");
									String resposta = user.lerTextoSMLowerCase(in);
									if (!resposta.equals("s")) {
										System.out.println("Retornando ao menu da loja...");
										break;
									}
								}
							}
							break;
						case 2:
							lj.mostrarPosses();
							break;
						case 3: 
							while(cad) {
							String[] display = {"Nome: ", "Apelido: ", "CPF: ", "E-mail: ", "Telefone: ", "CEP: ", "Logradouro: ", "Senha da conta: ", "Senha do cartão: "};
							String[] informacoesCadastrais = {user.getNome(), user.getApelido(), user.getCPF(), user.getEMAIL(), user.getTelefone(), user.getCEP(), user.getLogradouro(), "****", "****"};
							System.out.println("===========================================");
							for (int i = 0; i < display.length; i++) {
								System.out.printf(CYAN + "%d - %s%s\n", (i + 1), display[i], informacoesCadastrais[i] + RESET);
							}
								System.out.println(CYAN + "10 - Sair." + RESET);
								System.out.println("===========================================");
								System.out.println("Escolha um dos itens para ser alterado.");
								cadastro = in.nextInt();
								in.nextLine();
								switch(cadastro) {
								case 1: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o nome cadastrado? (True para sim, false para não)");
									String decisaon = lerTextoSMLowerCase(in);
									if (decisaon.equals("s")) {
										System.out.println("===========================================");
										System.out.println("Para qual nome gostaria de alterar?");
										String s =  user.lerTextoSM(in);
										user.setNome(s);
										System.out.println("===========================================");
										System.out.println(GREEN + "Nome alterado com sucesso!" + RESET);
									} else { System.out.println("===========================================");
									System.out.println(CYAN + "Retornando ao menu principal..." + RESET); 
									}
									break;
								case 2: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o apelido cadastrado? (True para sim, false para não)");
									String decisaoa = lerTextoSMLowerCase(in);
									if (decisaoa.equals("s")) {
										System.out.println("===========================================");
										System.out.println("Para qual apelido gostaria de alterar?");
										String ap =  user.lerTextoSM(in);
										user.setApelido(ap);
										System.out.println("===========================================");
										System.out.println(GREEN + "Apelido alterado com sucesso!" + RESET);
									} else { System.out.println("===========================================");
									System.out.println(CYAN + "Retornando ao menu principal..." + RESET); 
									}
									break;
								case 3:
									System.out.println("===========================================");
									System.out.println(RED + "Não é possível alterar o CPF." + RESET);
									break;
								case 4: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o e-mail cadastrado? (True para sim, false para não)");
									String decisaoe = lerTextoSMLowerCase(in);
									if (decisaoe.equals("s")) {
										System.out.println("===========================================");
										System.out.println("Para qual e-mail gostaria de alterar?");
										String em = user.lerTextoSM(in);
										user.setEMAIL(em);
										System.out.println("===========================================");
										System.out.println(GREEN + "E-mail alterado com sucesso!" + RESET);
									} else { System.out.println("===========================================");
									System.out.println(CYAN + "Retornando ao menu principal..." + RESET);
									}
									break;
								case 5: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o telefone cadastrado? (True para sim, false para não)");
									String decisaot = lerTextoSMLowerCase(in);
									if (decisaot.equals("s")) {
										System.out.println("===========================================");
										System.out.println("Para qual telefone gostaria de alterar?");
										String t =  user.lerTextoSM(in);
										user.setTelefone(t);
										System.out.println("===========================================");
										System.out.println(GREEN + "Telefone alterado com sucesso!" + RESET);
									} else { System.out.println("===========================================");
									System.out.println(CYAN + "Retornando ao menu principal..." + RESET);
									}
									break;
								case 6:
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o CEP cadastrado? (True para sim, false para não)");
									String decisaoc = lerTextoSMLowerCase(in);
									if (decisaoc.equals("s")) {
										System.out.println("===========================================");
										System.out.println("Para qual CEP gostaria de alterar?");
										String cep =  user.lerTextoSM(in);
										user.setTelefone(cep);
										System.out.println("===========================================");
										System.out.println(GREEN + "CEP alterado com sucesso!" + RESET);
									} else { System.out.println("===========================================");
									System.out.println(CYAN + "Retornando ao menu principal..." + RESET);
									}
									break;
								case 7: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o logradouro cadastrado? (True para sim, false para não)");
									String decisaol = lerTextoSMLowerCase(in);
									if (decisaol.equals("s")) {
										System.out.println("===========================================");
										System.out.println("Para qual logradouro gostaria de alterar?");
										String l =  user.lerTextoSM(in);
										user.setLogradouro(l);
										System.out.println("===========================================");
										System.out.println(GRREN + "Logradouro alterado com sucesso!" + RESET);
									} else { System.out.println("===========================================");
									System.out.println(CYAN + "Retornando ao menu principal..." + RESET);
									}
									break;
								case 8: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar a senha da conta cadastrada? (True para sim, false para não)");
									String decisaosc = lerTextoSMLowerCase(in);
									if (decisaosc.equals("s")) {
										System.out.println("===========================================");
										System.out.println("Para qual senha gostaria de alterar?");
										String sc = user.lerTextoSM(in);
										user.setSenhaConta(sc);
										System.out.println("===========================================");
										System.out.println(GREEN + "Senha alterada com sucesso!" + RESET);
									} else { System.out.println("===========================================");
									System.out.println(CYAN + "Retornando ao menu principal..." + RESET);
									}
									break;
								case 9:
									System.out.println("===========================================");
									System.out.println(RED + "Não é possível alterar a senha do cartão." + RESET);
									break;
								case 10: 
									loja = false;
									break;
								default:
									System.out.println(RED + "Opção inválida!" + RESET);
									break;
							}
						}
							break;
						case 4: 
							System.out.println("===========================================");
							System.out.println("Digite o código no campo abaixo:");
							String especial = in.nextLine();
							user.especiais(especial);
							break;
						case 5:
							d = false;
							break;
						default:
							System.out.println(RED + "Opção inválida!" + RESET);
							break;
						}
			}	
					break;
					
				case 4:
					while (e) {
						System.out.println(CYAN + "ℹ️".repeat(43) + RESET);
						System.out.println(CYAN + BOLD + "Selecione uma das opções a seguir:" + RESET);
						System.out.println(CYAN + "ℹ️".repeat(43) + RESET);
						System.out.println(CYAN + BOLD +"🛈 Sobre qual tópico você gostaria de algum esclarecimento 🛈?" + RESET);
						System.out.println(GREEN + "[1] (🏦) - Sobre BANCOs;" + RESET);
						System.out.println(PURPLE + "[2] (🎲) - Sobre JOGOs;" + RESET);
						System.out.println(YELLOW + "[3] (🛒) - Sobre LOJAs;" + RESET);
						System.out.println(CYAN + "[4] (❓) - Sobre EDSONs." + RESET);
						System.out.println(RED + "[5] (🔚) - Sair." + RESET);
						System.out.println(BLUE + BOLD + "===========================================");
						System.out.println("Usuário: " + user.getApelido());
						System.out.println("===========================================" + RESET);
						selecao5 = user.lerInteiroSM(in);	
						switch(selecao5) {
						case 1:
							System.out.println("======================================");
							System.out.print("Depende do banco. \nSe for sobre Banco do Brasil, Itaú, Bradesco... acho que não tem como ajudar. \nSe for sobre assento, acho que serve para sentar. \nSe for sobre a BankTinha... ");
							System.out.print("Todo usuário recebe, gratuitamente, um CARTÃO e um SALDO de 5000 reais para começar a apostar. \nVocê pode depositá-lo integral ou parcialmente, transformando-o em SALDO DE APOSTAS - utilizado na LOJINHA e nos JOGOS, nos quais ele poderá ser multiplicado e, talvez, sacado, através da opção da SAQUE. \n======================================  \nLembre-se da SENHA DO CARTÃO. \nA BankTinha a solicitará toda vez que for sacar ou depositar, e caso haja três erros, seu cartão será BLOQUEADO TEMPORARIAMENTE \nPara desbloqueá-lo, vá à seção DESBLOQUEAR CARTÃO da BankTinha e insira sua SENHA DA CONTA para desbloqueá-lo. \nSe a senha for inserida incorretamente, seu cartão será BLOQUEADO ETERNAMENTE, e você não poderá mais utilizar a betinha. \nAo cartão só lhe restará o churrascamento. \nE ao beta (o que inclui este que os escreve este texto), nada. \n");
							System.out.println("======================================");
							break;
						case 2: 
							System.out.println("======================================");
							System.out.println("Nosso sistema possui três jogos sinistros (que podem ser jogados apenas uma vez, em cada opção):");
							System.out.print("1 - A clássica BET, na qual você seleciona um dos jogos de hoje (de qualquer liga, de qualquer esporte) \n====================================== \n2 - O jogo de adivinhação numérica, em que um número é ramdomizado e você deve acertá-lo (ou, ao menos, aproximar-se dele, excetuando-se em 'Adivinhação fácil') em um certo número de tentativas. \nCaso o palpite seja exato, o multiplicador máximo é concedido ao seu SALDO DE APOSTAS. \nQuanto mais distante o palpite for do número sorteado, menor o multipicador. \nSe não tiver conseguido se aproximar nem acertar exatamente, todo o saldo apostado é perdido. \n====================================== \n3 - A aposta especial, na qual você não deposita dinheiro, mas pode ganhar uma quantia significativa ao acertar a senha secreta. \n");
							System.out.println("======================================");
							break;
						case 3: 
							System.out.println("======================================");
							System.out.println("Valendo-se de seu SALDO DE APOSTAS, você pode ~~(desperdiçar)~~ gastar seu dinheiro com itens (in)úteis!!!");
							System.out.print("Garanta que seu SALDO DE APOSTAS seja diferente de zero. \n5000 reais são disponíveis gratuitamente a todos os usuários, e você pode depositá-los (completa ou parcialmente) no seu SALDO DE APOSTAS através da opção 'depositar' no menu da BankTinha. \n");
							System.out.print("Além disso, você pode, através da loja, verificar as posses adquiridas na loja, alterar suas informações de cadastro e resgatar códigos, os quais podem lhe conceder alguma bonificação ;) \n");
							System.out.println("======================================");
							break;
						case 4:
							System.out.println("======================================");
							System.out.println("Quem é Edson?");
							System.out.println("======================================");
							break;
						case 5: 
							e = false;
							break;
						default: 
							System.out.println(RED + "Opção inválida!" + RESET);
							break;
						}
			}	
					break;
				case 5:
					a = false;
					break;
				default:
					System.out.println(RED + "Opção inválida!" + RESET);
					break;
					
			
			
				}
			} 
		} System.out.println(RED + "=".repeat(43));
		System.out.println("Sistema encerrado!");
		System.out.println("=".repeat(43) + RESET);
	}
}
