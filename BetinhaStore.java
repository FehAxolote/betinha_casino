package br.betinha.sys;
public class BetinhaStore {
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";
   public static final String BOLD = "\u001B[1m";
    private String[] premios = {"(⏰) Relógio", "(🎧) Fone de ouvido", "(📱) Celular", "(💻) PC Gamer", "(🧣) Pelúcia do Ralsei"};
    private double[] custos = {2000.0, 3500.0, 25000.0, 50000.0, 99999.0};
    private int[] estoque = {50, 50, 50, 50, 1}; // Estoque inicial para cada prêmio
    private int[] posses = {0, 0, 0};

    public void mostrarPremios(User user) {
        System.out.println("Prêmios disponíveis:");
        for (int i = 0; i < premios.length; i++) {
            System.out.printf(CYAN + "%d - %s (R$%.2f) - Estoque: %d\n"  + RESET, (i + 1), premios[i], custos[i], estoque[i]);
        }
        System.out.println("=========================================");
		System.out.printf(YELLOW + BOLD + "Saldo de apostas atual: R$%.2f\n" + RESET, user.getSaldoAposta());
		System.out.println("=========================================");
    }

    public boolean resgatarPremio(User user, int escolha) {
        if (escolha <= 0 || escolha >= premios.length) {
            System.out.println("==================================================");
            System.out.println(RED + "Prêmio inválido. Retornando ao menu..." + RESET);
            
            System.out.println("==================================================");
            return false;
        }

        if (estoque[(escolha - 1)] <= 0) {
            System.out.println("==================================================");
            System.out.println(RED + "Este prêmio está esgotado." + RESET);
            System.out.println("==================================================");
            return false;
        }

        double custo = custos[(escolha - 1)];
        if (user.gastar(custo)) {
            estoque[(escolha - 1)]--;
            posses[(escolha - 1)]++;
            System.out.println("==================================================");
            System.out.println(GREEN + "Parabéns, você resgatou: " + premios[(escolha - 1)]);
            System.out.println("O item está sendo enviado ao seu endereço!" + RESET);
            System.out.printf(YELLOW + BOLD + "Saldo de aposta restante: R$%.2f\n" + RESET, user.getSaldoAposta());
            System.out.println("==================================================");

            // Verifica se todos os estoques estão zerados
            if (estoqueZerado()) {
                System.out.println(GREEN + "🎉🎉🎉 PARABÉNS! Você venceu a lojinha da Betinha! 🎉🎉🎉" + RESET);
            }

            return true;
        } else {
            System.out.println("==================================================");
            System.out.println(RED + "Você não tem saldo suficiente para este prêmio." + RESET);
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
    
    public void mostrarPosses() {
    	System.out.println("==================================================");
    	System.out.println(YELLOW + "Suas posses:" + RESET);
    	System.out.println("==================================================");
        for (int i = 0; i < posses.length; i++) {
            System.out.printf(YELLOW + "%d - %s | Quantidade: %d\n"  + RESET, (i + 1), premios[i], posses[i]);
        }
        System.out.println("==================================================");
    }  
}

