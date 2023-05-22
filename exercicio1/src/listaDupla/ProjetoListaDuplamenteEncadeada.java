package listaDupla;

public class ProjetoListaDuplamenteEncadeada {
	public static void main(String[] args) {
		ListaDupla listaDupla = new ListaDupla();
		ListaDupla listaDupla2 = new ListaDupla();

		listaDupla.adicionaNoComeco(1);
		listaDupla.adicionaNoFinal(3);
		listaDupla.adicionaNoFinal(5);
		listaDupla.adicionaNoFinal(7);
		listaDupla.adicionaNoFinal(9);
		System.out.println(listaDupla.imprimir());

		listaDupla2.adicionaNoComeco(2);
		listaDupla2.adicionaNoFinal(4);
		listaDupla2.adicionaNoFinal(6);
		System.out.println(listaDupla2.imprimir());

		
		// teste a)
		listaDupla.concatenarDuasListas(listaDupla2);

		System.out.println(listaDupla.imprimir());
		System.out.println();

		// teste b)
		System.out.println(listaDupla.imprimir());
		System.out.println(listaDupla.dividirLista(5).imprimir());
		System.out.println(listaDupla.imprimir());
		System.out.println();

		// teste c)
		System.out.println(listaDupla.intercalarListasOrdenadas(listaDupla, listaDupla2).imprimir());

	}
}
