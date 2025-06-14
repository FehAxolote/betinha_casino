package betinha_casino;
import java.util.Random;
import java.util.Scanner;

public class betting_game {
	public static void main(String[] args) {
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
			System.out.println("1 - Adivinhacao facil -> 1 a 12 (pontos 1.25x, maximo de tentativas = 3);");
			System.out.println("2 - Adivinhacao media -> de 1 a 50 (pontos 2.5x, maximo de tentativas = 5);");
			System.out.println("3 - Adivinhacao dificil -> de 1 a 100 (pontos 5.0x, maximo de tentativas = 8);");
			System.out.println("4 - Adivinhacao mestra -> de 1 a 250 (pontos 10.0x, maximo de tentativas = 10);");
			System.out.println("5 - Adivinhacao impossivel -> de 1 a 500 (pontos 20.0x, maximo de tentativas = 12);");
			System.out.println("Digite qualquer outro numero para sair.");
			opcao = i.nextInt();

			
			switch(opcao) {
			
			case 1: 
			if(tentativas_drop1 > MAX_TENTATIVAS && confirmacao1 == true) {
			do {
				System.out.println("==================================================");
				System.out.println("Pense em um numero de 1 a 12 e digite-o a seguir:");
				numeroDigitado = i.nextInt();
					if (numeroDigitado == numeroSorteado_drop1 && tentativas_drop1 > MAX_TENTATIVAS) {
						confirmacao1 = false;
						System.out.println("==================================================");
						System.out.println("Voce acertou!");
						System.out.println("==================================================");
					} else {
					tentativas_drop1--;
					System.out.println("==================================================");
					System.out.println("Voce errou. Tentativas restantes: " +tentativas_drop1);
					}
			} while(numeroDigitado != numeroSorteado_drop1 && tentativas_drop1 > MAX_TENTATIVAS);
			System.out.println("==================================================");
			System.out.println("Numero maximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop1);
			System.out.println("==================================================");
			} else {
				System.out.println("==================================================");
				System.out.println("Voce ja jogou este jogo. Volte mais tarde ou reinicie o sistema.");
				System.out.println("==================================================");
			}
			break;
			
			case 2:
				if(tentativas_drop2 > MAX_TENTATIVAS && confirmacao2 == true) {
				do {
					System.out.println("==================================================");
					System.out.println("Pense em um numero de 1 a 50 e digite-o a seguir:");
					numeroDigitado = i.nextInt();
						if (numeroDigitado == numeroSorteado_drop2 && tentativas_drop2 > MAX_TENTATIVAS) {
							confirmacao2 = false;
							System.out.println("==================================================");
							System.out.println("Voce acertou!");
							System.out.println("==================================================");
						} else {
						tentativas_drop2--;
						System.out.println("==================================================");
						System.out.println("Voce errou. Tentativas restantes: " +tentativas_drop2);
						}
				} while(numeroDigitado != numeroSorteado_drop2 && tentativas_drop2 > MAX_TENTATIVAS);
				System.out.println("==================================================");
			System.out.println("Numero maximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop2);
			System.out.println("==================================================");
				} else {
					System.out.println("==================================================");
					System.out.println("Voce ja jogou este jogo. Volte mais tarde ou reinicie o sistema.");
					System.out.println("==================================================");
				}
			break;
			
			case 3: 
				if(tentativas_drop3 > MAX_TENTATIVAS && confirmacao3 == true) {
				do {
					System.out.println("==================================================");
					System.out.println("Pense em um numero de 1 a 100 e digite-o a seguir:");
					numeroDigitado = i.nextInt();
						if (numeroDigitado == numeroSorteado_drop3 && tentativas_drop3 > MAX_TENTATIVAS) {
							confirmacao3 = false;
							System.out.println("==================================================");
							System.out.println("Voce acertou!");
							System.out.println("==================================================");
						} else {
						tentativas_drop3--;
						System.out.println("==================================================");
						System.out.println("Voce errou. Tentativas restantes: " +tentativas_drop3);
						}
				} while(numeroDigitado != numeroSorteado_drop3 && tentativas_drop3 > MAX_TENTATIVAS);
				System.out.println("==================================================");
			System.out.println("Numero maximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop3);
			System.out.println("==================================================");
				} else {
					System.out.println("==================================================");
					System.out.println("Voce ja jogou este jogo. Volte mais tarde ou reinicie o sistema.");
					System.out.println("==================================================");
				}
				break;
				
			case 4:
				if(tentativas_drop4 > MAX_TENTATIVAS && confirmacao4 == true) {
				do {
					System.out.println("==================================================");
					System.out.println("Pense em um numero de 1 a 250 e digite-o a seguir:");
					numeroDigitado = i.nextInt();
						if (numeroDigitado == numeroSorteado_drop4 && tentativas_drop4 > MAX_TENTATIVAS) {
							confirmacao4 = false;
							System.out.println("==================================================");
							System.out.println("Voce acertou!");
							System.out.println("==================================================");
						} else {
						tentativas_drop4--;
						System.out.println("==================================================");
						System.out.println("Voce errou. Tentativas restantes: " +tentativas_drop4);
						}
				} while(numeroDigitado != numeroSorteado_drop4 && tentativas_drop4 > MAX_TENTATIVAS);
				System.out.println("==================================================");
			System.out.println("Numero maximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop4);
			System.out.println("==================================================");
				} else {
					System.out.println("==================================================");
					System.out.println("Voce ja jogou este jogo. Volte mais tarde ou reinicie o sistema.");
					System.out.println("==================================================");
				}
				break;
				
			case 5:
				if(tentativas_drop5 > MAX_TENTATIVAS && confirmacao5 == true) {
				do {
					System.out.println("==================================================");
					System.out.println("Pense em um numero de 1 a 500 e digite-o a seguir:");
					numeroDigitado = i.nextInt();
						if (numeroDigitado == numeroSorteado_drop5 && tentativas_drop5 > MAX_TENTATIVAS) {
							confirmacao5 = false;
							System.out.println("==================================================");
							System.out.println("Voce acertou!");
							System.out.println("==================================================");
						} else {
						tentativas_drop5--;
						System.out.println("==================================================");
						System.out.println("Voce errou. Tentativas restantes: " +tentativas_drop5);
						}
				} while(numeroDigitado != numeroSorteado_drop5 && tentativas_drop5 > MAX_TENTATIVAS);
				System.out.println("==================================================");
			System.out.println("Numero maximo de tentativas excedido. Numero sorteado: " +numeroSorteado_drop5);
			System.out.println("==================================================");
				} else {
					System.out.println("==================================================");
					System.out.println("Voce ja jogou este jogo. Volte mais tarde ou reinicie o sistema.");
					System.out.println("==================================================");
				}
				break;
				
			} 
		} System.out.println("Sistema encerrado.");
	}
}
