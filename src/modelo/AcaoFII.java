package modelo;

public class AcaoFII extends AbstratoAcao {

	private double cotas;

	public AcaoFII(String nome, Double valor, Double valorEntrada, Double valorFechado, int cotas) {
		super(nome, valor, valorEntrada, valorFechado);
		this.cotas = cotas;
	}
	
	@Override
	public double calcularValor() {
		return valor * cotas;
	}
	
}
