package modelo;

/**
 * A classe correspondente a um investidor qualquer na bolsa. Possui um saldo
 * para compra e uma lista de carteira de ações para compra.
 * 
 * @author Fernando Freitas, Davi Gomes
 */
public class Investidor {

	private Integer codigo;

	private String nome;

	private double saldo;

	private CarteiraDeAcoes carteiraDeAcoes;

	/**
	 * Instancia um novo investidor na bolsa.
	 * 
	 * @param codigo O código de investidor
	 * @param nome   O nome do investidor
	 * @param saldo  O saldo na carteira
	 */
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
	
	public AbstratoAcao removerUltimoPapel() {
		return carteiraDeAcoes.removerUltimaAcao();
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
