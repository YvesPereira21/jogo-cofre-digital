package processos;

public class Cofre {
    private double fundo;

    public Cofre() {
        this.fundo = 0;
    }

    public synchronized void adicionaFundo() {
        this.fundo += 2;
    }

    public synchronized double retornaFundo() {
        return this.fundo;
    }

    public synchronized void paga() {
        this.fundo *= 0.6;
        this.fundo = Math.round(this.fundo * 100.0)/100.0;
    }

    public synchronized void zeraFundo() {
        this.fundo = 0;
    }
}
