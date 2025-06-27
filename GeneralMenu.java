package br.betinha.sys;
import java.util.Scanner;

public class GeneralMenu {
	public static void main(String[] args) {
	//importando classes
		User user = new User();
		BettingGame bg = new BettingGame();
		Bet beta = new Bet();
		LojinhaBetinha lj = new LojinhaBetinha();
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
			System.out.println("=========================================");
			System.out.println("Bem-vindo ao MENU da BETINHA!");
			System.out.println("1 - Verificar banco;");
			System.out.println("2 - Cassino e bet;");
			System.out.println("3 - Loja da BETINHA.");
			System.out.println("4 - Info;");
			System.out.println("5 - Sair.");
			String entrada1 = in.nextLine(); 
			selecao1 = Integer.parseInt(entrada1);	
			switch (selecao1) {
				case 1:
					while (b) {
						System.out.println("Selecione uma das opções a seguir:");
						System.out.println("===========================================");
						System.out.println("Bem-vindo ao MENU da BankTinha!");
						System.out.println("1 - Sacar;");
						System.out.println("2 - Depositar;");
						System.out.println("3 - Verificar saldo;");
						System.out.println("4 - Desbloquear cartao;");
						System.out.println("5 - Sair.");
						String entrada2 = in.nextLine(); 
						selecao2 = Integer.parseInt(entrada2);					
						switch(selecao2) {
						case 1:
							user.sacarSaldo();
							break;
						case 2: 
							user.depositarSaldo();
							break;
						case 3: 
							System.out.println("===========================================");
							System.out.println("Seu saldo é: R$" + user.getSaldo() + ".");
							System.out.println("Seu saldo de apostas é: R$" + user.getSaldoAposta() + ".");
							System.out.println("===========================================");
							break;
						case 4: 
							user.desbloquearCartao();
							break;
						case 5:
							b = false;
							break;
						default:
							System.out.println("Opção inválida!");
						}
			}	
					break;
				case 2:
					while (c) {
						System.out.println("===========================================");
						System.out.println("Selecione uma das opções a seguir:");
						System.out.println("===========================================");
						System.out.println("Bem-vindo ao MENU da Betinha Cassino. Jogue com responsabilidade e se divirta!");
						System.out.println("1 - BET;");
						System.out.println("2 - Adivinhe o número;");
						System.out.println("3 - Jogo Especial;");
						System.out.println("4 - Sair.");
						String entrada3 = in.nextLine(); 
						selecao3 = Integer.parseInt(entrada3);
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
							System.out.println("Opção inválida!");
						}
			}	
					break;
					
				case 3:
					while (d) {
						cad = true;
						System.out.println("===========================================");
						System.out.println("Selecione uma das opções a seguir:");
						System.out.println("===========================================");
						System.out.println("Bem-vindo ao MENU da Loja da Betinha");
						System.out.println("1 - Comprar produtos;");
						System.out.println("2 - Recadastrar dados;");
						System.out.println("3 - Resgatar códigos;");
						System.out.println("4 - Sair.");
						String entrada4 = in.nextLine(); 
						selecao4 = Integer.parseInt(entrada4);
						switch(selecao4) {
						case 1:
							while (loja) {
								System.out.println("===========================================");
								lj.mostrarPremios();
								System.out.println("===========================================");
								System.out.println("Digite o número do item que deseja resgatar, ou digite -1 para voltar ao menu anterior.");
								
								int item = in.nextInt();
								in.nextLine();

								if (item == -1) {
									System.out.println("Retornando ao menu principal da Loja da Betinha...");
									break; 
								}

								boolean sucesso = lj.resgatarPremio(user, item);

								if (!sucesso) {
									System.out.println("Deseja tentar novamente? (s/n)");
									String resposta = in.nextLine().trim().toLowerCase();
									if (!resposta.equals("s")) {
										System.out.println("Retornando ao menu da loja...");
										break;
									}
								}
							}
							break;
						case 2: 
							while(cad) {
							String[] display = {"Nome: ", "CPF: ", "E-mail: ", "Telefone: ", "CEP: ", "Logradouro: ", "Senha da conta: ", "Senha do cartão: "};
							String[] informacoesCadastrais = {user.getNome(), user.getCPF(), user.getEMAIL(), user.getTelefone(), user.getCEP(), user.getLogradouro(), "****", "****"};
							System.out.println("===========================================");
							for (int i = 0; i < display.length; i++) {
								System.out.printf("%d - %s%s\n", (i + 1), display[i], informacoesCadastrais[i]);
							}
								System.out.println("9 - Sair.");
								System.out.println("===========================================");
								System.out.println("Escolha um dos itens para ser alterado.");
								cadastro = in.nextInt();
								in.nextLine();
								switch(cadastro) {
								case 1: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o nome cadastrado? (True para sim, false para não)");
									boolean decisaon = in.nextBoolean();
									in.nextLine();
									if (decisaon == true) {
										System.out.println("===========================================");
										System.out.println("Para qual nome gostaria de alterar?");
										String s = in.nextLine();
										user.setNome(s);
										System.out.println("===========================================");
										System.out.println("Nome alterado com sucesso!");
									} else { System.out.println("===========================================");
									System.out.println("Retornando ao menu principal..."); 
									}
									break;
								case 2:
									System.out.println("===========================================");
									System.out.println("Não é possível alterar o CPF.");
									break;
								case 3: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o e-mail cadastrado? (True para sim, false para não)");
									boolean decisaoe = in.nextBoolean();
									in.nextLine();
									if (decisaoe == true) {
										System.out.println("===========================================");
										System.out.println("Para qual nome gostaria de alterar?");
										String em = in.nextLine();
										user.setEMAIL(em);
										System.out.println("===========================================");
										System.out.println("E-mail alterado com sucesso!");
									} else { System.out.println("===========================================");
									System.out.println("Retornando ao menu principal...");
									}
									break;
								case 4: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o telefone cadastrado? (True para sim, false para não)");
									boolean decisaot = in.nextBoolean();
									in.nextLine();
									if (decisaot == true) {
										System.out.println("===========================================");
										System.out.println("Para qual telefone gostaria de alterar?");
										String t = in.nextLine();
										user.setTelefone(entrada1);
										System.out.println("===========================================");
										System.out.println("Telefone alterado com sucesso!");
									} else { System.out.println("===========================================");
									System.out.println("Retornando ao menu principal...");
									}
									break;
								case 5:
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o CEP cadastrado? (True para sim, false para não)");
									boolean decisaoc = in.nextBoolean();
									in.nextLine();
									if (decisaoc == true) {
										System.out.println("===========================================");
										System.out.println("Para qual CEP gostaria de alterar?");
										String cep = in.nextLine();
										user.setCEP(cep);
										System.out.println("===========================================");
										System.out.println("CEP alterado com sucesso!");
									} else { System.out.println("===========================================");
									System.out.println("Retornando ao menu principal...");
									}
									break;
								case 6: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar o logradouro cadastrado? (True para sim, false para não)");
									boolean decisaol = in.nextBoolean();
									in.nextLine();
									if (decisaol == true) {
										System.out.println("===========================================");
										System.out.println("Para qual logradouro gostaria de alterar?");
										String l = in.nextLine();
										user.setLogradouro(l);
										System.out.println("===========================================");
										System.out.println("Logradouro alterado com sucesso!");
									} else { System.out.println("===========================================");
									System.out.println("Retornando ao menu principal...");
									}
									break;
								case 7: 
									System.out.println("===========================================");
									System.out.println("Você deseja alterar a senha da conta cadastrada? (True para sim, false para não)");
									boolean decisaosc = in.nextBoolean();
									in.nextLine();
									if (decisaosc == true) {
										System.out.println("===========================================");
										System.out.println("Para qual senha gostaria de alterar?");
										String sc = in.nextLine();
										user.setSenhaConta(sc);
										System.out.println("===========================================");
										System.out.println("Senha alterada com sucesso!");
									} else { System.out.println("===========================================");
									System.out.println("Retornando ao menu principal...");
									}
									break;
								case 8:
									System.out.println("===========================================");
									System.out.println("Não é possível alterar a senha do cartão.");
									break;
								case 9: 
									loja = false;
									break;
							}
						}
							break;
						case 3: 
							System.out.println("===========================================");
							System.out.println("Digite o código no campo abaixo:");
							String especial = in.nextLine();
							user.especiais(especial);
							break;
						case 4:
							d = false;
							break;
						default:
							System.out.println("Opção inválida!");
						}
			}	
					break;
					
				case 4:
					while (e) {
						System.out.println("Selecione uma das opções a seguir:");
						System.out.println("===========================================");
						System.out.println("Sobre qual tópico você gostaria de algum esclarecimento?");
						System.out.println("1 - Sobre BANCOs;");
						System.out.println("2 - Sobre JOGOs;");
						System.out.println("3 - Sobre LOJAs;");
						System.out.println("4 - Sobre EDSONs.");
						System.out.println("5 - Sair.");
						String entrada5 = in.nextLine(); 
						selecao5 = Integer.parseInt(entrada5);
						switch(selecao5) {
						case 1:
							System.out.println("======================================");
							System.out.print("Depende do banco. \nSe for sobre Banco do Brasil, Itaú, Bradesco... acho que não tem como ajudar. \nSe for sobre assento, acho que serve para sentar. \nSe for sobre a BankTinha... ");
							System.out.print("Todo usuário recebe, gratuitamente, um CARTÃO e um SALDO de 5000 reais para começar a apostar. \nVocê pode depositá-lo integral ou parcialmente, transformando-o em SALDO DE APOSTAS - utilizado na LOJINHA e nos JOGOS, nos quais ele poderá ser multiplicado e, talvez, sacado, através da opção da SAQUE. \n======================================  \nLembre-se da SENHA DO CARTÃO. \n A BankTinha a solicitará toda vez que for sacar ou depositar, e caso haja três erros, seu cartão será BLOQUEADO TEMPORARIAMENTE \n Para desbloqueá-lo, vá à seção DESBLOQUEAR CARTÃO da BankTinha e insira sua SENHA DA CONTA para desbloqueá-lo. \n Se a senha for inserida incorretamente, seu cartão será BLOQUEADO ETERNAMENTE, e você não poderá mais utilizar a betinha. \n Ao cartão só lhe restará o churrascamento. \nE ao beta (o que inclui este que os escreve este texto)), nada. \n");
							System.out.println("======================================");
							break;
						case 2: 
							System.out.println("======================================");
							System.out.println("Nosso sistema possui três jogos sinistros (que podem ser jogados apenas uma vez, em cada opção):");
							System.out.print("1 - A clássica BET, na qual você seleciona um dos jogos de hoje (de qualquer liga, de qualquer esporte) \n====================================== \n2 - O jogo de adivinhação numérica, em que um número é ramdomizado e você deve acertá-lo (ou, ao menos, aproximar-se dele, excetuando-se em 'Adivinhação fácil') em um certo número de tentativas. \nCaso o palpite seja exato, um bônus magnifico é somado ao multiplicador numérico que seu SALDO DE APOSTAS obterá quando próximo do número sorteado. \nSe não tiver conseguido se aproximar nem acertar exatamente, todo o saldo apostado é perdido. \n====================================== \n 3 - A aposta especial, na qual você não deposita dinheiro, mas pode ganhar uma quantia significativa ao acertar a senha secreta. \n ");
							System.out.println("======================================");
							break;
						case 3: 
							System.out.println("======================================");
							System.out.println("Valendo-se de seu SALDO DE APOSTAS, você pode ~~(desperdiçar)~~ gastar seu dinheiro com itens (in)úteis!!!");
							System.out.print("Garanta que seu SALDO DE APOSTAS seja diferente de zero. \n5000 reais são disponíveis gratuitamente a todos os usuários, e você pode depositá-los (completa ou parcialmente) no seu SALDO DE APOSTAS através da opção 'depositar' no menu da BankTinha. \n");
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
							System.out.println("Opção inválida!");
						}
			}	
					break;
				case 5:
					return;
				default:
					System.out.println("Opção inválida!");
					
			
			
				}
			}
		}
	}
}

		}
	}
	}
}
	
