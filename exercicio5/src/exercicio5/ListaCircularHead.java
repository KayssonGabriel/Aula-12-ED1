package exercicio5;

public class ListaCircularHead {
	Celula cabeca;
	int totalDeElementos = 0;

	public ListaCircularHead() {
		this.cabeca = new Celula();
		this.cabeca.setProxima(this.cabeca);
	}

	public void adicionaNoComeco(int elemento) {
		Celula nova = new Celula(elemento);
		nova.setProxima(this.cabeca.getProxima());
		this.cabeca.setProxima(nova);
		this.totalDeElementos++;
	}

	public void adicionaNoFinal(int elemento) {
		Celula nova = new Celula(elemento);
		nova.setProxima(this.cabeca);
		Celula ultima = this.cabeca;
		while (ultima.getProxima() != this.cabeca) {
			ultima = ultima.getProxima();
		}
		ultima.setProxima(nova);
		this.totalDeElementos++;
	}

	public boolean posicaoOcupada(int pos) {
		return (pos >= 0 && pos < this.totalDeElementos);
	}

	public Celula pegaCelula(int pos) {
		if (!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao Existe!!!");
		}
		Celula atual = this.cabeca.getProxima();
		for (int i = 0; i < pos; i++) {
			atual = atual.getProxima();
		}
		return atual;
	}

	public void adicionaNaPos(int pos, int elemento) {
		if (pos == 0) {
			this.adicionaNoComeco(elemento);
		} else if (pos == this.totalDeElementos) {
			this.adicionaNoFinal(elemento);
		} else {
			Celula anterior = this.pegaCelula(pos - 1);
			Celula nova = new Celula(elemento);
			nova.setProxima(anterior.getProxima());
			anterior.setProxima(nova);
			this.totalDeElementos++;
		}
	}

	public int pegaElemento(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}

	public void removeDoComeco() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posicao nao Existe");
		}
		Celula primeira = this.cabeca.getProxima();
		this.cabeca.setProxima(primeira.getProxima());
		primeira.setProxima(null);
		this.totalDeElementos--;
	}

	public void removeDoFim() {
		if (!this.posicaoOcupada(totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posicao nao existe");
		}
		if (this.totalDeElementos == 1) {
			this.removeDoComeco();
		} else {
			Celula penultima = this.pegaCelula(totalDeElementos - 2);
			Celula ultima = penultima.getProxima();
			penultima.setProxima(this.cabeca);
			ultima.setProxima(null);
			this.totalDeElementos--;
		}
	}

	public void removePos(int pos) {
		if (!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao Existe");
		}
		if (pos == 0) {
			this.removeDoComeco();
		} else if (pos == this.totalDeElementos - 1) {
			this.removeDoFim();
		} else {
			Celula anterior = this.pegaCelula(pos - 1);
			Celula atual = anterior.getProxima();
			Celula proxima = atual.getProxima();
			anterior.setProxima(proxima);
			atual.setProxima(null);
			this.totalDeElementos--;
		}
	}

	public boolean contem(int elemento) {
		Celula atual = this.cabeca.getProxima();
		while (atual != this.cabeca) {
			if (atual.getElemento() == elemento) {
				return true;
			}
			atual = atual.getProxima();
		}
		return false;
	}

	public int tamanho() {
		return this.totalDeElementos;
	}

	public void esvaziaLista() {
		this.cabeca.setProxima(this.cabeca);
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
