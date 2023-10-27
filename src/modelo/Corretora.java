package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import constantes.LocaisArquivoTexto;
import util.Pilha;

/**
 * <p>
 * A classe corretora representa uma empresa responsável por enviar ordens de
 * compra e venda entre um investidor e a empresa vendendo as cotas.
 * 
 * 
 * @author Fernando Freitas, Davi Gomes
 */
public class Corretora {

	private String nome;

	private Integer codigo;

	private static String HISTORICO_ORDENS_TXT = LocaisArquivoTexto.HISTORICO_ORDENS_TXT_PADRAO;

	private BufferedReader reader;

	private Pilha<String> ordensEfetuadas = new Pilha<>();

	private static int idBase = 0;

	/**
	 * Instancia uma nova corretora na bolsa de valores.
	 * 
	 * @param nome   O nome da corretora
	 * @param codigo O código da corretora
	 */
	public Corretora(String nome, Integer codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public static void setCaminhoArquivo(String caminho) {
		HISTORICO_ORDENS_TXT = caminho;
	}

	/**
	 * Realiza a ordem de compra para o investidor, além de registrar no arquivo de
	 * texto. Para total segurança, certifica que o investidor tem poder de compra e
	 * depois adiciona em sua carteira de ações. Posteriormente subtrai da empresa
	 * uma cota.
	 * 
	 * 
	 * @param a A ação a ser comprada pelo investidor
	 * @param i O investidor realizando o papel de comprador
	 * @param emp A empresa a vender a cota
	 */
	public void enviarOrdem(AbstratoAcao a, Investidor i, Empresa emp) {
		i.adicionarPapel(a);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(HISTORICO_ORDENS_TXT), true));
			reader = new BufferedReader(new FileReader(HISTORICO_ORDENS_TXT));

			Character idChar = reader.readLine() == null ? null : reader.readLine().charAt(0);

			int id;

			if (idChar == null) {
				id = idBase++;
			} else {
				String linha;

				while ((linha = reader.readLine()) != null) {
					idChar = linha.charAt(0);
				}

				idBase = Integer.parseInt(idChar.toString());
				id = idBase++;
			}

			String ordem = id + ": Ordem da empresa " + emp + " realizada por " + nome + ": " + a + " enviada para " + i + " às" + new Date();
			ordensEfetuadas.empilhar(ordem);

			writer.write("\n" + ordem);

			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removerUltimaOrdem() {
		String ultimaOrdem = ordensEfetuadas.desempilhar();
		System.out.println(ultimaOrdem + " removida com sucesso");
	}

	public void exibirOrdens() {
		System.out.println("Ordens efetuadas:");

		try {
			reader = new BufferedReader(new FileReader(HISTORICO_ORDENS_TXT));

			if (reader.readLine() == null) {
				System.out.println("Nenhuma ordem efetuada");
				return;
			}

			String linha;

			while ((linha = reader.readLine()) != null) {
				System.out.println(linha);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
