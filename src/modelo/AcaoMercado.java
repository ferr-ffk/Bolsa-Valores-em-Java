package modelo;

public class AcaoMercado extends AbstratoAcao {

	private int cotas;
	
	private Empresa empresa;
	
	public AcaoMercado(String nome, float valor, int cotas, Empresa empresa) {
		super(nome, valor, 0.0f, 0.0f);
	
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
