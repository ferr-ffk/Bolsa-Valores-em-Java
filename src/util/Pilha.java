package util;

/**
 * 
 * Uma pilha é uma estrutura genérica para remoção de elementos por LIFO
 * Esta estrutura utiliza células que contém a referência do próximo elemento
 * 
 * @author fefe
 *
 * @param <T> O tipo da pilha
 */
public class Pilha<T> {

	class Celula<K> {
		K coisa;

		Celula<K> proximo;

		Celula(K coisa) {
			this.coisa = coisa;
			this.proximo = null;
		}

		@Override
		public String toString() {
			return this.coisa + "";
		}
	}

	/**
	 * Também chamado de sentinela, será onde será executada as operações lifo
	 */
	private Celula<T> topo;

	/**
	 * O tamanho da pilha
	 */
	private int tamanho;

	/**
	 * @param A capacidade da pilha
	 */
	public Pilha() {
		topo = null;
	}

	/**
	 * Adiciona um elemento na pilha
	 * 
	 * @param e O elemento a ser adicionado
	 */
	public void empilhar(T e) {
		Celula<T> novaCelula = new Celula<>(e);

		if (topo == null) {
			topo = novaCelula;
		} else {
			Celula<T> atual = topo;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			atual.proximo = novaCelula;
		}
		tamanho++;
	}

	/**
	 * Retorna e remove o topo (primeiro elemento)
	 * 
	 * @return O sentinela
	 * 
	 */
	public T desempilhar() {
		Celula<T> ultimo = this.topo;

		if (this.topo.proximo == null) {
			throw new RuntimeException("A fila está vazia!");
		}

		while (ultimo.proximo.proximo != null) {
			ultimo = ultimo.proximo;
		}

		T coisa = ultimo.proximo.coisa;
		ultimo.proximo = null;
		tamanho--;

		return coisa;
		
	}

	public boolean taVazio() {
		return tamanho == 0;
	}

	public T topo() {
		return topo.coisa;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Celula<T> elemento = this.topo;

		sb.append("[ ");

		while (elemento != null) {
			sb.append("(" + elemento + ") ");
			elemento = elemento.proximo;
		}
		sb.append("]");

		return sb.toString();
	}
}