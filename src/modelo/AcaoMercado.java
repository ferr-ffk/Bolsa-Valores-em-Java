package modelo;

public class AcaoMercado extends AbstratoAcao {

	private int cotas;
	
	private Empresa empresa;
	
	public AcaoMercado(String nome, Double valor, int cotas, Empresa empresa) {
		super(nome, valor, 0.0, 0.0);
	
		if(empresa == null) {
			throw new RuntimeException("Valor para empresa inválido: " + empresa);
		}
		
		this.cotas = cotas;
		this.empresa = empresa;
	}
	
	@Override
	public double calcularValor() {
		return this.getValor() * cotas;
	}

	@Override
	public String toString() {
		return empresa.getNome() +  " tem " + cotas + " cotas";
	}
}
