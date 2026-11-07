package simulador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDeProcessos {
    private final Random random;
    private int proximoId = 1;

    public GeradorDeProcessos(long seed) {
        this.random = new Random(seed);   // seed fixa = mesma sequência sempre
    }

    public Processo gerar(int tempoChegada) {
        int instrucoes = 10 + random.nextInt(41);   // 10 a 50
        int prioridade = 1 + random.nextInt(5);     // 1 a 5
        return new Processo(proximoId++, instrucoes, prioridade, tempoChegada);
    }

    public List<Processo> gerarLista(int quantidade, int intervaloMaximo) {
        List<Processo> lista = new ArrayList<>();
        int tempo = 0;
        for (int i = 0; i < quantidade; i++) {
            lista.add(gerar(tempo));
            tempo += 1 + random.nextInt(intervaloMaximo);
        }
        return lista;
    }
}
