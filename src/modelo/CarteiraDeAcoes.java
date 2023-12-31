package modelo;

import util.Fila;

public class CarteiraDeAcoes {

	private Fila<AbstratoAcao> acoes;
	
	public CarteiraDeAcoes() {
		acoes = new Fila<AbstratoAcao>();
	}
	
	public void adicionarAcao(AbstratoAcao a) {
		acoes.adicionar(a);
	}
	
	public AbstratoAcao removerUltimaAcao() {
		return acoes.remover();
	}
	
	@Override
	public String toString() {
		return acoes.toString();
	}
}
