package exercicio4;

public class Teste {
	public static void main(String[] args) {
		ListaCircularDupla listaCircularDupla = new ListaCircularDupla();
		ListaCircularDupla listaCircularDupla2 = new ListaCircularDupla();
		ListaCircularDupla listaCircularDupla3 = new ListaCircularDupla();
		ListaCircularDupla listaCircularDupla4 = new ListaCircularDupla();
		ListaCircularDupla listaCircularDupla5 = new ListaCircularDupla();

		listaCircularDupla.adicionaNoComeco(1);
		listaCircularDupla.adicionaNoFinal(5);
		listaCircularDupla.adicionaNaPos(1, 3);
		System.out.println(listaCircularDupla.imprimir());

		listaCircularDupla2.adicionaNoComeco(4);
		listaCircularDupla2.adicionaNoFinal(6);
		listaCircularDupla2.adicionaNoFinal(8);
		System.out.println(listaCircularDupla2.imprimir());

		listaCircularDupla3.adicionaNoComeco(1);
		listaCircularDupla3.adicionaNoFinal(5);
		listaCircularDupla3.adicionaNaPos(1, 3);

		listaCircularDupla4.adicionaNoComeco(2);
		listaCircularDupla4.adicionaNoFinal(4);
		listaCircularDupla4.adicionaNoFinal(6);
		listaCircularDupla4.adicionaNoFinal(8);

		listaCircularDupla5.adicionaNoComeco(1);
		listaCircularDupla5.adicionaNoFinal(2);
		listaCircularDupla5.adicionaNoFinal(3);

		// a)
		System.out.println(listaCircularDupla.contarElementosListaCircular());

		// b)
		listaCircularDupla2.inserirEsquerda(2);
		System.out.println(listaCircularDupla2.imprimir());

		// c)
		listaCircularDupla.concatenarListas(listaCircularDupla2);
		System.out.println(listaCircularDupla.imprimir());

		// d)
		System.out.println(
				listaCircularDupla.intercalarListasOrdenadas(listaCircularDupla3, listaCircularDupla4).imprimir());

		System.out.println(listaCircularDupla5.imprimir());
		// e)
		System.out.println(listaCircularDupla5.copiarLista().imprimir());

	}
}
