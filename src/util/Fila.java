package util;

class Celula<T> {

	T coisa;

	Celula<T> proximo;

	Celula(T coisa) {
		this.coisa = coisa;
		this.proximo = null;
	}

	@Override
	public String toString() {
		return this.coisa + "";
	}
}

/**
 * Essa estrutura se baseia em células que contém o valor da próxima 
 * célula, sendo uma estrutura dinâmica
 * 
 * @author estudante1
 *
 * @param <T> O tipo da fila 
 */
public class Fila<T> {

	/**
	 * O tamanho da fila
	 */
	private int tamanho;

	/**
	 * O primeiro da fila
	 */
	private Celula<T> primeiro;

	public Fila() {
		this.primeiro = null;
		this.tamanho = 0;
	}

	/**
	 * O método percorre cada célula em procura de uma célula que não aponta para um
	 * outro elemento, então o último irá agora apontar para um novo elemento
	 * 
	 * @param elemento O elemento a ser adicionado
	 */
	public void adicionar(T elemento) {
		Celula<T> novaCelula = new Celula<>(elemento);

		if (primeiro == null) {
			primeiro = novaCelula;
		} else {
			Celula<T> atual = primeiro;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			atual.proximo = novaCelula;
		}
		tamanho++;
	}

	/**
	 * O método percorre a lista até o índice especificado, ao chegar nele, a célula
	 * naquele índice virtual irá agora apontar para o novo elemento, e ele por si
	 * irá apontar para o antigo próximo elemento
	 * 
	 * @param elemento O elemento a ser adicionado
	 * @param indice   O indice do novo elemento
	 */
	public void adicionar(T elemento, int indice) {
		Celula<T> novaCelula = new Celula<>(elemento);
		Celula<T> atual = this.primeiro;
		Celula<T> atualProximo = atual.proximo;
		int indiceAtual = 0;


		if (indice == 0) {
			Celula<T> antigoAtual = atual;

			this.primeiro = novaCelula;
			this.primeiro.proximo = antigoAtual;
			tamanho++;

			return;
		}

		indice--;
		while (atual.proximo != null) {

			if (indiceAtual < indice) {
				atual = atual.proximo;
				atualProximo = atual.proximo;

				indiceAtual++;
			} else {
				break;
			}
		}

		if (atual.proximo == null) {
			atual.proximo = novaCelula;
		} else {
			atual.proximo = novaCelula;
			novaCelula.proximo = atualProximo;
		}
		tamanho++;
	}

	/**
	 * Remove e remove da fila o último elemento
	 * 
	 * @return O útimo elemento
	 */
	public T remover() {
		if (this.primeiro == null) {
			throw new RuntimeException("A fila está vazia!");
		}

		primeiro = primeiro.proximo;
		tamanho--;

		return primeiro.coisa;
	}

	public T get(int indice) {
		Celula<T> atual = this.primeiro;

		while (atual.proximo != null) {
			atual = atual.proximo;
		}
		return atual.coisa;
	}

	/**
	 * @return O tamanho da fila
	 */
	public int tamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Celula<T> elemento = this.primeiro;

		sb.append("[ ");

		while (elemento != null) {
			sb.append("(" + elemento + ") ");
			elemento = elemento.proximo;
		}
		sb.append("]");

		return sb.toString();
	}

}