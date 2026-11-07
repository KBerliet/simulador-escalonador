package simulador;

import java.util.List;

public class TesteGerador {

    public static void main(String[] args) {
        testarSeed();
        testarProcesso();
    }

    // gera duas listas com a mesma seed e compara
    static void testarSeed() {
        List<Processo> lista1 = new GeradorDeProcessos(42).gerarLista(8, 5);
        List<Processo> lista2 = new GeradorDeProcessos(42).gerarLista(8, 5);

        System.out.println("Processos gerados:");
        for (Processo p : lista1) {
            System.out.println(p + " chegada=" + p.getTempoChegada());
        }

        boolean iguais = true;
        for (int i = 0; i < lista1.size(); i++) {
            Processo a = lista1.get(i);
            Processo b = lista2.get(i);

            if (a.getInstrucoesIniciais() != b.getInstrucoesIniciais()
                    || a.getPrioridade() != b.getPrioridade()
                    || a.getTempoChegada() != b.getTempoChegada()) {
                iguais = false;
            }
        }
        System.out.println("Listas iguais com a mesma seed? " + iguais);
    }

    // executa um processo ate o fim e ve se a copia continua intacta
    static void testarProcesso() {
        Processo original = new Processo(1, 10, 3, 0);
        Processo copia = original.copia();

        while (!original.terminou()) {
            original.executarInstrucao();
        }

        System.out.println("Original terminou? " + original.terminou());
        System.out.println("Copia intacta? "
                + (copia.getQuantidadeInstrucoes() == copia.getInstrucoesIniciais()));
    }
}
