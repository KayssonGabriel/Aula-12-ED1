package exercicio4;

public class ListaCircularDupla {
	Celula primeira;
	Celula ultima;
	int totalDeElementos = 0;

	// a)
	public int contarElementosListaCircular() {
		if (totalDeElementos == 0) {
			return 0;
		} else {
			int contador = 1;
			Celula atual = primeira.getProxima();
			while (atual != primeira) {
				contador++;
				atual = atual.getProxima();
			}
			return contador;
		}
	}

	// b)
	public void inserirEsquerda(int elemento) {
		if (totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			nova.setProxima(this.primeira);
			nova.setAnterior(this.ultima);
			this.primeira.setAnterior(nova);
			this.ultima.setProxima(nova);
			ultima.setProxima(primeira);
			this.primeira = nova;
			totalDeElementos++;
		}
	}

	// c)
	public void concatenarListas(ListaCircularDupla lista2) {
		if (lista2.totalDeElementos == 0) {
			return;
		}

		if (this.totalDeElementos == 0) {
			this.primeira = lista2.primeira;
			this.ultima = lista2.ultima;
		} else {
			this.ultima.setProxima(lista2.primeira);
			lista2.primeira.setAnterior(ultima);
			lista2.ultima.setProxima(this.primeira);
			this.primeira.setAnterior(lista2.ultima);
			this.ultima = lista2.ultima;
			this.totalDeElementos += lista2.totalDeElementos;
		}

		lista2.primeira = null;
		lista2.ultima = null;
		lista2.totalDeElementos = 0;
	}

	// d)
	public ListaCircularDupla intercalarListasOrdenadas(ListaCircularDupla lista1, ListaCircularDupla lista2) {
		ListaCircularDupla novaListaIntercalada = new ListaCircularDupla();

		int tamanhoLista1 = lista1.tamanho();
		int tamanhoLista2 = lista2.tamanho();

		int tamanho = Math.min(tamanhoLista1, tamanhoLista2);

		for (int i = 0; i < tamanho; i++) {
			int elementoAtual1 = lista1.pegaElemento(i);
			int elementoAtual2 = lista2.pegaElemento(i);

			if (elementoAtual1 < elementoAtual2) {
				novaListaIntercalada.adicionaNoFinal(elementoAtual1);
				novaListaIntercalada.adicionaNoFinal(elementoAtual2);
			} else if (elementoAtual1 > elementoAtual2) {
				novaListaIntercalada.adicionaNoFinal(elementoAtual2);
				novaListaIntercalada.adicionaNoFinal(elementoAtual1);
			} else {
				novaListaIntercalada.adicionaNoFinal(elementoAtual1);
				novaListaIntercalada.adicionaNoFinal(elementoAtual2);
			}
		}

		if (tamanho < tamanhoLista1) {
			for (int i = tamanho; i < tamanhoLista1; i++) {
				int elementoAtual1 = lista1.pegaElemento(i);
				novaListaIntercalada.adicionaNoFinal(elementoAtual1);
			}
		}

		else if (tamanho < tamanhoLista2) {
			for (int i = tamanho; i < tamanhoLista2; i++) {
				int elementoAtual2 = lista2.pegaElemento(i);
				novaListaIntercalada.adicionaNoFinal(elementoAtual2);
			}
		}

		return novaListaIntercalada;
	}

	// e)
	public ListaCircularDupla copiarLista() {
		ListaCircularDupla novaLista = new ListaCircularDupla();

		if (this.totalDeElementos == 0) {
			return novaLista;
		}

		Celula atual = this.primeira;
		novaLista.adicionaNoFinal(atual.getElemento());

		for (int i = 1; i < this.totalDeElementos; i++) {
			atual = atual.getProxima();
			novaLista.adicionaNoFinal(atual.getElemento());
		}

		return novaLista;
	}

	public void adicionaNoComeco(int elemento) {
		if (this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = this.primeira;
			nova.setProxima(nova);
			nova.setAnterior(nova);
		} else {
			Celula nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
			this.ultima.setProxima(this.primeira);
			this.primeira.setAnterior(this.ultima);
		}
		this.totalDeElementos++;
	}

	public void adicionaNoFinal(int elemento) {
		if (this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			nova.setAnterior(this.ultima);
			this.ultima.setProxima(nova);
			nova.setProxima(this.primeira);
			this.primeira.setAnterior(nova);
			this.ultima = nova;
			this.totalDeElementos++;
		}
	}

	public boolean posicaoOcupada(int pos) {
		return ((pos >= 0) && (pos < this.totalDeElementos));
	}

	public Celula pegaCelula(int pos) {
		if (!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao Existe!!!");
		} else {
			Celula atual = this.primeira;
			for (int i = 0; i < pos; i++) {
				atual = atual.getProxima();
			}

			return (atual);
		}
	}

	public void adicionaNaPos(int pos, int elemento) {
		if (pos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			if (pos == this.totalDeElementos) {
				this.adicionaNoFinal(elemento);
			} else {
				Celula anterior = this.pegaCelula(pos - 1);
				Celula proxima = anterior.getProxima();
				Celula nova = new Celula(anterior.getProxima(), elemento);
				anterior.setProxima(nova);
				proxima.setAnterior(nova);
				this.totalDeElementos++;
			}
		}
	}

	public int pegaElemento(int posicao) {
		return (this.pegaCelula(posicao).getElemento());
	}

	public void removeDoComeco() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posicao nao Existe");
		} else {
			Celula segunda = this.primeira.getProxima();
			segunda.setAnterior(this.ultima);
			this.ultima.setProxima(segunda);
			this.primeira = segunda;
			this.totalDeElementos--;
			if (this.totalDeElementos == 0) {
				this.ultima = null;
			}

		}
	}

	public void removeDoFim() {
		if (!this.posicaoOcupada(totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posicao nao existe");
		} else {
			if (this.totalDeElementos == 1) {
				this.removeDoComeco();
			} else {
				Celula penultima = this.ultima.getAnterior();
				penultima.setProxima(this.primeira);
				this.primeira.setAnterior(penultima);
				this.ultima = penultima;
				this.totalDeElementos--;
			}
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
				Celula anterior = this.pegaCelula(pos - 1);
				Celula atual = anterior.getProxima();
				Celula proxima = atual.getProxima();
				anterior.setProxima(proxima);
				proxima.setAnterior(anterior);
				this.totalDeElementos--;
			}
		}
	}

	public boolean contemPrimeiroParaUltimo(int elemento) {
		Celula atual = this.primeira;
		for (int i = 0; i < this.totalDeElementos; i++) {
			if (atual.getElemento() == (elemento)) {
				return (true);
			}

			atual = atual.getProxima();
		}

		return (false);
	}

	public boolean contemUltimoParaPrimeiro(int elemento) {
		Celula atual = this.ultima;
		for (int i = 0; i < this.totalDeElementos; i++) {
			if (atual.getElemento() == (elemento)) {
				return (true);
			}

			atual = atual.getAnterior();
		}

		return (false);
	}

	public int tamanho() {
		return (this.totalDeElementos);
	}

	public void esvaziaLista() {
		this.primeira = null;
		this.ultima = null;
		this.totalDeElementos = 0;
	}

	public String imprimir() {
		if (this.totalDeElementos == 0) {
			return ("[]");
		} else {
			StringBuilder builder = new StringBuilder("[");
			Celula atual = this.primeira;
			for (int i = 0; i < this.totalDeElementos - 1; i++) {
				builder.append(atual.getElemento());
				builder.append(", ");
				atual = atual.getProxima();
			}
			builder.append(atual.getElemento());
			builder.append("]");
			return (builder.toString());
		}
	}

}
