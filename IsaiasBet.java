package br.betinha.sys;
import java.util.Random;
import java.util.Scanner;

public class IsaiasBet {

    private static final String SENHA_SECRETA = "isaias";
    private static final int BONUS = 3000;

    public static void jogar(User user, Scanner scanner) {
        Random random = new Random();
        int numeroParaAdivinhar = random.nextInt(10) + 1;
        boolean acertou = false;
        boolean jaUsouSenha = false;

        System.out.println("\n=== Jogo Especial: Adivinhe o Número ===");
        System.out.println("Tente adivinhar o número entre 1 e 10.");
        System.out.println("💡 Dica: Digite a senha secreta para ganhar R$3000 de bônus! (Uma única vez)");

        while (!acertou) {
            System.out.print("Digite seu palpite (ou a senha secreta): ");
            String entrada = scanner.nextLine();

            // Caso use a senha secreta
            if (entrada.equalsIgnoreCase(SENHA_SECRETA)) {
                if (!jaUsouSenha) {
                    user.depositarBonus(BONUS); // Crie esse método ou use setSaldoAposta com get+BONUS
                    jaUsouSenha = true;
                    System.out.println("🎁 Você ativou a senha secreta! R$3000 foram adicionados ao seu saldo de aposta.");
                    System.out.printf("Saldo atual: R$%.2f\n", user.getSaldo());
                } else {
                    System.out.println("⚠️ A senha secreta já foi usada. Tente adivinhar o número.");
                }
                continue;
            }

            // Tenta converter para número
            int palpite;
            try {
                palpite = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número de 1 a 10 ou a senha secreta.");
                continue;
            }

            // Valida e responde
            if (palpite == numeroParaAdivinhar) {
                System.out.println("🎉 Parabéns! Você acertou o número!");
                acertou = true;
            } else {
                System.out.println("❌ Errado! Tente novamente.");
            }
        }

        System.out.println("🏆 O jogo especial terminou. Boa sorte nas próximas apostas!");
    }
}
