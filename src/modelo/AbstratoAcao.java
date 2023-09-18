package modelo;

public abstract class AbstratoAcao {

	protected String nome;

	protected Double valor;

	protected Double valorEntrada;

	protected Double valorFechado;

	public AbstratoAcao(String nome, Double valor, Double valorEntrada, Double valorFechado) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.valorEntrada = valorEntrada;
		this.valorFechado = valorFechado;
	}

	public abstract double calcularValor();
	
	public Double getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return String.format("{(Acao): %s, R$%.2f}", nome, valor);
	}
}
