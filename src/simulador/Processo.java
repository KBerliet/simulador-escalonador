package simulador;

public class Processo {
    private final int id;
    private final int instrucoesIniciais;
    private int quantidadeInstrucoes;      // restantes
    private final int prioridade;          // 1 a 5
    private final int tempoChegada;

    // métricas (a Pessoa 3 vai preencher)
    private int tempoEspera = 0;
    private int tempoTermino = -1;

    public Processo(int id, int instrucoes, int prioridade, int tempoChegada) {
        this.id = id;
        this.instrucoesIniciais = instrucoes;
        this.quantidadeInstrucoes = instrucoes;
        this.prioridade = prioridade;
        this.tempoChegada = tempoChegada;
    }

    public void executarInstrucao() {
        if (quantidadeInstrucoes > 0) quantidadeInstrucoes--;
    }

    public boolean terminou() {
        return quantidadeInstrucoes == 0;
    }

    // cópia "zerada", para reusar a mesma sequência em cada algoritmo
    public Processo copia() {
        return new Processo(id, instrucoesIniciais, prioridade, tempoChegada);
    }

    public int getId() { return id; }
    public int getInstrucoesIniciais() { return instrucoesIniciais; }
    public int getQuantidadeInstrucoes() { return quantidadeInstrucoes; }
    public int getPrioridade() { return prioridade; }
    public int getTempoChegada() { return tempoChegada; }
    public int getTempoEspera() { return tempoEspera; }
    public void incrementarEspera() { tempoEspera++; }
    public int getTempoTermino() { return tempoTermino; }
    public void setTempoTermino(int t) { this.tempoTermino = t; }

    @Override
    public String toString() {
        return "P" + id + "(restam=" + quantidadeInstrucoes + ", prio=" + prioridade + ")";
    }
}
