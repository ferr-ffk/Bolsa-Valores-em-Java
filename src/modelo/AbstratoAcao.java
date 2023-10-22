package modelo;

public abstract class AbstratoAcao {

	protected String nome;

	protected float valor;

	protected float valorEntrada;

	protected float valorFechado;

	public AbstratoAcao(String nome, float valor, float valorEntrada, float valorFechado) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.valorEntrada = valorEntrada;
		this.valorFechado = valorFechado;
	}

	public abstract double calcularValor();
	
	public float getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return String.format("{(Acao): %s, R$%.2f}", nome, valor);
	}
}
