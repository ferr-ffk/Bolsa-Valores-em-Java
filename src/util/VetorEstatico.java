package util;

import java.util.Arrays;

public class VetorEstatico<T> {

	private int tamanho;
	private int capacidade;
	private Object[] elementos;

	public VetorEstatico(int capacidade) {
		if (0 > capacidade) {
			throw new RuntimeException("A capacidade do vetor não pode ser menor que zero!");
		}
		this.elementos = new Object[++capacidade];
		this.tamanho = 0;
		this.capacidade = capacidade;
	}

	public boolean taVazio() {
		return tamanho == 0;
	}

	public boolean taCheio() {
		return tamanho == capacidade;
	}

	public boolean temCelulaVazia(int indice) {
		return elementos[indice] == null;
	}

	public void adicionar(T elemento) {
		if (!this.taCheio()) {
			for (int i = 0; i < this.capacidade - 1; i++) {
				if (temCelulaVazia(i)) {
					this.adicionar(elemento, i);
					this.tamanho++;
					return;
				}
			}
		} else {
			throw new RuntimeException("O vetor está cheio!");
		}
	}

	public void adicionar(T elemento, int indice) {
		if (elementos[indice] == null) {
			this.tamanho++;
		}
		this.elementos[indice] = elemento;
	}

	public void remover(int indice) {
		if (indice >= capacidade || indice < 0) {
			throw new RuntimeException("O indíce está fora do alcance!");
		}
		elementos[indice] = null;
		this.tamanho--;
	}

	public void removerElemento(T elemento) {
		for (int i = 0; i < this.tamanho - 1; i++) {
			if (elementos[i].equals(elemento)) {
				elementos[i] = null;
				this.tamanho--;
				return;
			}
		}
		throw new RuntimeException("O item não foi encontrado!");
	}

	@Override
	public String toString() {
		return Arrays.toString(elementos);
	}

	public int tamanho() {
		return this.tamanho;
	}

	public int capacidade() {
		return this.capacidade;
	}
}
