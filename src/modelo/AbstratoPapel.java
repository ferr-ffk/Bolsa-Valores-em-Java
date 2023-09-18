package modelo;

public abstract class AbstratoPapel {

	protected String nome;
	
	protected Double valor;
	
	protected Double valorEntrada;
	
	protected Double valorFechado;

	public AbstratoPapel(String nome, Double valor, Double valorEntrada, Double valorFechado) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.valorEntrada = valorEntrada;
		this.valorFechado = valorFechado;
	}
	
	public abstract double calcularValor();
}
