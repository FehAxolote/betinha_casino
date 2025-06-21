	package betinha_casino;

import java.util.Scanner;

public class GeneralMenu {
	public static void main(String[] args) {
	//importando classes
		user user = new user();
		adivinhação a = new adivinhação();
		Scanner in = new Scanner(System.in);
		
	//var
		boolean a1 = true;
		boolean b = true;
		int selecao1;
		int selecao2; 
		
	//iniciando o sistema 
		user.identidade();
		while (user.login == false && user.logindefinitivo == true) {
			user.login();
		}
		if(user.login == true && user.logindefinitivo == true) {
			while (a1) {
			System.out.println("=========================================");
			System.out.println("Bem-vindo ao MENU da BETINHA!");
			System.out.println("1 - Verificar banco;");
			System.out.println("2 - Cassino e bet;");
			System.out.println("3 - Loja da BETINHA.");
			System.out.println("4 - Sair.");
			selecao1 = in.nextInt();
			if (selecao1 >= 1 && selecao1 <= 3) {
				a1 = true;
			} else {
				a1 = false;
			} 
			
			switch (selecao1) {
				case 1:
					while (b) {
						System.out.println("Selecione uma das opcoes a seguir:");
						System.out.println("===========================================");
						System.out.println("Bem-vindo ao MENU da BankTinha!");
						System.out.println("1 - Sacar;");
						System.out.println("2 - Depositar;");
						System.out.println("3 - Verificar saldo.");
						System.out.println("4 - Desbloquear cartao;");
						System.out.println("5 - Sair.");
						selecao2 = in.nextInt();
						if (selecao2 >= 1 && selecao2 <= 4) {
							b = true;
						} else {
							b = false;
						} 
						switch(selecao2) {
						case 1:
							user.sacarSaldo();
							break;
						case 2: 
							user.depositarSaldo();
							break;
						case 3: 
							System.out.println("Seu saldo e: " + user.getSaldo());
							break;
						case 4: 
							user.desbloquearCartao();
							break;
						}
			}	
					break;
				case 2:
					
					break;
					
				case 3:
					break;
					
			
			
			}
		}
	}
	}
}
	
