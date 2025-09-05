package br.betinha.sys;
import java.util.Random;
import java.util.Scanner;

public class IsaiasBet {
	
	public static Random random = new Random();
    public static boolean acertou = false;
    public static boolean jaUsouSenha = false;
    
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    private static final String SENHA_SECRETA = "isaias";
    private static final int BONUS = 3000;

    public static void jogar(User user, Scanner scanner) {
    	acertou = false;
    	int numeroParaAdivinhar = random.nextInt(10) + 1;
    	
        System.out.println(YELLOW + BOLD + "\n=== Jogo Especial: Adivinhe o Número ===" + RESET);
        System.out.println(YELLOW + "Tente adivinhar o número entre 1 e 10." + RESET);
        System.out.println(CYAN + "💡 Dica: Digite a senha secreta para ganhar R$3000 de bônus! (Uma única vez)" + RESET);

        while (!acertou) {
        	System.out.println("==================================================");
            System.out.print("Digite seu palpite (ou a senha secreta) \n(OBS: Se a senha secreta já foi digitada, tente acertar o número!) \nDigite no campo a seguir: "); ");
            String entrada = user.lerTextoSM(scanner);

            // Caso use a senha secreta
            if (entrada.equalsIgnoreCase(SENHA_SECRETA)) {
                if (!user.getSenhaSecretaUsada() && jaUsouSenha == false) {
                    user.depositarBonus(BONUS); 
                    jaUsouSenha = true;
                    System.out.println("==================================================");
                    System.out.println(GREEN + "🎁 Você ativou a senha secreta! R$3000 foram adicionados ao seu saldo principal." + RESET);
                    System.out.printf(GREEN + "Saldo principal atual: R$%.2f\n" + RESET, user.getSaldo());
                    System.out.println("==================================================");
                } else {
                	System.out.println("==================================================");
                    System.out.println(RED + "⚠️ A senha secreta já foi usada. Tente adivinhar o número." + RESET);
                    System.out.println("==================================================");
                }
                continue;
            }

            // Tenta converter para número
            int palpite;
            try {
                palpite = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
            	System.out.println("==================================================");
                System.out.println(RED + "Entrada inválida. Digite um número de 1 a 10 ou a senha secreta." + RESET);
                System.out.println("==================================================");
                continue;
            }

            // Valida e responde
            if (palpite == numeroParaAdivinhar) {
            	System.out.println("==================================================");
                System.out.println(GREEN + "🎉 Parabéns! Você acertou o número!" + RESET);
                System.out.println("==================================================");
                acertou = true;
            } else {
            	System.out.println("==================================================");
                System.out.println(RED + "❌ Errado! Tente novamente." + RESET);
                System.out.println("==================================================");
            }
        }
        System.out.println("==================================================");
        System.out.println(CYAN + "🏆 O jogo especial terminou. Boa sorte nas próximas apostas!" + RESET);
        System.out.println("==================================================");
    }
}
