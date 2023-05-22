package exercicio2;

public class ListaDupla {
	Celula cabeca;
	int totalDeElementos = 0;

	public ListaDupla() {
		this.cabeca = new Celula();
		this.cabeca.setProxima(null);
		this.cabeca.setAnterior(null);
	}

	public void adicionaNoComeco(int elemento) {
		if (this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			nova.setProxima(this.cabeca);
			nova.setAnterior(this.cabeca);
			this.cabeca.setProxima(nova);
			this.cabeca.setAnterior(nova);
		} else {
			Celula nova = new Celula(elemento);
			nova.setProxima(this.cabeca.getProxima());
			nova.setAnterior(this.cabeca);
			this.cabeca.getProxima().setAnterior(nova);
			this.cabeca.setProxima(nova);
		}
		this.totalDeElementos++;
	}

	public void adicionaNoFinal(int elemento) {
		if (this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			nova.setAnterior(this.cabeca.getAnterior());
			nova.setProxima(this.cabeca);
			this.cabeca.getAnterior().setProxima(nova);
			this.cabeca.setAnterior(nova);
			this.totalDeElementos++;
		}
	}

	public boolean posicaoOcupada(int pos) {
		return (pos >= 0 && pos < this.totalDeElementos);
	}

	public Celula pegaCelula(int pos) {
		if (!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao Existe!!!");
		} else {
			Celula atual = this.cabeca.getProxima();
			for (int i = 0; i < pos; i++) {
				atual = atual.getProxima();
			}

			return atual;
		}
	}

	public void adicionaNaPos(int pos, int elemento) {
		if (pos == 0) {
			this.adicionaNoComeco(elemento);
		} else if (pos == this.totalDeElementos) {
			this.adicionaNoFinal(elemento);
		} else {
			Celula anterior = this.pegaCelula(pos - 1);
			Celula proxima = anterior.getProxima();
			Celula nova = new Celula(elemento);
			nova.setAnterior(anterior);
			nova.setProxima(proxima);
			anterior.setProxima(nova);
			proxima.setAnterior(nova);
			this.totalDeElementos++;
		}
	}

	public int pegaElemento(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}

	public void removeDoComeco() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posicao nao Existe");
		} else {
			Celula primeira = this.cabeca.getProxima();
			Celula segunda = primeira.getProxima();
			this.cabeca.setProxima(segunda);
			segunda.setAnterior(this.cabeca);
			this.totalDeElementos--;
		}
	}

	public void removeDoFim() {
		if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posicao nao existe");
		} else {
			Celula ultima = this.cabeca.getAnterior();
			Celula penultima = ultima.getAnterior();
			penultima.setProxima(this.cabeca);
			this.cabeca.setAnterior(penultima);
			this.totalDeElementos--;
		}
	}

	public void removePos(int pos) {
		if (!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao Existe");
		} else {
			if (pos == 0) {
				this.removeDoComeco();
			} else if (pos == this.totalDeElementos - 1) {
				this.removeDoFim();
			} else {
				Celula atual = this.pegaCelula(pos);
				Celula anterior = atual.getAnterior();
				Celula proxima = atual.getProxima();
				anterior.setProxima(proxima);
				proxima.setAnterior(anterior);
				this.totalDeElementos--;
			}
		}
	}

	public boolean contemPrimeiroParaUltimo(int elemento) {
		Celula atual = this.cabeca.getProxima();
		while (atual != this.cabeca) {
			if (atual.getElemento() == elemento) {
				return true;
			}
			atual = atual.getProxima();
		}
		return false;
	}

	public boolean contemUltimoParaPrimeiro(int elemento) {
		Celula atual = this.cabeca.getAnterior();
		while (atual != this.cabeca) {
			if (atual.getElemento() == elemento) {
				return true;
			}
			atual = atual.getAnterior();
		}
		return false;
	}

	public int tamanho() {
		return this.totalDeElementos;
	}

	public void esvaziaLista() {
		this.cabeca.setProxima(this.cabeca);
		this.cabeca.setAnterior(this.cabeca);
		this.totalDeElementos = 0;
	}

	public String imprimir() {
		if (this.totalDeElementos == 0) {
			return "[]";
		} else {
			StringBuilder builder = new StringBuilder("[");
			Celula atual = this.cabeca.getProxima();
			for (int i = 0; i < this.totalDeElementos - 1; i++) {
				builder.append(atual.getElemento());
				builder.append(", ");
				atual = atual.getProxima();
			}
			builder.append(atual.getElemento());
			builder.append("]");
			return builder.toString();
		}
	}
	
	
}
