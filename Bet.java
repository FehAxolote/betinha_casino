package br.betinha.sys;
import java.util.Random;
import java.util.Scanner;

public class Bet {
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";
	public void bet(User user) {
		//validação de jogos
		boolean validacaoTM = true;
		boolean validacaoCF = true;
		boolean validacaoBR = true;
		boolean validacaoPP = true;
		
		//var
		boolean a = true;
		int selecao;
		
		//conexões interclasse
		Scanner in = new Scanner(System.in);
		Random random = new Random();
		
		//randoms para as probabilidades
		int tmA = random.nextInt(991) + 10;
		double porcentagemTMA = tmA/10;
		int cfA = random.nextInt(991) + 10;
		double porcentagemCFA = cfA/10;
		int brA = random.nextInt(991) + 1;
		double porcentagemBRA = brA/10;
		int ppA = random.nextInt(991) + 1;
		double porcentagemPPA = ppA/10;
		
		//randoms da aposta
		int tm = random.nextInt(991) + 10;
		double porcentagemTM = tm/10;
		int cf = random.nextInt(991) + 10;
		double porcentagemCF = cf/10;
		int br = random.nextInt(991) + 1;
		double porcentagemBR = br/10;
		int pp = random.nextInt(991) + 1;
		double porcentagemPP = pp/10;
		
		
		//escolha
		String escolha;
		String resultado;
		
		while (a) {
		System.out.println("Bem-vindo à BET da Betinha! Aposte em jogos reais ~~ou talvez não~~ e multiplique seu dinheiro!");
		System.out.println("-===MENU===-");
		System.out.println("1 - Oitavas do Mundial de Tênis de Mesa 2025 - Xique-Xique (BA);");
		System.out.println("2 - Quartas da Copa de Fortinaite dos Ícones 2025 - Varre-Sai (RJ);");
		System.out.println("3 - Semi-Final do Bobrasileirão 2025 - Ressaquinha (MG);");
		System.out.println("4 - Final da Copa do Mundo de Pega-Pega 2025 - Anta Gorda (RS);");
		System.out.println("5 - Sair.");
		System.out.println("=========================================");
		System.out.printf(YELLOW + BOLD + "Saldo de apostas atual: R$%.2f\n" + RESET, user.getSaldoAposta());
		System.out.println("=========================================");
		selecao = user.lerInteiroSM(in);
		if ((selecao >= 1 && selecao <= 4) || selecao != 5) {
			a = true;
		} else {
			a = false;
		} 
			switch (selecao) {
			case 1:
				if (validacaoTM == true) {
				double oddATM = 100.0 / porcentagemTMA;
				double oddBTM = 100.0 / (100.0 - porcentagemTMA);
				System.out.println("=========================================");
				System.out.println("OITAVAS DE FINAL (28/06/2025, 9:00 (GMT-3)): Mundial Tênis de Mesa 2025 - Xique-Xique (BA):");
				System.out.println("=========================================");
				System.out.println("Em quem você aposta? (Porcentagens de vitória entre parênteses.)");
				System.out.println("===========================================");
			    System.out.printf(GREEN + "A - 🇧🇷Pedro Álvares Cabral (%.1f%%) -> ODD = %.3fx\n" + RESET, porcentagemTMA, oddATM);
			    System.out.printf(RED + "B - 🇨🇳Mao Tsé-Tung (%.1f%%) -> ODD = %.3fx\n" + RESET, (100 - porcentagemTMA), oddBTM);
				System.out.println("===========================================");
				escolha = user.lerTextoSMUpperCase(in);
				user.aposta();
				
				if (user.confirmacaoAposta == true && user.confirmacaoValor == true) {
				//sistema porcentagem
				if (porcentagemTM >=0 && porcentagemTM <= porcentagemTMA) {
					resultado = "A";
				     System.out.println("===========================================");
				        System.out.println(GREEN + "Pedro Álvares Cabral utilizou uma raquete de pau-brasil e venceu. 🥇" + RESET);
				        System.out.println("===========================================");
				} else {
					resultado = "B";
				     System.out.println("===========================================");
				        System.out.println(RED + "Mao Tsé-Tung iniciou uma revolução socialista no meio da partida e venceu. ☭" + RESET);
				        System.out.println("===========================================");
				}
				
			    double multiplicadorTM;
			    if (resultado.equals("A")) {
			        multiplicadorTM = oddATM;
			    } else {
			        multiplicadorTM = oddBTM;
			    }

				if (escolha.equals(resultado)) {
					validacaoTM = false;
					user.multiplicador(multiplicadorTM);
				} else {
					validacaoTM = false;
					user.multiplicador(0);
				}
				}
				} else {
					System.out.println("===========================================");
					System.out.println(RED + "Você já jogou este jogo hoje. Tente novamente mais tarde! ;)" + RESET);
					System.out.println("===========================================");
				}
				break;
			case 2:
				if (validacaoCF) {
				double oddACF = 100.0 / porcentagemCFA;
				double oddBCF = 100.0 / (100.0 - porcentagemCFA);
				System.out.println("=========================================");
				System.out.println("QUARTAS DE FINAL (28/06/2025, 12:00 (GMT-3)): Copa de Fortinaite dos Ícones 2025 - Varre-Sai (RJ):");
				System.out.println("=========================================");
				System.out.println("Em quem você aposta? (Porcentagens de vitória entre parênteses.)");
				System.out.println("===========================================");
			    System.out.printf(PURPLE + "A - 🇿🇦Nelson Mandela (%.1f%%) -> ODD = %.3fx\n" + RESET, porcentagemCFA, oddACF);
			    System.out.printf(YELLOW + "B - 🇵🇱Marie Curie (%.1f%%) -> ODD = %.3fx\n" + RESET, (100 - porcentagemCFA), oddBCF);
				System.out.println("===========================================");
				escolha = user.lerTextoSMUpperCase(in);
				user.aposta();
				
				if (user.confirmacaoAposta == true && user.confirmacaoValor == true) {
				//sistema porcentagem
				if (porcentagemCFA >=0 && porcentagemCF <= porcentagemCFA) {
					resultado = "A";
				} else {
					resultado = "B";
				}
				
			    double multiplicadorCF;
			    if (resultado.equals("A")) {
			        multiplicadorCF = oddACF;
			        System.out.println("===========================================");
			        System.out.println(PURPLE + "Nelson Mandela deu capa em metade do server e venceu! Talvez com o efeito Mandela... 🥇" + RESET);
			        System.out.println("===========================================");
			    } else {
			        multiplicadorCF = oddBCF;
			        System.out.println("===========================================");
			        System.out.println(YELLOW + "Marie Curie utilizou o poder da radiação e ganhou! ☢️" + RESET);
			        System.out.println("===========================================");
			    }

				if (escolha.equals(resultado)) {
					validacaoCF = false;
					user.multiplicador(multiplicadorCF);
				} else {
					validacaoCF = false;
					user.multiplicador(0);
				}
				}
				} else {
					System.out.println("===========================================");
					System.out.println(RED + "Você já jogou este jogo hoje. Tente novamente mais tarde! ;)" + RESET);
					System.out.println("===========================================");
				}
				break;
				
			case 3: 
				if (validacaoBR) {
				double oddABR = 100.0 / porcentagemBRA;
				double oddBBR = 100.0 / (100.0 - porcentagemBRA);
				System.out.println("=========================================");
				System.out.println("SEMI-FINAL (28/06/2025, 16:00 (GMT-3)): Bobrasileirão 2025 - Ressaquinha (MG):");
				System.out.println("=========================================");
				System.out.println("Em quem você aposta? (Porcentagens de vitória entre parênteses.)");
				System.out.println("===========================================");
			    System.out.printf(RED + "A - Bar Sem Lona (PA) (%.1f%%) -> ODD = %.3fx\n" + RESET, porcentagemBRA, oddABR);
			    System.out.printf(YELLOW + "B - Liver Pão de Queijo (MG) (%.1f%%) -> ODD = %.3fx\n" + RESET, (100 - porcentagemBRA), oddBBR);
				System.out.println("===========================================");
				escolha = user.lerTextoSMUpperCase(in);
				user.aposta();
				
				if (user.confirmacaoAposta == true && user.confirmacaoValor == true) {
				//sistema porcentagem
				if (porcentagemBRA >=0 && porcentagemBR <= porcentagemBRA) {
					resultado = "A";
				     System.out.println("===========================================");
				        System.out.println(RED + "Bar Sem Lona venceu, e eles finalmente puderam comprar lona!)" + RESET);
				        System.out.println("===========================================");
				} else {
					resultado = "B";
				     System.out.println("===========================================");
				        System.out.println(YELLOW + "Liver Pão de Queijo ganhou, e... Me dá um pouco de pão de queijo aí, na moral..." + RESET);
				        System.out.println("===========================================");
				}
				
			    double multiplicadorBR;
			    if (resultado.equals("A")) {
			        multiplicadorBR = oddABR;
			    } else {
			        multiplicadorBR = oddBBR;
			    }

				if (escolha.equals(resultado)) {
					validacaoBR = false;
					user.multiplicador(multiplicadorBR);
				} else {
					validacaoBR = false;
					user.multiplicador(0);
				}
				}
				} else {
					System.out.println("===========================================");
					System.out.println(RED + "Você já jogou este jogo hoje. Tente novamente mais tarde! ;)" + RESET);
					System.out.println("===========================================");
				}
				break;
				
			case 4:
				if (validacaoPP == true) {
				double oddAPP = 100.0 / porcentagemPPA;
				double oddBPP = 100.0 / (100.0 - porcentagemPPA);
				System.out.println("=========================================");
				System.out.println("OITAVAS DE FINAL (28/06/2025, 14:00 (GMT-3)): Copa do Mundo de Pega-Pega 2025 - Anta Gorda (RS):");
				System.out.println("=========================================");
				System.out.println("Em quem você aposta? (Porcentagens de vitória entre parênteses.)");
				System.out.println("===========================================");
			    System.out.printf(BLUE + "A - 🇬🇷Aristóteles (%.1f%%) -> ODD = %.3fx\n" + RESET, porcentagemPPA, oddAPP);
			    System.out.printf(GREEN + "B - 🇧🇷Raiam Santos (%.1f%%) -> ODD = %.3fx\n" + RESET, (100 - porcentagemPPA), oddBPP);
				System.out.println("===========================================");
				escolha = user.lerTextoSMUpperCase(in);
				user.aposta();
				
				if (user.confirmacaoAposta == true && user.confirmacaoValor == true) {
				//sistema porcentagem
				if (porcentagemPPA >=0 && porcentagemPP <= porcentagemPPA) {
					resultado = "A";
				} else {
					resultado = "B";
				}
				
			    double multiplicadorPP;
			    if (resultado.equals("A")) {
			        multiplicadorPP = oddAPP;
			        System.out.println("===========================================");
			        System.out.println(BLUE + "Aristóteles, no ato de ser e na potência de ganhar, venceu o jogo. Certamente é virtuoso. 🎖" + RESET);
			        System.out.println("===========================================");
			    } else {
			        multiplicadorPP = oddBPP;
			        System.out.println("===========================================");
			        System.out.println(GREEN + "Não sei como isso aconteceu, mas Raiam Santos venceu! Definitivamente se trata de uma questão de geopolítica. 🌎" + RESET);
			        System.out.println("===========================================");
			    }

				if (escolha.equals(resultado)) {
					validacaoPP = false;
					user.multiplicador(multiplicadorPP);
				} else {
					validacaoPP = false;
					user.multiplicador(0);
				}
				}
				} else { 
					System.out.println("===========================================");
					System.out.println(RED + "Você já jogou este jogo hoje. Tente novamente mais tarde! ;)" + RESET);
					System.out.println("===========================================");
				}
				break;
			case 5:
				System.out.println("Sistema encerrrado.");
				break;
				
			default: 
				System.out.println("==================================================");
				System.out.println("Opção inválida. Tente novamente.");
				System.out.println("==================================================");
				break;
			}
				
		}
	}
}
