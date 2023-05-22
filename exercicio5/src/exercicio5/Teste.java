package exercicio5;

public class Teste {
	public static void main(String[] args) {
		ListaCircularHead lista = new ListaCircularHead();

		lista.adicionaNoComeco(1);
		lista.adicionaNoFinal(3);
		lista.adicionaNoFinal(5);
		lista.adicionaNoFinal(7);
		lista.adicionaNoFinal(9);
		System.out.println(lista.contem(3));
		System.out.println(lista.imprimir());
		lista.removePos(1);
		System.out.println(lista.imprimir());
	}

}
