package betinha_casino;
import java.util.Random;
import java.util.Scanner;

	public class IsaiasBet {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Configurações do dono
	        String donoUsername = "dono";
	        String donoPassword = "dono123";
	        String senhaSecreta = "isaias";  // Dá bônus de R$300

	        // Login
	        System.out.print("Digite o nome de usuário: ");
	        String inputUsername = scanner.nextLine();

	        System.out.print("Digite a senha: ");
	        String inputPassword = scanner.nextLine();

	        if (inputUsername.equals(donoUsername) && inputPassword.equals(donoPassword)) {
	            System.out.println("Bem-vindo, Dono do Jogo!");

	            // Escolha do número
	            System.out.print("Digite 1 para definir um número entre 1 e 10, ou 2 para o jogo sortear: ");
	            int escolha = scanner.nextInt();
	            int numeroParaAdivinhar;

	            if (escolha == 1) {
	                System.out.print("Digite um número entre 1 e 10: ");
	                numeroParaAdivinhar = scanner.nextInt();
	            } else {
	                Random random = new Random();
	                numeroParaAdivinhar = random.nextInt(10) + 1;
	                System.out.println("O número foi sorteado pelo sistema.");
	            }

	            scanner.nextLine(); // limpar buffer

	            // Iniciar jogo (sem resumo e sem limite de tentativas)
	            iniciarJogo(scanner, numeroParaAdivinhar, senhaSecreta);

	        } else {
	            System.out.println("Nome de usuário ou senha incorretos.");
	        }

	        scanner.close();
	    }

	    public static void iniciarJogo(Scanner scanner, int numeroParaAdivinhar, String senhaSecreta) {
	        boolean acertou = false;
	        int premio = 0;
	        boolean jaUsouSenha = false;

	        System.out.println("\n=== Início do Jogo ===");
	        System.out.println("Tente adivinhar o número entre 1 e 10.");
	        System.out.println("Dica: Se digitar a senha secreta, você recebe R$300 de bônus (apenas uma vez).");

	        while (!acertou) {
	            System.out.print("Digite seu palpite (ou a senha): ");
	            String entrada = scanner.nextLine();

	            // Verifica uso da senha secreta
	            if (entrada.equalsIgnoreCase(senhaSecreta)) {
	                if (!jaUsouSenha) {
	                    premio += 300;
	                    jaUsouSenha = true;
	                    System.out.println("🎁 Você ativou a senha secreta! R$300 adicionados ao seu prêmio.");
	                } else {
	                    System.out.println("⚠️ A senha secreta já foi usada. Continue tentando adivinhar o número.");
	                }
	                continue;
	            }

	            int palpite;
	            try {
	                palpite = Integer.parseInt(entrada);
	            } catch (NumberFormatException e) {
	                System.out.println("Entrada inválida. Digite um número entre 1 e 10 ou a senha.");
	                continue;
	            }

	            if (palpite == numeroParaAdivinhar) {
	                System.out.println("🎉 Parabéns! Você acertou o número!");
	                acertou = true;
	            } else {
	                System.out.println("Errado! Tente novamente.");
	            }
	        }

	        System.out.println("\n🏆 Jogo encerrado. Seu prêmio final: R$" + premio);
	    }
	}
