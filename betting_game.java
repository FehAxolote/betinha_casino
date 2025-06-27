package br.betinha.sys;
import java.util.Random;
import java.util.Scanner;

public class BettingGame {
	public
	void game(User user) {
    //codes in portuguese
		//presets
		Random random = new Random();
		Scanner i = new Scanner (System.in);
		int numeroDigitado;
		int numeroSorteado_drop1 = random.nextInt(12) + 1;
		int numeroSorteado_drop2 = random.nextInt(50) + 1;
		int numeroSorteado_drop3 = random.nextInt(100) + 1;
		int numeroSorteado_drop4 = random.nextInt(250) + 1;
		int numeroSorteado_drop5 = random.nextInt(500) + 1;
		final int MAX_TENTATIVAS = 0;
		int tentativas_drop1 = 3;
		int tentativas_drop2 = 5;
		int tentativas_drop3 = 8;
		int tentativas_drop4 = 10;
		int tentativas_drop5 = 12;
		int opcao = 1;
		boolean confirmacao1 = true;
		boolean confirmacao2 = true;
		boolean confirmacao3 = true;
		boolean confirmacao4 = true;
		boolean confirmacao5 = true;

		//console
		while (opcao >= 1 && opcao <= 5) {
			System.out.println("=-MENU-=");
			System.out.print("Selecione uma das opcoes a seguir. \nQuanto maior for a amplitude da aposta, maior a pontuacao obtida por acerto.\n");
			System.out.println("1 - Adivinhação facil -> 1 a 12 (máximo de tentativas = 3, multiplicador máximo: 2.5x);");
			System.out.println("2 - Adivinhação média -> de 1 a 50 (máximo de tentativas = 5,  multiplicador máximo: 5.0x);");
			System.out.println("3 - Adivinhação difícil -> de 1 a 100 (máximo de tentativas = 8,  multiplicador máximo: 10.0x);");
			System.out.println("4 - Adivinhação mestra -> de 1 a 250 (máximo de tentativas = 10, multiplicador máximo: 20.0x);");
			System.out.println("5 - Adivinhação impossível -> de 1 a 500 (máximo de tentativas = 12,  multiplicador máximo: 40.0x);");
			System.out.println("Digite qualquer outro número para sair.");
			System.out.println("=========================================");
			System.out.printf("Saldo de apostas atual: R$%.2f\n", user.getSaldoAposta());
			System.out.println("=========================================");
			String entrada = i.nextLine(); 
			opcao = Integer.parseInt(entrada);
			
			switch(opcao) {
			
			case 1: 
				int melhorDistancia1 = Integer.MAX_VALUE;
				int melhorPalpite1 = -1;
			if(tentativas_drop1 > MAX_TENTATIVAS && confirmacao1 == true) {
				user.aposta();
			do {
				System.out.println("==================================================");
				System.out.println("Pense em um numero de 1 a 12 e digite-o a seguir:");
				numeroDigitado = i.nextInt();
				int distancia1 = Math.abs(numeroDigitado - numeroSorteado_drop1);
					if (numeroDigitado == numeroSorteado_drop1 && tentativas_drop1 > MAX_TENTATIVAS) {
						confirmacao1 = false;
						System.out.println("==================================================");
						System.out.println("Você acertou! Sua aposta foi multiplicada em 2.5x");
						System.out.println("==================================================");
						user.multiplicador(2.5);
					} else {
						if (distancia1 < melhorDistancia1) {
							melhorDistancia1 = distancia1;
							melhorPalpite1 = numeroDigitado;
						}
					tentativas_drop1--;
					System.out.println("==================================================");
					System.out.println("Você errou. Tentativas restantes: " +tentativas_drop1);
					}
			} while(numeroDigitado != numeroSorteado_drop1 && tentativas_drop1 > MAX_TENTATIVAS);
			if (melhorPalpite1 != numeroSorteado_drop1) {
				System.out.println("==================================================");
				System.out.println("Seu melhor palpite: " + melhorPalpite1 + ".");
				System.out.println("Número máximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop1);
				System.out.println("Saldo apostado, infelizmente, perdido. :(");
				System.out.println("==================================================");
				user.multiplicador(0);
			} else {
			System.out.println("==================================================");
			System.out.println("Seu melhor palpite: " + melhorPalpite1 + ".");
			System.out.println("Número máximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop1);
			System.out.println("==================================================");
			}
			} else {
				System.out.println("==================================================");
				System.out.println("Você já jogou este jogo. Volte mais tarde ou reinicie o sistema.");
				System.out.println("==================================================");
			}
			break;
			
			case 2:
				int melhorDistancia2 = Integer.MAX_VALUE;
				int melhorPalpite2 = -1;
				if(tentativas_drop2 > MAX_TENTATIVAS && confirmacao2 == true) {
					user.aposta();
				do {
					System.out.println("==================================================");
					System.out.println("Pense em um numero de 1 a 50 e digite-o a seguir:");
					numeroDigitado = i.nextInt();
					int distancia2 = Math.abs(numeroDigitado - numeroSorteado_drop2);
						if (numeroDigitado == numeroSorteado_drop2 && tentativas_drop2 > MAX_TENTATIVAS) {
							confirmacao2 = false;
							System.out.println("==================================================");
							System.out.println("Você acertou! Sua aposta foi multiplicada em 5.0x");
							System.out.println("==================================================");
							user.multiplicador(5);
						} else {
							if (distancia2 < melhorDistancia2) {
								melhorDistancia2 = distancia2;
								melhorPalpite2 = numeroDigitado;
							}
						tentativas_drop2--;
						System.out.println("==================================================");
						System.out.println("Você errou. Tentativas restantes: " +tentativas_drop2);
						}
				} while(numeroDigitado != numeroSorteado_drop2 && tentativas_drop2 > MAX_TENTATIVAS);
				if (melhorDistancia2 <= 3) {
					System.out.println("==================================================");
					double multiplicador1 = (4/melhorDistancia2);
					System.out.println("Você se aproximou suficientemente do número para ganhar um multiplicador! Multiplicador = " + multiplicador1 + "x.");
					System.out.println("==================================================");
					user.multiplicador(multiplicador1);
				} else {
					System.out.println("==================================================");
					System.out.println("Infelizmente, não foi possível obter nenhum bônus, e o dinheiro foi perdido. :( Tente novamente mais tarde.");
					System.out.println("==================================================");
					user.multiplicador(0);
				}
			System.out.println("==================================================");
			System.out.println("Seu melhor palpite: " + melhorPalpite2 + ".");
			System.out.println("Numero máximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop2 + ".");
			System.out.println("==================================================");
			
				} else {
					System.out.println("==================================================");
					System.out.println("Você já jogou este jogo. Volte mais tarde ou reinicie o sistema.");
					System.out.println("==================================================");
				}
			break;
			
			case 3: 
				int melhorDistancia3 = Integer.MAX_VALUE;
				int melhorPalpite3 = -1;
				if(tentativas_drop3 > MAX_TENTATIVAS && confirmacao3 == true) {
					user.aposta();
				do {
					System.out.println("==================================================");
					System.out.println("Pense em um numero de 1 a 100 e digite-o a seguir:");
					numeroDigitado = i.nextInt();
					int distancia3 = Math.abs(numeroDigitado - numeroSorteado_drop3);
						if (numeroDigitado == numeroSorteado_drop3 && tentativas_drop3 > MAX_TENTATIVAS) {
							confirmacao3 = false;
							System.out.println("==================================================");
							System.out.println("Você acertou! Sua aposta foi multiplicada em 10.0x");
							System.out.println("==================================================");
							user.multiplicador(10);
						} else {
							if (distancia3 < melhorDistancia3) {
								melhorDistancia3 = distancia3;
								melhorPalpite3 = numeroDigitado;
							}
						tentativas_drop3--;
						System.out.println("==================================================");
						System.out.println("Voce errou. Tentativas restantes: " +tentativas_drop3);
						}
				} while(numeroDigitado != numeroSorteado_drop3 && tentativas_drop3 > MAX_TENTATIVAS);
				if (melhorDistancia3 <= 5) {
					System.out.println("==================================================");
					double multiplicador2 = (6/melhorDistancia3);
					System.out.println("Você se aproximou suficientemente do número para ganhar um multiplicador! Multiplicador = " + multiplicador2 + "x.");
					System.out.println("==================================================");
					user.multiplicador(multiplicador2);
				} else {
					System.out.println("==================================================");
					System.out.println("Infelizmente, não foi possível obter nenhum bônus, e o dinheiro foi perdido. :( Tente novamente mais tarde.");
					System.out.println("==================================================");
					user.multiplicador(0);
				}
			System.out.println("==================================================");
			System.out.println("Seu melhor palpite: " + melhorPalpite3 + ".");
			System.out.println("Numero máximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop3 + ".");
			System.out.println("==================================================");
			
				} else {
					System.out.println("==================================================");
					System.out.println("Você já jogou este jogo. Volte mais tarde ou reinicie o sistema.");
					System.out.println("==================================================");
				}
				break;
				
			case 4:
				int melhorDistancia4 = Integer.MAX_VALUE;
				int melhorPalpite4 = -1;
				if(tentativas_drop4 > MAX_TENTATIVAS && confirmacao4 == true) {
					user.aposta();
				do {
					System.out.println("==================================================");
					System.out.println("Pense em um numero de 1 a 250 e digite-o a seguir:");
					numeroDigitado = i.nextInt();
					int distancia4 = Math.abs(numeroDigitado - numeroSorteado_drop4);
						if (numeroDigitado == numeroSorteado_drop4 && tentativas_drop4 > MAX_TENTATIVAS) {
							confirmacao4 = false;
							System.out.println("==================================================");
							System.out.println("Voce acertou! Sua aposta foi multiplicada em 20.0x");
							System.out.println("==================================================");
							user.multiplicador(20);
						} else {
							if (distancia4 < melhorDistancia4) {
								melhorDistancia4 = distancia4;
								melhorPalpite4 = numeroDigitado;
							}
						tentativas_drop4--;
						System.out.println("==================================================");
						System.out.println("Voce errou. Tentativas restantes: " +tentativas_drop4);
						}
				} while(numeroDigitado != numeroSorteado_drop4 && tentativas_drop4 > MAX_TENTATIVAS);
				if (melhorDistancia4 <= 7) {
					System.out.println("==================================================");
					double multiplicador3 = (8/melhorDistancia4);
					System.out.println("Você se aproximou suficientemente do número para ganhar um multiplicador! Multiplicador = " + multiplicador3 + "x.");
					System.out.println("==================================================");
					user.multiplicador(multiplicador3);
				} else {
					System.out.println("==================================================");
					System.out.println("Infelizmente, não foi possível obter nenhum bônus, e o dinheiro foi perdido. :( Tente novamente mais tarde.");
					System.out.println("==================================================");
					user.multiplicador(0);
				}
			System.out.println("==================================================");
			System.out.println("Seu melhor palpite: " + melhorPalpite4 + ".");
			System.out.println("Numero máximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop4 + ".");
			System.out.println("==================================================");
			
				} else {
					System.out.println("==================================================");
					System.out.println("Você já jogou este jogo. Volte mais tarde ou reinicie o sistema.");
					System.out.println("==================================================");
				}
				break;
				
			case 5:
				int melhorDistancia5 = Integer.MAX_VALUE;
				int melhorPalpite5 = -1;
				if(tentativas_drop5 > MAX_TENTATIVAS && confirmacao5 == true) {
					user.aposta();
				do {
					System.out.println("==================================================");
					System.out.println("Pense em um numero de 1 a 500 e digite-o a seguir:");
					numeroDigitado = i.nextInt();
					int distancia5 = Math.abs(numeroDigitado - numeroSorteado_drop4);
						if (numeroDigitado == numeroSorteado_drop5 && tentativas_drop5 > MAX_TENTATIVAS) {
							confirmacao5 = false;
							System.out.println("==================================================");
							System.out.println("Você acertou! Sua aposta foi multiplicada em 40.0x.");
							System.out.println("==================================================");
							user.multiplicador(40);
						} else {
							if (distancia5 < melhorDistancia5) {
								melhorDistancia5 = distancia5;
								melhorPalpite5 = numeroDigitado;
							}
						tentativas_drop5--;
						System.out.println("==================================================");
						System.out.println("Você errou. Tentativas restantes: " +tentativas_drop5);
						}
				} while(numeroDigitado != numeroSorteado_drop5 && tentativas_drop5 > MAX_TENTATIVAS);
				if (melhorDistancia5 <= 10) {
					System.out.println("==================================================");
					double multiplicador4 = (11/melhorDistancia5);
					System.out.println("Você se aproximou suficientemente do número para ganhar um multiplicador! Multiplicador = " + multiplicador4 + "x.");
					System.out.println("==================================================");
					user.multiplicador(multiplicador4);
				} else {
					System.out.println("==================================================");
					System.out.println("Infelizmente, não foi possível obter nenhum bônus, e o dinheiro foi perdido. :( Tente novamente mais tarde.");
					System.out.println("==================================================");
					user.multiplicador(0);
				}
			System.out.println("==================================================");
			System.out.println("Seu melhor palpite: " + melhorPalpite5 + ".");
			System.out.println("Numero máximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop5 + ".");
			System.out.println("==================================================");
				} else {
					System.out.println("==================================================");
					System.out.println("Voce já jogou este jogo. Volte mais tarde ou reinicie o sistema.");
					System.out.println("==================================================");
				}
				break;
				
			} 
		} System.out.println("Sistema encerrado.");
	}
}
