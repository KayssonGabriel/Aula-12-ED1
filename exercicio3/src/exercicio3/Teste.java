package exercicio3;

public class Teste {
	public static void main(String[] args) {
		ListaCircularSimples listaCircular = new ListaCircularSimples();
		ListaCircularSimples listaCircular2 = new ListaCircularSimples();
		ListaCircularSimples listaCircular3 = new ListaCircularSimples();
		ListaCircularSimples listaCircular4 = new ListaCircularSimples();
		ListaCircularSimples listaCircular5 = new ListaCircularSimples();

		listaCircular.adicionaNoComeco(1);
		listaCircular.adicionaNoFinal(5);
		listaCircular.adicionaNaPos(1, 3);
		System.out.println(listaCircular.imprimir());

		listaCircular2.adicionaNoComeco(4);
		listaCircular2.adicionaNoFinal(6);
		listaCircular2.adicionaNoFinal(8);
		System.out.println(listaCircular2.imprimir());

		listaCircular3.adicionaNoComeco(1);
		listaCircular3.adicionaNoFinal(5);
		listaCircular3.adicionaNaPos(1, 3);

		listaCircular4.adicionaNoComeco(2);
		listaCircular4.adicionaNoFinal(4);
		listaCircular4.adicionaNoFinal(6);
		listaCircular4.adicionaNoFinal(8);

		listaCircular5.adicionaNoComeco(1);
		listaCircular5.adicionaNoFinal(2);
		listaCircular5.adicionaNoFinal(3);

		// a)
		System.out.println(listaCircular.contarElementosListaCircular());

		// b)
		listaCircular2.inserirEsquerda(2);
		System.out.println(listaCircular2.imprimir());

		// c)
		listaCircular.concatenarListas(listaCircular2);
		System.out.println(listaCircular.imprimir());

		// d)
		System.out.println(listaCircular.intercalarListasOrdenadas(listaCircular3, listaCircular4).imprimir());

		System.out.println(listaCircular5.imprimir());
		// e)
		System.out.println(listaCircular5.copiarLista().imprimir());

	}
}
