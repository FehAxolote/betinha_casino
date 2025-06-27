package br.betinha.sys;
import java.util.Random;
import java.util.Scanner;

public class Bet {
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
		System.out.printf("Saldo de apostas atual: R$%.2f\n", user.getSaldoAposta());
		System.out.println("=========================================");
		selecao = in.nextInt();
		in.nextLine();
		if (selecao >= 1 && selecao <= 4) {
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
			    System.out.printf("A - 🇧🇷Pedro Álvares Cabral (%.1f%%) -> ODD = %.3fx\n", porcentagemTMA, oddATM);
			    System.out.printf("B - 🇨🇳Mao Tsé-Tung (%.1f%%) -> ODD = %.3fx\n", (100 - porcentagemTMA), oddBTM);
				System.out.println("===========================================");
				escolha = in.nextLine().trim().toUpperCase();
				user.aposta();
				//sistema porcentagem
				if (porcentagemTM >=0 && porcentagemTM <= porcentagemTMA) {
					resultado = "A";
				     System.out.println("===========================================");
				        System.out.println("Pedro Álvares Cabral utilizou uma raquete de pau-brasil e venceu.");
				        System.out.println("===========================================");
				} else {
					resultado = "B";
				     System.out.println("===========================================");
				        System.out.println("Mao Tsé-Tung iniciou uma revolução socialista no meio da partida e venceu.");
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
				} else {
					System.out.println("===========================================");
					System.out.println("Você já jogou este jogo hoje. Tente novamente mais tarde! ;)");
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
			    System.out.printf("A - 🇿🇦Nelson Mandela (%.1f%%) -> ODD = %.3fx\n", porcentagemCFA, oddACF);
			    System.out.printf("B - 🇵🇱Marie Curie (%.1f%%) -> ODD = %.3fx\n", (100 - porcentagemCFA), oddBCF);
				System.out.println("===========================================");
				escolha = in.nextLine().trim().toUpperCase();
				user.aposta();
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
			        System.out.println("Nelson Mandela deu capa em metade do server e venceu!");
			        System.out.println("===========================================");
			    } else {
			        multiplicadorCF = oddBCF;
			        System.out.println("===========================================");
			        System.out.println("Marie Curie utilizou o poder da radiação e ganhou!");
			        System.out.println("===========================================");
			    }

				if (escolha.equals(resultado)) {
					validacaoCF = false;
					user.multiplicador(multiplicadorCF);
				} else {
					validacaoCF = false;
					user.multiplicador(0);
				}
				} else {
					System.out.println("===========================================");
					System.out.println("Você já jogou este jogo hoje. Tente novamente mais tarde! ;)");
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
			    System.out.printf("A - Bar Sem Lona (PA) (%.1f%%) -> ODD = %.3fx\n", porcentagemBRA, oddABR);
			    System.out.printf("B - Liver Pão de Queijo (MG) (%.1f%%) -> ODD = %.3fx\n", (100 - porcentagemBRA), oddBBR);
				System.out.println("===========================================");
				escolha = in.nextLine().trim().toUpperCase();
				user.aposta();
				//sistema porcentagem
				if (porcentagemBRA >=0 && porcentagemBR <= porcentagemBRA) {
					resultado = "A";
				     System.out.println("===========================================");
				        System.out.println("Bar Sem Lona venceu, e eles finalmente puderam comprar lona!)");
				        System.out.println("===========================================");
				} else {
					resultado = "B";
				     System.out.println("===========================================");
				        System.out.println("Liver Pão de Queijo ganhou, e... Me dá um pouco de pão de queijo aí, na moral...");
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
				} else {
					System.out.println("===========================================");
					System.out.println("Você já jogou este jogo hoje. Tente novamente mais tarde! ;)");
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
			    System.out.printf("A - 🧣Ralsei ???? (%.1f%%) -> ODD = %.3fx\n", porcentagemPPA, oddAPP);
			    System.out.printf("B - ❤️Kris Dreemurr (%.1f%%) -> ODD = %.3fx\n", (100 - porcentagemPPA), oddBPP);
				System.out.println("===========================================");
				escolha = in.nextLine().trim().toUpperCase();
				user.aposta();
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
			        System.out.println("Ralsei ???? ganhou! (Contra a vontade dele.)");
			        System.out.println("===========================================");
			    } else {
			        multiplicadorPP = oddBPP;
			        System.out.println("===========================================");
			        System.out.println("Kris Dreemurr ganhou! (Ralsei ficou feliz com o resultado.)");
			        System.out.println("===========================================");
			    }

				if (escolha.equals(resultado)) {
					validacaoPP = false;
					user.multiplicador(multiplicadorPP);
				} else {
					validacaoPP = false;
					user.multiplicador(0);
				}
				} else { 
					System.out.println("===========================================");
					System.out.println("Você já jogou este jogo hoje. Tente novamente mais tarde! ;)");
					System.out.println("===========================================");
				}
				break;
			}
				
		}
	}
}
