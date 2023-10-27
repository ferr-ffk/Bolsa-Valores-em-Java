package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import constantes.LocaisArquivoTexto;

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

	private static String INVESTIDORES_TXT = LocaisArquivoTexto.INVESTIDORES_TXT_PADRAO;

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

		registrarInvestidor(this);
	}

	private void registrarInvestidor(Investidor investidor) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(INVESTIDORES_TXT), true));
			BufferedReader reader = new BufferedReader(new FileReader(INVESTIDORES_TXT));

			writer.write(investidor.toString() + "\n");

			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adicionarPapel(AbstratoAcao ap) {
		if (ap.calcularValor() > saldo) {
			throw new RuntimeException("A carteira não possui saldo suficiente!");
		}

		this.carteiraDeAcoes.adicionarAcao(ap);
		this.saldo -= ap.calcularValor();

		atualizarInvestidor(this);
	}

	private void atualizarInvestidor(Investidor investidor) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(INVESTIDORES_TXT), true));
			BufferedReader reader = new BufferedReader(new FileReader(INVESTIDORES_TXT));

			String linha;

			while ((linha = reader.readLine()) != null) {
				// verifica se o código dado pelo método é igual ao código armazenado do
				// investidor
				if (linha.substring(0, 6).equals(investidor.toString().substring(0, 6))) {
					System.out.println("Remover linha = " + linha);
					
					writer.write(investidor.toString());

					writer.close();
					reader.close();
					return;
				}
			}

			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AbstratoAcao removerUltimoPapel() {
		return carteiraDeAcoes.removerUltimaAcao();
	}

	@Override
	public String toString() {
		return codigo + ": {" + nome + ", saldo: " + saldo + ", acoes: " + carteiraDeAcoes + "}";
	}

	public void comprarAcao(AbstratoAcao acao) {
		if (acao.calcularValor() > saldo) {
			throw new RuntimeException("Saldo insuficiente: " + saldo + " é menor que " + acao.calcularValor());
		}

		saldo -= acao.getValor();
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
