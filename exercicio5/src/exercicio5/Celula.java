package exercicio5;

public class Celula {
	Celula Proxima;
	int Elemento;

	public Celula() {
	}

	public Celula(int elemento) {
		this.Elemento = elemento;
	}

	public Celula(Celula proxima, int elemento) {
		this.Proxima = proxima;
		this.Elemento = elemento;
	}

	public void setProxima(Celula proxima) {
		this.Proxima = proxima;
	}

	public Celula getProxima() {
		return (this.Proxima);
	}

	public int getElemento() {
		return (this.Elemento);
	}

}
