package br.betinha.sys;
public class BetinhaStore {
    private String[] premios = {"Relógio", "Fone de ouvido", "Celular"};
    private double[] custos = {2000.0, 3500.0, 25000.0};
    private int[] estoque = {2, 2, 1}; // Estoque inicial para cada prêmio

    public void mostrarPremios() {
        System.out.println("Prêmios disponíveis:");
        for (int i = 0; i < premios.length; i++) {
            System.out.printf("%d - %s (R$%.2f) - Estoque: %d\n", i, premios[i], custos[i], estoque[i]);
        }
    }

    public boolean resgatarPremio(User user, int escolha) {
        if (escolha < 0 || escolha >= premios.length) {
            System.out.println("==================================================");
            System.out.println("Prêmio inválido. Retornando ao menu...");
            
            System.out.println("==================================================");
            return false;
        }

        if (estoque[escolha] <= 0) {
            System.out.println("==================================================");
            System.out.println("Este prêmio está esgotado.");
            System.out.println("==================================================");
            return false;
        }

        double custo = custos[escolha];
        if (user.gastar(custo)) {
            estoque[escolha]--; // Diminui o estoque
            System.out.println("==================================================");
            System.out.println("Parabéns, você resgatou: " + premios[escolha]);
            System.out.println("O item está sendo enviado ao seu endereço!");
            System.out.printf("Saldo de Aposta restante: R$%.2f\n", user.getSaldoAposta());
            System.out.println("==================================================");

            // Verifica se todos os estoques estão zerados
            if (estoqueZerado()) {
                System.out.println("🎉🎉🎉 PARABÉNS! Você venceu a lojinha da Betinha! 🎉🎉🎉");
            }

            return true;
        } else {
            System.out.println("==================================================");
            System.out.println("Você não tem saldo suficiente para este prêmio.");
            System.out.println("==================================================");
            return false;
        }
    }

    private boolean estoqueZerado() {
        for (int i : estoque) {
            if (i > 0) return false;
        }
        return true;
    }
}

