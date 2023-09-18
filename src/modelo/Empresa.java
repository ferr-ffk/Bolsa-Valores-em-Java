package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Empresa {

	private int id;

	private static int idBase = 0;

	private final String nome;

	private int cotas;

	private String codigo;

	private static final String EMPRESAS_TXT = "Empresas.txt";

	public Empresa(String nome, String codigo, int cotas) {
		this.nome = nome;
		if (cotas <= 0) {
			throw new RuntimeException("O numero de cotas da empresa não pode ser inferior a zero!");
		}
		this.codigo = codigo;
		this.cotas = cotas;

		registrarEmpresa(this);
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

	@Override
	public String toString() {
		return id + ": {Empresa: " + nome + " \"" + codigo + "\", total de cotas: " + cotas + "}";
	}
}
