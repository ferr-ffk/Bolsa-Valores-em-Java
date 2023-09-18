package modelo;

import util.Fila;

public class Investidor {

	private Integer codigo;

	private String nome;

	private double saldo;

	private CarteiraDeAcoes carteiraDeAcoes;

	public Investidor(Integer codigo, String nome, double saldo) {
		this.codigo = codigo;
		this.nome = nome;
		this.saldo = saldo;
		this.carteiraDeAcoes = new CarteiraDeAcoes();
	}

	public void adicionarPapel(AbstratoAcao ap) {
		if (ap.calcularValor() > saldo) {
			throw new RuntimeException("A carteira não possui saldo suficiente!");
		}

		this.carteiraDeAcoes.adicionarAcao(ap);
		this.saldo -= ap.calcularValor();
	}

	@Override
	public String toString() {
		return "{" + nome + ", saldo: " + saldo + ", acoes: " + carteiraDeAcoes + "}";
	}

	public void comprarAcao(AbstratoAcao acao) {
		if (acao.calcularValor() > saldo) {
			throw new RuntimeException("Saldo insuficiente: " + saldo + " é menor que " + acao.calcularValor());
		}

		carteiraDeAcoes.adicionarAcao(acao);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
