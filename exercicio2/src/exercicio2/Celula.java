package exercicio2;

public class Celula {
    private int elemento;
    private Celula anterior;
    private Celula proxima;

    public Celula() {
    }

    public Celula(int elemento) {
        this.elemento = elemento;
    }

    public Celula(Celula proxima, int elemento) {
        this.elemento = elemento;
        this.proxima = proxima;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }

    public Celula getProxima() {
        return this.proxima;
    }

    public Celula getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public int getElemento() {
        return this.elemento;
    }
}
