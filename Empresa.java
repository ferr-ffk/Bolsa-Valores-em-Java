package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import constantes.LocaisArquivoTexto;

/**
 * <p>
 * Uma empresa registrada na bolsa de valores terá componentes básicos de nome,
 * e código. Além de contar com o número de cotas e o valor delas.
 */
public class Empresa {

	private int id;

	private static int idBase = 0;

	private final String nome;

	private int cotas;

	private float valorCota;

	private String codigo;

	private TipoAcaoEmpresa tipoAcaoEmpresa;

	private static String EMPRESAS_TXT = LocaisArquivoTexto.EMPRESAS_TXT_PADRAO;

	/**
	 * Instancia uma nova empresa e logo registra ela no arquivo de texto.
	 * 
	 * @param nome      O nome da empresa
	 * @param codigo    O código da empresa na bolsa de valores
	 * @param cotas     O número de cotas da empresa
	 * @param valorCota O valor de cada cota individual da empresa
	 */
	public Empresa(String nome, String codigo, int cotas, float valorCota, TipoAcaoEmpresa tipoAcaoEmpresa) {
		this.nome = nome;
		if (cotas <= 0) {
			throw new RuntimeException("O numero de cotas da empresa não pode ser inferior a zero!");
		}
		this.codigo = codigo;
		this.cotas = cotas;
		this.valorCota = valorCota;
		this.tipoAcaoEmpresa = tipoAcaoEmpresa;

		registrarEmpresa(this);
	}

	public static void setCaminhoArquivo(String caminho) {
		EMPRESAS_TXT = caminho;
	}

	public int obterNumeroCotas() {
		return this.cotas;
	}

	public float obterValorEmpresa() {
		return this.cotas * valorCota;
	}

	/**
	 * <p>
	 * O método utilizado para uma eventual ordem de compra de ações dessa empresa.
	 * <p>
	 * Cada empresa possui um número de ações (cotas), além de retirar uma cota
	 * dela.
	 * 
	 * @return uma acao da empresa
	 */
	public AbstratoAcao obterAcao() {
		comprarCotas(cotas);

		if (tipoAcaoEmpresa == TipoAcaoEmpresa.ACAO_FII) {

			return new AcaoFII("Acao FII", this.valorCota, 0.0f, 0.0f, cotas);
		} else if (tipoAcaoEmpresa == TipoAcaoEmpresa.ACAO_MERCADO) {

			return new AcaoMercado("Acao Mercado", this.valorCota, this.cotas, this);
		} else {
			throw new RuntimeException("Tipo de Acao da empresa nulo!");
		}
	}

	private void registrarEmpresa(Empresa empresa) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EMPRESAS_TXT), true));
			BufferedReader reader = new BufferedReader(new FileReader(EMPRESAS_TXT));

			Character idChar = reader.readLine() == null ? null : reader.readLine().charAt(0);

			if (idChar.equals(null)) {
				id = idBase++;
			} else {
				String linha;

				while ((linha = reader.readLine()) != null) {
					idChar = linha.charAt(0);
				}

				idBase = Integer.parseInt(idChar.toString()) + 1;
				id = idBase++;
			}

			writer.write(empresa.toString() + "\n");

			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void comprarCotas(int cotas) {
		if (this.cotas == 0 || this.cotas < cotas) {
			throw new RuntimeException("O numero de cotas da empresa não pode ser inferior a zero!");
		}
		this.cotas -= cotas;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Exibe todas as empresas registradas.
	 */
	public static void exibirEmpresas() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(EMPRESAS_TXT)));

			String linha;

			if (reader.readLine() == null) {
				System.out.println("Nenhuma empresa cadastrada");
				return;
			}

			while ((linha = reader.readLine()) != null) {
				System.out.println(linha);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * <p> Busca no arquivo de texto uma empresa correspondente ao indice dado pelo usuário.
	 * <p> Se não for encontrado, retorna uma string vazia
	 * 
	 * @param indice O índice do elemento
	 * @return A string da empresa
	 */
	public static String obterEmpresa(Integer indice) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(EMPRESAS_TXT)));

			String linha;

			if (reader.readLine() == null) {
				return "Nenhuma empresa cadastrada";
			}

			while ((linha = reader.readLine()) != null) {
				String charAt = String.valueOf(linha.charAt(0));
				
				if (Integer.parseInt(charAt) == indice) {
					reader.close();
					return linha;
				} else {
					continue;
				}
			}

			reader.close();
			return "Empresa de índice " + indice + " não encontrada!";
		} catch (IOException e) {
			e.printStackTrace();
		}

		throw new RuntimeException("Alguma coisa deu errado ne pae");
	}

	@Override
	public String toString() {
		return id + ": {Empresa: " + nome + " \"" + codigo + "\", total de cotas: " + cotas + ", valor da empresa: "
				+ obterValorEmpresa() + "}";
	}
}
