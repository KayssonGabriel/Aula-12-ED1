package exercicio2;

public class Teste {

	public static void main(String[] args) {
		ListaDupla listaDupla = new ListaDupla();

		listaDupla.adicionaNoComeco(1);
		listaDupla.adicionaNoFinal(3);
		listaDupla.adicionaNoFinal(5);
		listaDupla.adicionaNoFinal(7);
		listaDupla.adicionaNoFinal(9);
		System.out.println(listaDupla.contemPrimeiroParaUltimo(3));
		System.out.println(listaDupla.imprimir());
		listaDupla.removePos(1);
		System.out.println(listaDupla.imprimir());


	}

}
